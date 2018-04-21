package test;

import static org.junit.Assert.*;

import org.junit.Test;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import ui.PrintRequestGetter;

import org.junit.Before;
import org.junit.runner.RunWith;

import code.DesignEffectOption;
import code.DisplayUtility;
import code.HighQualityPaperOption;
import code.PrintOption;
import code.PrintRequest;
import exceptions.InvalidOptionException;
import exceptions.InvalidQuantityException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashSet;


@RunWith(JUnitParamsRunner.class)
public class TestPrintRequestGetter {
	DisplayUtility mockDisplayUtility;
	PrintRequestGetter printRequestGetter;

	@Before
	public void setupForAllTests() {
		this.mockDisplayUtility = mock(DisplayUtility.class);
		this.printRequestGetter = new PrintRequestGetter(mockDisplayUtility);
	}

	@Test(expected = NumberFormatException.class)
	@Parameters(method = "getInvalidFormattedQuantity")
	public void test_invalidFormattedQuantity(String quantity) throws Exception {
		when(this.mockDisplayUtility.getFromScreen()).thenReturn(quantity);
		this.printRequestGetter.getPrintRequest();
	}

	public Object[] getInvalidFormattedQuantity() {
		return new String[] { "a", "1.0", "k12" };
	}

	@Test(expected = InvalidQuantityException.class)
	@Parameters(method = "getInvalidQuantity")
	public void test_invalidQuantity(String quantity) throws Exception {
		when(this.mockDisplayUtility.getFromScreen()).thenReturn(quantity);
		this.printRequestGetter.getPrintRequest();
	}

	public Object[] getInvalidQuantity() {
		return new String[] { "0", "101" };
	}

	@Test(expected = InvalidOptionException.class)
	@Parameters(method = "getInvalidOptions")
	public void test_invalidOptions(String option) throws Exception {
		String aValidQuantity = "1";
		when(this.mockDisplayUtility.getFromScreen()).thenReturn(aValidQuantity, option);
		this.printRequestGetter.getPrintRequest();
	}

	public Object[] getInvalidOptions() {
		return new String[] { "0", "5", "a" };
	}

	@Test
	@Parameters(method = "getValidInput")
	public void test_validInput(String quantity, String option, String imagePath, PrintRequest expected)
			throws Exception {
		when(this.mockDisplayUtility.getFromScreen()).thenReturn(quantity, option, imagePath);
		PrintRequest actualPrintRequest = this.printRequestGetter.getPrintRequest();
		assertTrue(actualPrintRequest.equals(expected));

	}

	public Object[] getValidInput() {
		String sampleImagePath = "~/myimage.png";
		return new Object[] {
				new Object[] { "1", "4", sampleImagePath,
						new PrintRequest(1, new HashSet<PrintOption>(), sampleImagePath) },

				new Object[] { "1", "1", sampleImagePath,
						new PrintRequest(1, new HashSet<PrintOption>(Arrays.asList(new HighQualityPaperOption())),
								sampleImagePath) },

				new Object[] { "1", "2", sampleImagePath,
						new PrintRequest(1, new HashSet<PrintOption>(Arrays.asList(new DesignEffectOption())),
								sampleImagePath) },

				new Object[] { "100", "3", sampleImagePath,
						new PrintRequest(100,
								new HashSet<PrintOption>(
										Arrays.asList(new DesignEffectOption(), new HighQualityPaperOption())),
								sampleImagePath) },

				new Object[] { "100", "3", sampleImagePath,
						new PrintRequest(100,
								new HashSet<PrintOption>(
										Arrays.asList(new HighQualityPaperOption(), new DesignEffectOption())),
								sampleImagePath) }, 
		};
	}

}

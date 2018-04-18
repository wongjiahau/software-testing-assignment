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

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashSet;

import static org.mockito.Mockito.anyList;
import static org.mockito.Mockito.anyListOf;
import static org.mockito.Mockito.anyObject;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.inOrder;

@RunWith(JUnitParamsRunner.class)
public class TestPrintRequestGetter {
	DisplayUtility mockDisplayUtility;
	PrintRequestGetter printRequestGetter;
	@Before
	public void setupForAllTests() {
		this.mockDisplayUtility = mock(DisplayUtility.class);
		this.printRequestGetter = new PrintRequestGetter(mockDisplayUtility);
	}	

	@Test(expected=NumberFormatException.class)
	@Parameters(method="getInvalidQuantity")
	public void test_invalidQuantity(String quantity) throws Exception {
		when(this.mockDisplayUtility.getFromScreen()).thenReturn(quantity);
		this.printRequestGetter.getPrintRequest();
	}

	public Object[] getInvalidQuantity() {
		return new String[] { "a", "1.0", "k12", "0", "101"};
	}


	@Test(expected=InvalidOptionException.class)
	@Parameters(method="getInvalidOptions")
	public void test_invalidOptions(String option) throws Exception {
		String aValidQuantity = "1";
		when(this.mockDisplayUtility.getFromScreen()).thenReturn(aValidQuantity, option);
		this.printRequestGetter.getPrintRequest();
	}

	public Object[] getInvalidOptions() {
		return new String[] {"0", "5", "a"};
	}

	@Test
	@Parameters(method="getValidInput") 
	public void test_validInput(String quantity, String option, PrintRequest expected) throws Exception {
		when(this.mockDisplayUtility.getFromScreen()).thenReturn(quantity, option);
		PrintRequest actualPrintRequest = this.printRequestGetter.getPrintRequest();
		assertTrue(actualPrintRequest.equals(expected));
		
	}

	public Object[] getValidInput() {
		return new Object[] {
			new Object[] {"1", "4", new PrintRequest(1, new HashSet<PrintOption>(), null)},
			new Object[] {"1", "1", new PrintRequest(1, new HashSet<PrintOption>(Arrays.asList(new HighQualityPaperOption())), null)},
			new Object[] {"1", "2", new PrintRequest(1, new HashSet<PrintOption>(Arrays.asList(new DesignEffectOption())), null)},
			new Object[] {"100", "3", new PrintRequest(100, new HashSet<PrintOption>(Arrays.asList(new DesignEffectOption(), new HighQualityPaperOption())), null)},
			new Object[] {"100", "3", new PrintRequest(100, new HashSet<PrintOption>(Arrays.asList(new HighQualityPaperOption(), new DesignEffectOption())), null)},
		};
	}

	

}

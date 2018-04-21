package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import junitparams.JUnitParamsRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import code.DesignEffectOption;
import code.HighQualityPaperOption;
import code.PrintOption;
import code.PrintRequest;


@RunWith(JUnitParamsRunner.class)
public class TestPrintRequest {

	@Test
	public void test_equals() {
		PrintRequest pr1 = new PrintRequest(1, new HashSet<PrintOption>(Arrays.asList(new HighQualityPaperOption())), null);
		PrintRequest pr2 = new PrintRequest(1, new HashSet<PrintOption>(Arrays.asList(new HighQualityPaperOption())), null);
		assertTrue(pr1.equals(pr2));
	}

	@Test
	public void test_notEquals_differentQuantity() {
		PrintRequest pr1 = new PrintRequest(1, new HashSet<PrintOption>(Arrays.asList(new HighQualityPaperOption())), null);
		PrintRequest pr2 = new PrintRequest(2, new HashSet<PrintOption>(Arrays.asList(new HighQualityPaperOption())), null);
		assertFalse(pr1.equals(pr2));
	}

	@Test
	public void test_notEquals_differentOption() {
		PrintRequest pr1 = new PrintRequest(1, new HashSet<PrintOption>(Arrays.asList(new HighQualityPaperOption())), null);
		PrintRequest pr2 = new PrintRequest(1, new HashSet<PrintOption>(Arrays.asList(new DesignEffectOption())), null);
		assertFalse(pr1.equals(pr2));
	}

}



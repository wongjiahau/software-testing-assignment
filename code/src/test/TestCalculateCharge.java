package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;

import code.CalculateCharge;
import code.DesignEffectOption;
import code.HighQualityPaperOption;
import code.PrintOption;
import code.PrintRequest;


@RunWith (JUnitParamsRunner.class)
public class TestCalculateCharge {
	private Object[] getParams() {
		HashSet<PrintOption> noOption         = 
			new HashSet<PrintOption>();
		HashSet<PrintOption> highQualityPaper = 
			new HashSet<PrintOption>(Arrays.asList(new HighQualityPaperOption()));
		HashSet<PrintOption> designEffect     = 
			new HashSet<PrintOption>(Arrays.asList(new DesignEffectOption()));
		HashSet<PrintOption> bothOptions      = 
			new HashSet<PrintOption>(Arrays.asList(new HighQualityPaperOption(),new DesignEffectOption()));

		return new Object[] {
			new Object[] {1  , noOption, 1.00},
			new Object[] {4  , noOption, 1.00},
			new Object[] {5  , noOption, 0.90},
			new Object[] {10 , noOption, 0.90},
			new Object[] {11 , noOption, 0.70},
			new Object[] {20 , noOption, 0.70},
			new Object[] {21 , noOption, 0.50},
			new Object[] {50 , noOption, 0.50},
			new Object[] {51 , noOption, 0.10},
			new Object[] {100, noOption, 0.10},
			new Object[] {1  , highQualityPaper, 1.10},
			new Object[] {4  , highQualityPaper, 1.10},
			new Object[] {5  , highQualityPaper, 1.00},
			new Object[] {10 , highQualityPaper, 1.00},
			new Object[] {11 , highQualityPaper, 0.80},
			new Object[] {20 , highQualityPaper, 0.80},
			new Object[] {21 , highQualityPaper, 0.60},
			new Object[] {50 , highQualityPaper, 0.60},
			new Object[] {51 , highQualityPaper, 0.20},
			new Object[] {100, highQualityPaper, 0.20},
			new Object[] {1  , designEffect, 1.10},
			new Object[] {4  , designEffect, 1.10},
			new Object[] {5  , designEffect, 1.00},
			new Object[] {10 , designEffect, 1.00},
			new Object[] {11 , designEffect, 0.80},
			new Object[] {20 , designEffect, 0.80},
			new Object[] {21 , designEffect, 0.60},
			new Object[] {50 , designEffect, 0.60},
			new Object[] {51 , designEffect, 0.20},
			new Object[] {100, designEffect, 0.20},
			new Object[] {1  , bothOptions, 1.20},
			new Object[] {4  , bothOptions, 1.20},
			new Object[] {5  , bothOptions, 1.10},
			new Object[] {10 , bothOptions, 1.10},
			new Object[] {11 , bothOptions, 0.90},
			new Object[] {20 , bothOptions, 0.90},
			new Object[] {21 , bothOptions, 0.70},
			new Object[] {50 , bothOptions, 0.70},
			new Object[] {51 , bothOptions, 0.30},
			new Object[] {100, bothOptions, 0.30},
		};
	}

	@Parameters(method = "getParams")
	@Test
	public void testBoundaries(int quantity, Set<PrintOption> options, double expectedChargePerPiece) 
		throws Exception {
		PrintRequest printRequest = new PrintRequest(quantity, options, null);
		double result = new CalculateCharge().getChargePerPiece(printRequest);
		assertEquals(expectedChargePerPiece, result, 0.0001);
	}

	@Test(expected=Exception.class)
	public void testExceptions1_shouldThrowIfQuantityLessThanOne() throws Exception {
		PrintRequest printRequest = new PrintRequest(0, null, null);
		double result = new CalculateCharge().getChargePerPiece(printRequest);
		
	}

	@Test(expected=Exception.class)
	public void testExceptions2_shouldThrowIfQuantityMoreThanHundred() throws Exception {
		PrintRequest printRequest = new PrintRequest(101, null, null);
		double result = new CalculateCharge().getChargePerPiece(printRequest);
	}



}

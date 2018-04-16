package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import sun.misc.IOUtils;

import org.junit.runner.RunWith;

import code.CalculateCharge;
import code.DesignEffectOption;
import code.HighQualityPaperOption;
import code.PrintOption;
import code.PrintRequest;

@RunWith(JUnitParamsRunner.class)
public class TestCalculateCharge {
	Scanner inputDataScanner;
	public TestCalculateCharge() throws Exception {
		super();
		File file = new File("TestCalculateCharge.data.txt");
		this.inputDataScanner = new Scanner(file);
	}

	private Object[] getParams() {
		HashSet<PrintOption> noOption = new HashSet<PrintOption>();
		HashSet<PrintOption> highQualityPaper = new HashSet<PrintOption>(Arrays.asList(new HighQualityPaperOption()));
		HashSet<PrintOption> designEffect = new HashSet<PrintOption>(Arrays.asList(new DesignEffectOption()));
		HashSet<PrintOption> bothOptions = new HashSet<PrintOption>(
				Arrays.asList(new HighQualityPaperOption(), new DesignEffectOption()));

		ArrayList<Object> params = new ArrayList<Object>();
		while(this.inputDataScanner.hasNextLine()) {
			String[] data = this.inputDataScanner.nextLine().split(",");
			ArrayList<Object> param =  new ArrayList<Object>();
			param.add(Integer.parseInt(data[0].trim()));
			param.add(
				data[1].trim().equals("0") ? noOption : 
				data[1].trim().equals("1") ? highQualityPaper :
				data[1].trim().equals("2") ? designEffect :
				data[1].trim().equals("3") ? bothOptions : null
			);
			param.add(Double.parseDouble(data[2].trim()));
			params.add(param.toArray());
		}
		return params.toArray();
	}

	@Parameters(method = "getParams")
	@Test
	public void testBoundaries(int quantity, Set<PrintOption> options, double expectedChargePerPiece) throws Exception {
		PrintRequest printRequest = new PrintRequest(quantity, options, null);
		double result = new CalculateCharge().getChargePerPiece(printRequest);
		assertEquals(expectedChargePerPiece, result, 0.0001);
	}

	@Test(expected = Exception.class)
	public void testExceptions1_shouldThrowIfQuantityLessThanOne() throws Exception {
		PrintRequest printRequest = new PrintRequest(0, null, null);
		double result = new CalculateCharge().getChargePerPiece(printRequest);

	}

	@Test(expected = Exception.class)
	public void testExceptions2_shouldThrowIfQuantityMoreThanHundred() throws Exception {
		PrintRequest printRequest = new PrintRequest(101, null, null);
		double result = new CalculateCharge().getChargePerPiece(printRequest);
	}

}

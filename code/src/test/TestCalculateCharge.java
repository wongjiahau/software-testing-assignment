package test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.runner.RunWith;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.spy;

import code.CalculateCharge;
import code.DesignEffectOption;
import code.HighQualityPaperOption;
import code.Order;
import code.PrintOption;
import code.PrintRequest;

@RunWith(JUnitParamsRunner.class)
public class TestCalculateCharge {
	Scanner inputDataScanner;
	HashSet<PrintOption> noOption = new HashSet<PrintOption>();
	HashSet<PrintOption> highQualityPaper = new HashSet<PrintOption>(Arrays.asList(new HighQualityPaperOption()));
	HashSet<PrintOption> designEffect = new HashSet<PrintOption>(Arrays.asList(new DesignEffectOption()));
	HashSet<PrintOption> bothOptions = new HashSet<PrintOption>(
			Arrays.asList(new HighQualityPaperOption(), new DesignEffectOption()));

	public TestCalculateCharge() throws Exception {
		super();
		File file = new File("TestCalculateCharge.data.txt");
		this.inputDataScanner = new Scanner(file);
	}

	private Object[] getParams() {
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
	public void test_getChargePerPiece_Boundaries(int quantity, Set<PrintOption> options, double expectedChargePerPiece) throws Exception {
		PrintRequest printRequest = new PrintRequest(quantity, options, null);
		double result = new CalculateCharge().getChargePerPiece(printRequest);
		assertEquals(expectedChargePerPiece, result, 0.0001);
	}

	@Test(expected = Exception.class)
	public void test_getChargePerPiece_shouldThrowIfQuantityLessThanOne() throws Exception {
		PrintRequest printRequest = new PrintRequest(0, noOption, null);
		double result = new CalculateCharge().getChargePerPiece(printRequest);

	}

	@Test(expected = Exception.class)
	public void test_getChargePerPiece_shouldThrowIfQuantityMoreThanTwo() throws Exception {
		PrintRequest printRequest = new PrintRequest(101, noOption, null);
		double result = new CalculateCharge().getChargePerPiece(printRequest);
	}

	@Test
	public void test_getPrintRequestCharge_case1() throws Exception {
		// Only 1 unit test is needed for this module because it is dependant getChargePerPiece
		PrintRequest printRequest = new PrintRequest(77, noOption, null);
		CalculateCharge calculateCharge = spy(new CalculateCharge());
		double result = calculateCharge.getPrintRequestCharge(printRequest);
		verify(calculateCharge, times(1)).getChargePerPiece(printRequest);
		assertEquals(7.7, result, 0);
	}

	@Test
	public void test_getOrderCharge_case1() throws Exception {
		// Only 1 unit test is needed for this module because it is dependant getPrintRequestCharge
		PrintRequest printRequest1 = new PrintRequest(99, noOption, null);
		PrintRequest printRequest2 = new PrintRequest(1, bothOptions, null);
		Order order = new Order(new ArrayList<PrintRequest>(Arrays.asList(printRequest1, printRequest2)));
		CalculateCharge calculateCharge = spy(new CalculateCharge());
		double result = calculateCharge.getOrderCharge(order);
		verify(calculateCharge, times(1)).getPrintRequestCharge(printRequest1);
		verify(calculateCharge, times(1)).getPrintRequestCharge(printRequest2);
		assertEquals(11.1, result, 0.00001);
	}

	@Test(expected = Exception.class)
	public void test_getOrderCharge_shouldThrowIfNoPrintRequests() throws Exception {
		Order order = new Order(new ArrayList<PrintRequest>());
		CalculateCharge calculateCharge = spy(new CalculateCharge());
		double result = calculateCharge.getOrderCharge(order);
	}
	
}

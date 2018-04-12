package test;

import static org.junit.Assert.*;

import org.junit.Test;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InOrder;

import code.DisplayUtility;
import code.InvalidOptionException;
import code.OrderGetter;
import code.PrintRequest;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyList;
import static org.mockito.Mockito.anyListOf;
import static org.mockito.Mockito.anyObject;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.inOrder;

@RunWith(JUnitParamsRunner.class)
public class TestOrderGetter {
	DisplayUtility mockDisplayUtility;
	OrderGetter orderGetter;
	@Before
	public void setupForAllTests() {
		this.mockDisplayUtility = mock(DisplayUtility.class);
		this.orderGetter = new OrderGetter(mockDisplayUtility);
	}	

	@Test(expected=NumberFormatException.class)
	@Parameters(method="getInvalidQuantity")
	public void test_invalidQuantity(String quantity) throws Exception {
		when(this.mockDisplayUtility.getFromScreen()).thenReturn(quantity);
		this.orderGetter.getRequest();
	}

	public Object[] getInvalidQuantity() {
		return new String[] { "a", "1.0", "k12", "0", "101"};
	}


	@Test(expected=InvalidOptionException.class)
	@Parameters(method="getInvalidOptions")
	public void test_invalidOptions(String option) throws Exception {
		String aValidQuantity = "1";
		when(this.mockDisplayUtility.getFromScreen()).thenReturn(aValidQuantity, option);
		this.orderGetter.getRequest();
	}

	public Object[] getInvalidOptions() {
		return new String[] {"0", "4", "a"};
	}

	// @Test
	// @Parameters(method="getValidInput") 
	// public void test_validInput(String quantity, String option) throws Exception {
	// 	when(this.mockDisplayUtility.getFromScreen()).thenReturn(quantity, option);
	// 	PrintRequest printRequest = this.orderGetter.getRequest();
		
	// }

	// public Object[] getValidInput() {

	// }

	

}

package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.spy;

import code.CalculateCharge;
import code.DisplayUtility;
import code.PhotoPrinter;
import ui.App;
import ui.OrderGetter;

public class TestApp {
	DisplayUtility mockDisplayUtility;
	OrderGetter orderGetter;
	CalculateCharge calculateCharge;
	PhotoPrinter photoPrinter;
	App app;

	@Before
	public void setupForAllTests() {
		mockDisplayUtility = mock(DisplayUtility.class);
		orderGetter = spy(new OrderGetter(mockDisplayUtility));
		calculateCharge = spy(new CalculateCharge());
		photoPrinter = spy(new PhotoPrinter());
		app = spy(new App(mockDisplayUtility, orderGetter, calculateCharge, photoPrinter));
	}

	@Test
	public void test() throws Exception {
		when(mockDisplayUtility.getFromScreen()).thenReturn(
			"1", "1", "~/myimage1.png", "y", 
			"2", "2", "~/myimage2.png", "n");
		app.run();
		assertEquals(app.getCurrentOrder().getPrintRequests().size(), 2);
		verify(orderGetter, times(1)).getOrder();
		verify(calculateCharge, times(1)).getOrderCharge(app.getCurrentOrder());
		verify(photoPrinter, times(1)).queueRequest(app.getCurrentOrder().getPrintRequests().get(0));
		verify(photoPrinter, times(1)).queueRequest(app.getCurrentOrder().getPrintRequests().get(1));
	}

}

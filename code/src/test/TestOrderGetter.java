package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import code.DesignEffectOption;
import code.DisplayUtility;
import code.HighQualityPaperOption;
import code.Order;
import code.PrintOption;
import code.PrintRequest;
import ui.OrderGetter;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

@RunWith(JUnitParamsRunner.class)
public class TestOrderGetter {
    DisplayUtility mockDisplayUtility;
    OrderGetter orderGetter;

    @Before
    public void setupForAllTests() {
        this.mockDisplayUtility = mock(DisplayUtility.class);
        this.orderGetter = new OrderGetter(mockDisplayUtility);
    }

    @Test
    public void test_onePrintRequestOnly() throws Exception {
        when(this.mockDisplayUtility.getFromScreen()).thenReturn("1", "1", "n");
        Order actualOrder = this.orderGetter.getOrder();
        Order expectedOrder = new Order(new ArrayList<PrintRequest>(Arrays.asList(
                new PrintRequest(1, new HashSet<PrintOption>(Arrays.asList(new HighQualityPaperOption())), null))));
        assertEquals(expectedOrder, actualOrder);

    }

    @Test
    public void test_twoPrintRequests() throws Exception {
        when(this.mockDisplayUtility.getFromScreen()).thenReturn("1", "1", "y", "2", "2", "n");
        Order actualOrder = this.orderGetter.getOrder();
        Order expectedOrder = new Order(new ArrayList<PrintRequest>(Arrays.asList(
                new PrintRequest(1, new HashSet<PrintOption>(Arrays.asList(new HighQualityPaperOption())), null),
                new PrintRequest(2, new HashSet<PrintOption>(Arrays.asList(new DesignEffectOption())), null))));
        assertEquals(expectedOrder, actualOrder);

    }

}

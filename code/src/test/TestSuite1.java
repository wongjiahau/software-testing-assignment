package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   TestApp.class,
   TestCalculateCharge.class,
   TestOrderGetter.class,
   TestPrintRequest.class,
   TestPrintRequestGetter.class,
})

public class TestSuite1 {}  	
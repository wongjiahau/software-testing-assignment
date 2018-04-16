package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   TestOrderGetter.class,
   TestPrintRequestGetter.class,
   TestPrintRequest.class,
   TestCalculateCharge.class
})

public class TestSuite1 {   
}  	
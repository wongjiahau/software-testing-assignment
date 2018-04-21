package test;

import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

public class Runner {
    public static void main(String args[]) {
        JUnitCore junit = new JUnitCore();
        RunListener listener = new MyListener();
        junit.addListener(listener);
        Result result = junit.run(TestSuite1.class);
        System.out.println("Ran " + result.getRunCount() + " unit tests.");
        System.out.println(result.getFailureCount() + " test(s) failed.");
        System.out.println(result.wasSuccessful() ? "All tests passed." : "Some test failed.");
    }

}

class MyListener extends RunListener {
    private String currentClassName = "";

    @Override
    public void testStarted(Description description) {
        if (!currentClassName.equals(description.getClassName())) {
            currentClassName = description.getClassName();
            System.out.println("└──[END]");
            System.out.println("--------------------");
            System.out.println(currentClassName);
        }
        System.out.println("├──" + description.getMethodName());
    }
}

package Ex03;

import junit.framework.Test;
import junit.framework.TestSuite;

public class StringToArrayTestSuit {
    public static Test suite(){
        TestSuite suite=new TestSuite(StringToArrayTestSuit.class.getName());
        suite.addTestSuite(StringToArrayTest.class);
        return suite;
    }
}

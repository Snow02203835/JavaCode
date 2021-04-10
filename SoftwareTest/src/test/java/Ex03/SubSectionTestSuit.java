package Ex03;

import junit.framework.Test;
import junit.framework.TestSuite;

public class SubSectionTestSuit {
    public static Test suite() {
        TestSuite suite = new TestSuite(SubSectionTestSuit.class.getName());
        //$JUnit-BEGIN$
        suite.addTestSuite(SubSectionTest.class);
        //$JUnit-END$
        return suite;
    }
}


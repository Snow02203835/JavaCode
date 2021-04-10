package Ex03;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class SubSectionTest extends TestCase {
    private final SubSection subSection;
    private final int testCase1, testCase2, testCase3, testCase4;
    public SubSectionTest(){
        subSection = new SubSection();
        testCase1 = -5;
        testCase2 = -2;
        testCase3 = 0;
        testCase4 = 2;
    }

    @Test
    public void testSign(){
        Assert.assertEquals(0, subSection.sign(testCase3));
        Assert.assertEquals(1, subSection.sign(testCase4));
        Assert.assertEquals(-1, subSection.sign(testCase1));
    }

    @Test
    public void testGetValue(){
        Assert.assertEquals(5, subSection.getValue(testCase1));
        Assert.assertEquals(4, subSection.getValue(testCase2));
        Assert.assertEquals(100, subSection.getValue(testCase3));
        Assert.assertEquals(8, subSection.getValue(testCase4));
    }

    @Test(timeout = 1000)
    public void testTimeOut(){
        int val = 0;
        for (int i = 0; i < 1000000000; i++) {
            val++;
        }
    }

    @Ignore
    @Test
    public void testIgnore(){
        System.out.println("这个测试方法被忽略了");
    }
}

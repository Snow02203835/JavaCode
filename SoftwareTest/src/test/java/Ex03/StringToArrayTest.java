package Ex03;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StringToArrayTest extends TestCase {
    private StringToArray stringToArray;
    private final String testCase1, testCase2, testCase3, testCase4;

    public StringToArrayTest(){
        stringToArray = new StringToArray();
        testCase1 = null;
        testCase2 = "";
        testCase3 = "     ";
        testCase4 = "Hello world!";
    }

    @Test
    public void test(){
        Assert.assertNull(stringToArray.string2Array(testCase1));
        Assert.assertArrayEquals(testCase2.toCharArray(), stringToArray.string2Array(testCase2));
        Assert.assertArrayEquals(testCase3.toCharArray(), stringToArray.string2Array(testCase3));
        Assert.assertArrayEquals(testCase4.toCharArray(), stringToArray.string2Array(testCase4));
    }
}

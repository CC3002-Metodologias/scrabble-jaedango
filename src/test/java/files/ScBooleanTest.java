package files;

import static files.BinaryToInt.intToBin;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author jaedango
 * ScBooleanTest : Test for ScBoolean
 */

public class ScBooleanTest {
    protected ScBoolean bool1;
    protected ScBoolean bool2;
    protected final boolean t = true;
    protected final boolean f = false;

    @BeforeEach
    void setUp(){
        bool1 = new ScBoolean(t);
        bool2 = new ScBoolean(f);
    }

    @Test
    void constructorTest() {
        var expectedScBool1 = new ScBoolean(t);
        var expectedScBool2 = new ScBoolean(f);
        assertEquals(expectedScBool1, bool1);
        assertEquals(expectedScBool1.hashCode(), bool1.hashCode(), "Hashes don't match");
        assertEquals(expectedScBool2, bool2);
        assertEquals(expectedScBool2.hashCode(), bool2.hashCode(), "Hashes don't match");
        assertEquals(expectedScBool1.toString(), bool1.toString());
        assertEquals(expectedScBool2.toString(), bool2.toString());
        assertNotEquals(expectedScBool2, bool1);
        assertNotEquals(expectedScBool1, bool2);
    }

    @Test
    void transformationScString() {
        var expectedScStr1 = new ScString("true");
        var expectedScStr2 = new ScString("false");
        ScString ScStr1 = bool1.toScString();
        ScString ScStr2 = bool2.toScString();
        assertEquals(expectedScStr1, ScStr1);
        assertEquals(expectedScStr2, ScStr2);
        assertEquals(expectedScStr1.hashCode(), ScStr1.hashCode(), "Hashes don't match");
        assertEquals(expectedScStr2.hashCode(), ScStr2.hashCode(), "Hashes don't match");
        assertNotEquals(expectedScStr1, ScStr2);
        assertNotEquals(expectedScStr2, ScStr1);
    }

    @Test
    void andOrScBooleanTest() {
        var expectedBool1 = new ScBoolean(true);
        var expectedBool2 = new ScBoolean(false);
        ScBoolean actualBool1 = bool1.and(expectedBool1);   // t && t
        ScBoolean actualBool2 = bool1.and(expectedBool2);   // t && f
        ScBoolean actualBool3 = bool2.and(expectedBool1);   // f && t
        ScBoolean actualBool4 = bool2.and(expectedBool2);   // f && f
        ScBoolean actualBool5 = bool1.or(expectedBool1);    // t || t
        ScBoolean actualBool6 = bool1.or(expectedBool2);    // t || f
        ScBoolean actualBool7 = bool2.or(expectedBool1);    // f || t
        ScBoolean actualBool8 = bool2.or(expectedBool2);    // f || f
        assertEquals(expectedBool1, actualBool1);
        assertEquals(expectedBool2, actualBool2);
        assertEquals(expectedBool2, actualBool3);
        assertEquals(expectedBool2, actualBool4);
        assertEquals(expectedBool1, actualBool5);
        assertEquals(expectedBool1, actualBool6);
        assertEquals(expectedBool1, actualBool7);
        assertEquals(expectedBool2, actualBool8);
    }

    @Test
    void notTest() {
        var expectedBool1 = new ScBoolean(false);
        var expectedBool2 = new ScBoolean(true);
        ScBoolean actualBool1 = bool1.not();
        ScBoolean actualBool2 = bool2.not();
        assertEquals(expectedBool1, actualBool1);
        assertEquals(expectedBool2, actualBool2);
    }

    @Test
    void andOrScBinaryTest() {
        // Nota : Para automatizar hacer un String del mismo largo que el String
        //        relleno con 1's y uno con 0's.
        String bin1 = "100100";
        String bin2 = "011011";
        String bin3 = "000000";
        String bin4 = "111111";
        ScBinary sample1 = new ScBinary(bin1);
        ScBinary sample2 = new ScBinary(bin2);
        ScBinary sample3 = new ScBinary(bin3);
        ScBinary sample4 = new ScBinary(bin4);
        ScBinary actual1 = bool1.and(sample1);  // 100100
        ScBinary actual2 = bool1.or(sample1);   // 111111
        ScBinary actual3 = bool2.and(sample1);  // 000000
        ScBinary actual4 = bool2.or(sample1);   // 100100
        ScBinary actual5 = bool1.and(sample2);  // 011011
        ScBinary actual6 = bool1.or(sample2);   // 111111
        ScBinary actual7 = bool2.and(sample2);  // 000000
        ScBinary actual8 = bool2.or(sample2);   // 011011
        assertEquals(sample1, actual1);
        assertEquals(sample4, actual2);
        assertEquals(sample3, actual3);
        assertEquals(sample1, actual4);
        assertEquals(sample2, actual5);
        assertEquals(sample4, actual6);
        assertEquals(sample3, actual7);
        assertEquals(sample2, actual8);
    }
}

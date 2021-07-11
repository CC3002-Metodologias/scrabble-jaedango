package files.constantTest;

import files.operations.constant.*;
import files.types.ScBoolean;
import files.types.ScString;
import files.types.numbers.ScBinary;
import files.types.numbers.ScFloat;
import files.types.numbers.ScInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.nio.charset.StandardCharsets;
import java.util.Random;

import static files.types.numbers.BinaryToInt.intToBin;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ConstantTest {
    ConstantFactory c = new ConstantFactory();
    ScInt n1, n2;
    ScFloat f1, f2;
    ScBinary b1, b2;
    ScString s1, s2;
    ScBoolean bool1, bool2;
    int num1, num2, num3, num4, num5, num6;
    float float1, float2;
    String binary1, binary2;
    String string1, string2;
    boolean boolean1, boolean2;
    ConstantNum cn1, cn2, cf1, cf2, cb1, cb2;
    ConstantLogical cBool1, cBool2;
    ConstantString cs1, cs2;

    @BeforeEach
    void setUp() {
        Random r0 = new Random();
        Random r1 = new Random();
        Random r2 = new Random();
        Random r3 = new Random();
        Random r4 = new Random();
        Random r5 = new Random();
        Random r6 = new Random();
        Random r7 = new Random();
        // ScInt
        num1 = r0.nextInt() % 5000;
        num2 = r1.nextInt() % 5000;
        n1 = new ScInt(num1);
        n2 = new ScInt(num2);
        cn1 = c.cNum(n1);
        cn2 = c.cNum(n2);
        // Binary
        num3 = r2.nextInt() % 5000;
        num4 = r3.nextInt() % 5000;
        binary1 = intToBin(num3);
        binary2 = intToBin(num4);
        b1 = new ScBinary(binary1);
        b2 = new ScBinary(binary2);
        cb1 = c.cNum(b1);
        cb2 = c.cNum(b2);
        // String
        num5 = r4.nextInt()%7;
        num6 = r5.nextInt()&7;
        byte[] arr1 = new byte[num5 + 7];
        byte[] arr2 = new byte[num6 + 7];
        new Random().nextBytes(arr1);
        new Random().nextBytes(arr2);
        string1 = new String(arr1, StandardCharsets.UTF_8);
        string2 = new String(arr2, StandardCharsets.UTF_8);
        s1 = new ScString(string1);
        s2 = new ScString(string2);
        cs1 = c.cStr(s1);
        cs2 = c.cStr(s2);
        // Float
        float1 = r6.nextFloat();
        float2 = r7.nextFloat();
        f1 = new ScFloat(float1);
        f2 = new ScFloat(float2);
        cf1 = c.cNum(f1);
        cf2 = c.cNum(f2);
        // Bool
        boolean1 = true;
        boolean2 = false;
        bool1 = new ScBoolean(boolean1);
        bool2 = new ScBoolean(boolean2);
        cBool1 = c.cLog(bool1);
        cBool2 = c.cLog(bool2);
    }

    // ConstantLogical
    @RepeatedTest(100)
    void logicalTest1() {
        var expected1 = new ConstantLogical(new ScBoolean(boolean1));
        var expected2 = new ConstantLogical(new ScBoolean(boolean2));
        var expected3 = new ConstantLogical(new ScBinary(binary1));
        var expected4 = new ConstantLogical(new ScBinary(binary2));
        var expected5 = new ConstantNum(new ScBinary(binary1));
        var expected6 = new ConstantNum(new ScBinary(binary2));
        assertEquals(expected1, cBool1);
        assertEquals(expected2, cBool2);
        assertNotEquals(expected3, cb1);
        assertNotEquals(expected4, cb2);
        assertEquals(expected5, cb1);
        assertEquals(expected6, cb2);
        assertEquals(expected1.hashCode(), cBool1.hashCode());
        assertEquals(expected2.hashCode(), cBool2.hashCode());
        assertEquals(expected5.hashCode(), cb1.hashCode());
        assertEquals(expected6.hashCode(), cb2.hashCode());
        assertEquals(bool1, cBool1.getValue());
        assertEquals(bool2, cBool2.getValue());
        assertEquals(String.valueOf(boolean1), cBool1.toString());
        assertEquals(String.valueOf(boolean2), cBool2.toString());
    }

    @RepeatedTest(100)
    void logicalTest2() {
        var expected1 = new ConstantLogical(new ScBoolean(boolean1));
        var expected2 = new ConstantLogical(new ScBoolean(boolean2));
        ConstantLogical actual1 = c.cLog(true);
        ConstantLogical actual2 = c.cLog(false);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    // ConstantString
    @RepeatedTest(100)
    void stringTest1() {
        var expected1 = new ConstantString(new ScString(string1));
        var expected2 = new ConstantString(new ScString(string2));
        assertEquals(expected1, cs1);
        assertEquals(expected2, cs2);
        assertNotEquals(expected1, cs2);
        assertNotEquals(expected2, cs1);
        assertEquals(expected1.hashCode(), cs1.hashCode());
        assertEquals(expected2.hashCode(), cs2.hashCode());
        assertEquals(s1, cs1.getValue());
        assertEquals(s2, cs2.getValue());
        assertEquals(string1, cs1.toString());
        assertEquals(string2, cs2.toString());
    }

    // ConstantNum
    @RepeatedTest(100)
    void numTest() {
        var expected1 = new ConstantNum(new ScInt(num1));
        var expected2 = new ConstantNum(new ScInt(num2));
        var expected3 = new ConstantNum(new ScFloat(float1));
        var expected4 = new ConstantNum(new ScFloat(float2));
        var expected5 = new ConstantNum(new ScBinary(binary1));
        var expected6 = new ConstantNum(new ScBinary(binary2));
        assertEquals(expected1, cn1);
        assertEquals(expected2, cn2);
        assertEquals(expected3, cf1);
        assertEquals(expected4, cf2);
        assertEquals(expected5, cb1);
        assertEquals(expected6, cb2);
        assertNotEquals(expected2, cn1);
        assertNotEquals(expected1, cn2);
        assertNotEquals(expected4, cf1);
        assertNotEquals(expected3, cf2);
        assertNotEquals(expected6, cb1);
        assertNotEquals(expected5, cb2);
        assertEquals(expected1.hashCode(), cn1.hashCode());
        assertEquals(expected2.hashCode(), cn2.hashCode());
        assertEquals(expected3.hashCode(), cf1.hashCode());
        assertEquals(expected4.hashCode(), cf2.hashCode());
        assertEquals(expected5.hashCode(), cb1.hashCode());
        assertEquals(expected6.hashCode(), cb2.hashCode());
        assertEquals(n1, cn1.getValue());
        assertEquals(n2, cn2.getValue());
        assertEquals(f1, cf1.getValue());
        assertEquals(f2, cf2.getValue());
        assertEquals(b1, cb1.getValue());
        assertEquals(b2, cb2.getValue());
        assertEquals(String.valueOf(num1), cn1.toString());
        assertEquals(String.valueOf(num2), cn2.toString());
        assertEquals(String.valueOf(float1), cf1.toString());
        assertEquals(String.valueOf(float2), cf2.toString());
        assertEquals(binary1, cb1.toString());
        assertEquals(binary2, cb2.toString());
    }
}

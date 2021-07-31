package files.constantTest;

import files.operations.constant.*;
import files.types.ScBoolean;
import files.types.ScString;
import files.types.numbers.ScBinary;
import files.types.numbers.ScFloat;
import files.types.numbers.ScInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Random;

import static files.types.numbers.BinaryToInt.intToBin;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VariablesTest {
    ConstantFactory c = new ConstantFactory();
    VariableFactory v = new VariableFactory();
    // Java Natives
    int num1, num2, num3, num4, num5, num6;
    float float1, float2;
    String binary1, binary2, string1, string2;
    boolean bool1, bool2;
    // Names
    String sNum1, sNum2, sFl1, sFl2, sBin1, sBin2, sBool1, sBool2, sStr1, sStr2;
    // Scrabble Classes
    ScInt scInt1, scInt2;
    ScFloat scFloat1, scFloat2;
    ScString scString1, scString2;
    ScBoolean scBoolean1, scBoolean2;
    //  Constant Values
    ConstantNum cn1, cn2, cf1, cf2;
    Constant cBin1, cBin2, cs1, cs2;
    ConstantLogical cBool1, cBool2;

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
        // Int
        num1 = r0.nextInt() % 5000;
        num2 = r1.nextInt() % 5000;
        scInt1 = new ScInt(num1);
        scInt2 = new ScInt(num2);
        sNum1 = "num1";
        sNum2 = "num2";
        cn1 = v.variable(sNum1, num1);
        cn2 = v.variable(sNum2, num2);
        // Binary
        num3 = r2.nextInt() % 5000;
        num4 = r3.nextInt() % 5000;
        binary1 = intToBin(num3);
        binary2 = intToBin(num4);
        sBin1 = "bin1";
        sBin2 = "bin2";
        cBin1 = v.variable(sBin1, binary1);
        cBin2 = v.variable(sBin2, binary2);
        // Float
        float1 = r4.nextFloat();
        float2 = r5.nextFloat();
        scFloat1 = new ScFloat(float1);
        scFloat2 = new ScFloat(float2);
        sFl1 = "float1";
        sFl2 = "float2";
        cf1 = v.variable(sFl1, float1);
        cf2 = v.variable(sFl2, float2);
        // Bool
        bool1 = true;
        bool2 = false;
        scBoolean1 = new ScBoolean(bool1);
        scBoolean2 = new ScBoolean(bool2);
        sBool1 = "bool1";
        sBool2 = "bool2";
        cBool1 = v.variable(sBool1, bool1);
        cBool2 = v.variable(sBool2, bool2);
        // String
        num5 = r6.nextInt() % 7;
        num6 = r7.nextInt() % 7;
        byte[] arr1 = new byte[num5 + 7];
        byte[] arr2 = new byte[num6 + 7];
        new Random().nextBytes(arr1);
        new Random().nextBytes(arr2);
        string1 = new String(arr1, StandardCharsets.UTF_8);
        string2 = new String(arr2, StandardCharsets.UTF_8);
        scString1 = new ScString(string1);
        scString2 = new ScString(string2);
        sStr1 = "string1";
        sStr2 = "string2";
        cs1 = v.variable(sStr1, string1);
        cs2 = v.variable(sStr2, string2);
    }

    @RepeatedTest(100)
    void intTest() {
        var expected1 = c.cNum(num1);
        var expected2 = c.cNum(num2);
        assertEquals(expected1, cn1);
        assertEquals(expected2, cn2);
        var expected3 = v.variable(sNum1);
        var expected4 = v.variable(sNum2);
        assertEquals(expected3, cn1);
        assertEquals(expected4, cn2);
        cn1 = v.variable(sNum1, num2);
        assertEquals(cn1, cn2);
    }

    @RepeatedTest(100)
    void floatTest() {
        var expected1 = c.cNum(float1);
        var expected2 = c.cNum(float2);
        assertEquals(expected1, cf1);
        assertEquals(expected2, cf2);
        var expected3 = v.variable(sFl1);
        var expected4 = v.variable(sFl2);
        assertEquals(expected3, cf1);
        assertEquals(expected4, cf2);
        cf1 = v.variable(sFl1, float2);
        assertEquals(cf1, cf2);
    }

    @RepeatedTest(100)
    void binaryTest() {
        var expected1 = c.cNum(binary1);
        var expected2 = c.cNum(binary2);
        assertEquals(expected1, cBin1);
        assertEquals(expected2, cBin2);
        var expected3 = v.variable(sBin1);
        var expected4 = v.variable(sBin2);
        assertEquals(expected3, cBin1);
        assertEquals(expected4, cBin2);
        cBin1 = v.variable(sBin1, binary2);
        assertEquals(cBin1, cBin2);
    }

    @RepeatedTest(100)
    void stringTest() {
        var expected1 = c.cStr(string1);
        var expected2 = c.cStr(string2);
        assertEquals(expected1, cs1);
        assertEquals(expected2, cs2);
        var expected3 = v.variable(sStr1);
        var expected4 = v.variable(sStr2);
        assertEquals(expected3, cs1);
        assertEquals(expected4, cs2);
        cs1 = v.variable(sStr1, string2);
        assertEquals(cs1, cs2);
    }

    @Test
    void booleanTest() {
        var expected1 = c.cLog(bool1);
        var expected2 = c.cLog(bool2);
        assertEquals(expected1, cBool1);
        assertEquals(expected2, cBool2);
        var expected3 = v.variable(sBool1);
        var expected4 = v.variable(sBool2);
        assertEquals(expected3, cBool1);
        assertEquals(expected4, cBool2);
        cBool1 = v.variable(sBool1, bool2);
        assertEquals(cBool1, cBool2);
    }

}

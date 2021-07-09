package files.operationsTets;

import files.operations.constant.Constant;
import files.operations.constant.ConstantFactory;
import files.operations.constant.ConstantNum;
import files.operations.ops.NumOps.Mul;
import files.types.numbers.NumberFactory;
import files.types.numbers.ScBinary;
import files.types.numbers.ScFloat;
import files.types.numbers.ScInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static files.types.numbers.BinaryToInt.intToBin;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MulTest {
    // factories
    NumberFactory n = new NumberFactory();
    ConstantFactory c = new ConstantFactory();
    // java classes
    int num1, num2, num3, num4;
    float float1, float2;String binary1, binary2;
    // Scrabble classes
    ScInt scInt1, scInt2;
    ScFloat scFloat1, scFloat2;
    ScBinary scBinary1, scBinary2;
    // Constants classes
    ConstantNum cn1, cn2, cf1, cf2, cb1, cb2;

    @BeforeEach
    void setUp() {
        // ints
        num1 = 1035;
        num2 = 5021;
        // binaries
        num3 = 573;
        num4 = 282;
        binary1 = intToBin(num3);
        binary2 = intToBin(num4);
        // floats
        float1 = 15.253f;
        float2 = 194.523f;
        // ----- Scrabble Clases -----
        // ScInt
        scInt1 = n.getScInt(num1);
        scInt2 = n.getScInt(num2);
        // ScBinary
        scBinary1 = n.getScBinary(binary1);
        scBinary2 = n.getScBinary(binary2);
        // ScFloat
        scFloat1 = n.getScFloat(float1);
        scFloat2 = n.getScFloat(float2);
        // ----- Constant values -----
        // Constant nums
        cn1 = c.cNum(scInt1);
        cn2 = c.cNum(scInt2);
        cb1 = c.cNum(scBinary1);
        cb2 = c.cNum(scBinary2);
        cf1 = c.cNum(scFloat1);
        cf2 = c.cNum(scFloat2);
    }

    @Test
    void mulIntTest() {
        var expected1 = c.cNum(n.getScInt(num1 * num2));
        var expected2 = c.cNum(n.getScInt(num1 * (num1 * num2)));
        var expected3 = c.cNum(n.getScInt((num1 * num2) * num2));
        var expected4 = c.cNum(n.getScInt((num1 * num2) * (num2 * num1)));
        Constant actual1 = new Mul(cn1, cn2).eval();
        Constant actual2 = new Mul(cn1, new Mul(cn1, cn2)).eval();
        Constant actual3 = new Mul(new Mul(cn1, cn2), cn2).eval();
        Constant actual4 = new Mul(new Mul(cn1, cn2), new Mul(cn2, cn1)).eval();
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @Test
    void mulFloatTest() {
        var expected1 = c.cNum(n.getScFloat(float1 * float2));
        var expected2 = c.cNum(n.getScFloat(float1 * (float1 * float2)));
        var expected3 = c.cNum(n.getScFloat((float1 * float2) * float2));
        var expected4 = c.cNum(n.getScFloat((float1 * float2) * (float2 * float1)));
        Constant actual1 = new Mul(cf1, cf2).eval();
        Constant actual2 = new Mul(cf1, new Mul(cf1, cf2)).eval();
        Constant actual3 = new Mul(new Mul(cf1, cf2), cf2).eval();
        Constant actual4 = new Mul(new Mul(cf1, cf2), new Mul(cf2, cf1)).eval();
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @Test
    void mulBinaryTest() {
        var expected1 = c.cNum(n.getScBinary(intToBin(num3 * num4)));
        var expected2 = c.cNum(n.getScBinary(intToBin(num3 * (num3 * num4))));
        var expected3 = c.cNum(n.getScBinary(intToBin((num3 * num4) * num4)));
        var expected4 = c.cNum(n.getScBinary(intToBin((num3 * num4) * (num4 * num3))));
        Constant actual1 = new Mul(cb1, cb2).eval();
        Constant actual2 = new Mul(cb1, new Mul(cb1, cb2)).eval();
        Constant actual3 = new Mul(new Mul(cb1, cb2), cb2).eval();
        Constant actual4 = new Mul(new Mul(cb1, cb2), new Mul(cb2, cb1)).eval();
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }


    @Test
    void mixedTest() {
        var expected1 = c.cNum(n.getScFloat((float) num1 * float1));
        var expected2 = c.cNum(n.getScInt(num2 * num3));
        var expected3 = c.cNum(n.getScBinary(intToBin( num3 * num2)));
        var expected4 = c.cNum(n.getScFloat((float) num1 * ((float)num2 * float1)));
        var expected5 = c.cNum(n.getScInt((num1 * num3) * (num4 * num2)));
        Constant actual1 = new Mul(cn1, cf1).eval();
        Constant actual2 = new Mul(cn2, cb1).eval();
        Constant actual3 = new Mul(cb1, cn2).eval();
        Constant actual4 = new Mul(cn1, new Mul(cn2, cf1)).eval();
        Constant actual5 = new Mul(new Mul(cn1, cb1), new Mul(cb2, cn2)).eval();
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
        assertEquals(expected5, actual5);
    }
}

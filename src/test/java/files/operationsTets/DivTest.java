package files.operationsTets;

import files.operations.constant.Constant;
import files.operations.constant.ConstantFactory;
import files.operations.constant.ConstantNum;
import files.operations.ops.NumOps.Div;
import files.types.numbers.ScBinary;
import files.types.numbers.ScFloat;
import files.types.numbers.ScInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static files.types.numbers.BinaryToInt.intToBin;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivTest {
    // factories
    ConstantFactory c = new ConstantFactory();
    // java classes
    int num1, num2, num3, num4;
    float float1, float2;String binary1, binary2;
    // Constants classes
    ConstantNum cn1, cn2, cf1, cf2, cb1, cb2;

    @BeforeEach
    void setUp() {
        // ints
        num1 = 2048;
        num2 = 1024;
        // binaries
        num3 = 573;
        num4 = 282;
        binary1 = intToBin(num3);
        binary2 = intToBin(num4);
        // floats
        float1 = 15.253f;
        float2 = 194.523f;
        // ----- Constant values -----
        // Constant nums
        cn1 = c.cNum(num1);
        cn2 = c.cNum(num2);
        cb1 = c.cNum(binary1);
        cb2 = c.cNum(binary2);
        cf1 = c.cNum(float1);
        cf2 = c.cNum(float2);
    }

    @Test
    void divIntTest() {
        var expected1 = new ConstantNum(new ScInt(num1 / num2));
        var expected2 = new ConstantNum(new ScInt(num1 / (num1 / num2)));
        var expected3 = new ConstantNum(new ScInt((num1 / num2) / num2));
        var expected4 = new ConstantNum(new ScInt((num1 / num2) / (num1 / num1)));
        Constant actual1 = new Div(cn1, cn2).eval();
        Constant actual2 = new Div(cn1, new Div(cn1, cn2)).eval();
        Constant actual3 = new Div(new Div(cn1, cn2), cn2).eval();
        Constant actual4 = new Div(new Div(cn1, cn2), new Div(cn1, cn1)).eval();
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @Test
    void divFloatTest() {
        var expected1 = new ConstantNum(new ScFloat(float1 / float2));
        var expected2 = new ConstantNum(new ScFloat(float1 / (float1 / float2)));
        var expected3 = new ConstantNum(new ScFloat((float1 / float2) / float2));
        var expected4 = new ConstantNum(new ScFloat((float1 / float2) / (float2 / float1)));
        Constant actual1 = new Div(cf1, cf2).eval();
        Constant actual2 = new Div(cf1, new Div(cf1, cf2)).eval();
        Constant actual3 = new Div(new Div(cf1, cf2), cf2).eval();
        Constant actual4 = new Div(new Div(cf1, cf2), new Div(cf2, cf1)).eval();
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @Test
    void divBinaryTest() {
        var expected1 = new ConstantNum(new ScBinary(intToBin(num3 / num4)));
        var expected2 = new ConstantNum(new ScBinary(intToBin(num3 / (num3 / num4))));
        var expected3 = new ConstantNum(new ScBinary(intToBin((num3 / num4) / num4)));
        var expected4 = new ConstantNum(new ScBinary(intToBin((num4 / num3) / (num3 / num4))));
        Constant actual1 = new Div(cb1, cb2).eval();
        Constant actual2 = new Div(cb1, new Div(cb1, cb2)).eval();
        Constant actual3 = new Div(new Div(cb1, cb2), cb2).eval();
        Constant actual4 = new Div(new Div(cb2, cb1), new Div(cb1, cb2)).eval();
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }


    @Test
    void mixedTest() {
        var expected1 = new ConstantNum(new ScFloat((float) num1 / float1));
        var expected2 = new ConstantNum(new ScInt(num2 / num3));
        var expected3 = new ConstantNum(new ScBinary(intToBin( num3 / num2)));
        var expected4 = new ConstantNum(new ScFloat((float) num1 / ((float)num2 / float1)));
        var expected5 = new ConstantNum(new ScBinary(intToBin((num3 / num1) / (num2 / num4))));
        Constant actual1 = new Div(cn1, cf1).eval();
        Constant actual2 = new Div(cn2, cb1).eval();
        Constant actual3 = new Div(cb1, cn2).eval();
        Constant actual4 = new Div(cn1, new Div(cn2, cf1)).eval();
        Constant actual5 = new Div(new Div(cb1, cn1), new Div(cn2, cb2)).eval();
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
        assertEquals(expected5, actual5);
    }
}

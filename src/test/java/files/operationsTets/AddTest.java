package files.operationsTets;

import files.operations.constant.Constant;
import files.operations.constant.ConstantFactory;
import files.operations.constant.ConstantNum;
import files.operations.constant.ConstantString;
import files.operations.ops.NumOps.Add;
import files.types.ScString;
import files.types.numbers.ScBinary;
import files.types.numbers.ScFloat;
import files.types.numbers.ScInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static files.types.numbers.BinaryToInt.intToBin;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTest {
    // factories
    ConstantFactory c = new ConstantFactory();
    // java classes
    int num1, num2, num3, num4;
    float float1, float2;
    String string1, string2;
    String binary1, binary2;
    // Constants classes
    ConstantNum cn1, cn2, cf1, cf2, cb1, cb2;
    ConstantString cs1, cs2;

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
        // strings
        string1 = "hola ";
        string2 = "estas ";
        // ----- Constant values -----
        // Constant nums
        cn1 = c.cNum(num1);
        cn2 = c.cNum(num2);
        cb1 = c.cNum(binary1);
        cb2 = c.cNum(binary2);
        cf1 = c.cNum(float1);
        cf2 = c.cNum(float2);
        // Constant Str
        cs1 = c.cStr(string1);
        cs2 = c.cStr(string2);
    }

    @Test
    void addIntTest() {
        var expected1 = new ConstantNum(new ScInt(num1 + num2));
        var expected2 = new ConstantNum(new ScInt(num1 + num1 + num2));
        var expected3 = new ConstantNum(new ScInt(num1 + num2 + num2));
        var expected4 = new ConstantNum(new ScInt((num1 + num2) + (num2 + num1)));
        Constant actual1 = new Add(cn1, cn2).eval();
        Constant actual2 = new Add(cn1, new Add(cn1, cn2)).eval();
        Constant actual3 = new Add(new Add(cn1, cn2), cn2).eval();
        Constant actual4 = new Add(new Add(cn1, cn2), new Add(cn2, cn1)).eval();
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @Test
    void addFloatTest() {
        var expected1 = new ConstantNum(new ScFloat(float1 + float2));
        var expected2 = new ConstantNum(new ScFloat(float1 + (float1 + float2)));
        var expected3 = new ConstantNum(new ScFloat((float1 + float2) + float2));
        var expected4 = new ConstantNum(new ScFloat((float1 + float2) + (float2 + float1)));
        Constant actual1 = new Add(cf1, cf2).eval();
        Constant actual2 = new Add(cf1, new Add(cf1, cf2)).eval();
        Constant actual3 = new Add(new Add(cf1, cf2), cf2).eval();
        Constant actual4 = new Add(new Add(cf1, cf2), new Add(cf2, cf1)).eval();
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @Test
    void addBinaryTest() {
        var expected1 = new ConstantNum(new ScBinary(intToBin(num3 + num4)));
        var expected2 = new ConstantNum(new ScBinary(intToBin(num3 + (num3 + num4))));
        var expected3 = new ConstantNum(new ScBinary(intToBin((num3 + num4) + num4)));
        var expected4 = new ConstantNum(new ScBinary(intToBin((num3 + num4) + (num4 + num3))));
        Constant actual1 = new Add(cb1, cb2).eval();
        Constant actual2 = new Add(cb1, new Add(cb1, cb2)).eval();
        Constant actual3 = new Add(new Add(cb1, cb2), cb2).eval();
        Constant actual4 = new Add(new Add(cb1, cb2), new Add(cb2, cb1)).eval();
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @Test
    void addStringTest() {
        var expected1 = new ConstantString(new ScString(string1 + string2));
        var expected2 = new ConstantString(new ScString(string1 + (string1 + string2)));
        var expected3 = new ConstantString(new ScString((string1 + string2) + string2));
        var expected4 = new ConstantString(new ScString((string1 + string2) + (string2 + string1)));
        Constant actual1 = new Add(cs1, cs2).eval();
        Constant actual2 = new Add(cs1, new Add(cs1, cs2)).eval();
        Constant actual3 = new Add(new Add(cs1, cs2), cs2).eval();
        Constant actual4 = new Add(new Add(cs1, cs2), new Add(cs2, cs1)).eval();
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @Test
    void mixedTest() {
        var expected1 = new ConstantNum(new ScFloat((float) num1 + float1));
        var expected2 = new ConstantNum(new ScInt(num2 + num3));
        var expected3 = new ConstantNum(new ScBinary(intToBin( num3 + num2)));
        var expected4 = new ConstantNum(new ScFloat((float) num1 + (float)num2 + float1));
        var expected5 = new ConstantNum(new ScInt((num1 + num3) + (num4 + num2)));
        Constant actual1 = new Add(cn1, cf1).eval();
        Constant actual2 = new Add(cn2, cb1).eval();
        Constant actual3 = new Add(cb1, cn2).eval();
        Constant actual4 = new Add(cn1, new Add(cn2, cf1)).eval();
        Constant actual5 = new Add(new Add(cn1, cb1), new Add(cb2, cn2)).eval();
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
        assertEquals(expected5, actual5);
    }
}

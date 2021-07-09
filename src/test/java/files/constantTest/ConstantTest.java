package files.constantTest;

import files.operations.constant.*;
import files.operations.ops.NumOps.Add;
import files.types.BooleanFactory;
import files.types.ScBoolean;
import files.types.ScString;
import files.types.StringFactory;
import files.types.numbers.NumberFactory;
import files.types.numbers.ScBinary;
import files.types.numbers.ScFloat;
import files.types.numbers.ScInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.nio.charset.StandardCharsets;
import java.util.Random;

import static files.types.numbers.BinaryToInt.intToBin;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstantTest {
    StringFactory s = new StringFactory();
    NumberFactory n = new NumberFactory();
    BooleanFactory b = new BooleanFactory();
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
        n1 = n.getScInt(num1);
        n2 = n.getScInt(num2);
        cn1 = c.cNum(n1);
        cn2 = c.cNum(n2);
        // Binary
        num3 = r2.nextInt() % 5000;
        num4 = r3.nextInt() % 5000;
        binary1 = intToBin(num3);
        binary2 = intToBin(num4);
        b1 = n.getScBinary(binary1);
        b2 = n.getScBinary(binary2);
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
        s1 = s.getScString(string1);
        s2 = s.getScString(string2);
        cs1 = c.cStr(s1);
        cs2 = c.cStr(s2);
        // Float
        float1 = r6.nextFloat();
        float2 = r7.nextFloat();
        f1 = n.getScFloat(float1);
        f2 = n.getScFloat(float2);
        cf1 = c.cNum(f1);
        cf2 = c.cNum(f2);
        // Bool
        boolean1 = true;
        boolean2 = false;
        bool1 = b.getScBoolean(boolean1);
        bool2 = b.getScBoolean(boolean2);
        cBool1 = c.cLog(bool1);
        cBool2 = c.cLog(bool2);
    }

    @RepeatedTest(100)
    void ConstructorTest() {
        var expected1 = c.cNum(n.getScInt(num1 + num2));
        var expected2 = c.cNum(n.getScBinary(intToBin(num1 + num3)));
        var expected3 = c.cNum(n.getScFloat((float) num1 + float1));
        Constant actual1 = new Add(cn1, cn2).eval();
        Constant actual2 = new Add(cn1, cb1).eval();
        Constant actual3 = new Add(cn1, cf1).eval();
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }

}

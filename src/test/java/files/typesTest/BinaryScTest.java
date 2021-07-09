package files.typesTest;

import files.types.ScBoolean;
import files.types.ScString;
import files.types.numbers.ScBinary;
import files.types.numbers.ScFloat;
import files.types.numbers.ScInt;
import files.types.numbers.ScNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static files.types.numbers.BinaryToInt.intToBin;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jaedango
 * ScBinaryTest : Test For ScBinary
 */

// Hubo un error que desconozco el motivo pero no dejo que el archivo se llamara ScBinaryTest
public class BinaryScTest {
    protected ScBinary bin1;
    protected ScBinary bin2;
    protected ScBinary bin3;
    protected Random r1 = new Random();
    protected Random r2 = new Random();
    protected Random r3 = new Random();
    protected int p1 = r1.nextInt() % 100;
    protected int p2 = r2.nextInt() % 100;
    protected final int p3 = r3.nextInt() % 100;
    protected String s1 = intToBin(p1);
    protected String s2 = intToBin(p2);
    protected String s3 = intToBin(p3);


    @BeforeEach
    void setUp(){
        bin1 = new ScBinary(s1);
        bin2 = new ScBinary(s2);
        bin3 = new ScBinary(s3);
    }

    @RepeatedTest(200)
    void constructorTest() {
        var ExpectedScBinary1 = new ScBinary(s1);
        var ExpectedScBinary2 = new ScBinary(s2);
        var ExpectedScBinary3 = new ScBinary(s3);
        assertEquals(ExpectedScBinary1, bin1);
        assertEquals(ExpectedScBinary2, bin2);
        assertEquals(ExpectedScBinary3, bin3);
        assertEquals(ExpectedScBinary1.toString(), bin1.toString());
        assertEquals(ExpectedScBinary2.toString(), bin2.toString());
        assertEquals(ExpectedScBinary3.toString(), bin3.toString());
        assertEquals(ExpectedScBinary1.hashCode(), bin1.hashCode(), "Hashes don't match");
        assertEquals(ExpectedScBinary2.hashCode(), bin2.hashCode(), "Hashes don't match");
        assertEquals(ExpectedScBinary3.hashCode(), bin3.hashCode(), "Hashes don't match");
        if (p1 != p2) {
            assertNotEquals(bin1, bin2);
        }
        if (p2 != p3) {
            assertNotEquals(bin2, bin3);
        }
        if (p3 != p1) {
            assertNotEquals(bin3, bin1);
        }
    }

    @RepeatedTest(100)
    void getValueTest() {
        assertEquals(bin1.getValue(), s1);
        assertEquals(bin2.getValue(), s2);
        assertEquals(bin3.getValue(), s3);
    }

    @RepeatedTest(100)
    void transformationToScString() {
        var expectedScString1 = new ScString(s1);
        var expectedScString2 = new ScString(s2);
        var expectedScString3 = new ScString(s3);
        ScString ScStr1 = bin1.toScString();
        ScString ScStr2 = bin2.toScString();
        ScString ScStr3 = bin3.toScString();
        assertEquals(expectedScString1, ScStr1);
        assertEquals(expectedScString2, ScStr2);
        assertEquals(expectedScString3, ScStr3);
        assertEquals(expectedScString1.hashCode(), ScStr1.hashCode(), "Hashes don't match");
        assertEquals(expectedScString2.hashCode(), ScStr2.hashCode(), "Hashes don't match");
        assertEquals(expectedScString3.hashCode(), ScStr3.hashCode(), "Hashes don't match");
        if (p1 != p2) {
            assertNotEquals(expectedScString1, ScStr2);
        }
        if (p2 != p3) {
            assertNotEquals(expectedScString2, ScStr3);
        }
        if (p3 != p1){
            assertNotEquals(expectedScString3, ScStr1);
        }
    }

    // Agregar transformaciones a ScFloat y ScInt
    @RepeatedTest(100)
    void transformationScInt() {
        ScInt expectedScInt1 = new ScInt(p1);
        ScInt expectedScInt2 = new ScInt(p2);
        ScInt expectedScInt3 = new ScInt(p3);
        ScInt int1 = bin1.toScInt();
        ScInt int2 = bin2.toScInt();
        ScInt int3 = bin3.toScInt();
        assertEquals(expectedScInt1, int1);
        assertEquals(expectedScInt2, int2);
        assertEquals(expectedScInt3, int3);
        assertEquals(expectedScInt1.hashCode(), int1.hashCode(), "Hashes don't match");
        assertEquals(expectedScInt2.hashCode(), int2.hashCode(), "Hashes don't match");
        assertEquals(expectedScInt3.hashCode(), int3.hashCode(), "Hashes don't match");
        if (p1 != p2) {
            assertNotEquals(expectedScInt1, int2);
        }
        if (p2 != p3) {
            assertNotEquals(expectedScInt2, int3);
        }
        if (p3 != p1) {
            assertNotEquals(expectedScInt3, int1);
        }
    }

    @RepeatedTest(100)
    void transformationScFloat() {
        ScFloat expectedScFloat1 = new ScFloat((float) p1);
        ScFloat expectedScFloat2 = new ScFloat((float) p2);
        ScFloat expectedScFloat3 = new ScFloat((float) p3);
        ScFloat float1 = bin1.toScFloat();
        ScFloat float2 = bin2.toScFloat();
        ScFloat float3 = bin3.toScFloat();
        assertEquals(expectedScFloat1, float1);
        assertEquals(expectedScFloat2, float2);
        assertEquals(expectedScFloat3, float3);
        assertEquals(expectedScFloat1.hashCode(), float1.hashCode(), "Hashes don't match");
        assertEquals(expectedScFloat2.hashCode(), float2.hashCode(), "Hashes don't match");
        assertEquals(expectedScFloat3.hashCode(), float3.hashCode(), "Hashes don't match");
        if (p1 != p2) {
            assertNotEquals(expectedScFloat1, float2);
        }
        if (p2 != p3) {
            assertNotEquals(expectedScFloat2, float3);
        }
        if (p3 != p1) {
            assertNotEquals(expectedScFloat3, float1);
        }
    }

    @RepeatedTest(100)
    void transformationScBinaryTest() {
        ScBinary bin4 = bin1.toScBinary();
        ScBinary bin5 = bin2.toScBinary();
        ScBinary bin6 = bin3.toScBinary();
        assertEquals(bin1, bin4);
        assertEquals(bin2, bin5);
        assertEquals(bin3, bin6);
        assertEquals(bin1.hashCode(), bin4.hashCode(), "Hashes don't match");
        assertEquals(bin2.hashCode(), bin5.hashCode(), "Hashes don't match");
        assertEquals(bin3.hashCode(), bin6.hashCode(), "Hashes don't match");
    }

    @RepeatedTest(100)
    void addScStringTest() {
        ScString a = new ScString("a");
        ScString b = new ScString("b");
        ScString expected1 = new ScString("a" + s1);
        ScString expected2 = new ScString("b" + s1);
        ScString expected3 = new ScString("a" + s2);
        ScString expected4 = new ScString("b" + s2);
        ScString actual1 = bin1.addScString(a);
        ScString actual2 = bin1.addScString(b);
        ScString actual3 = bin2.addScString(a);
        ScString actual4 = bin2.addScString(b);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(100)
    void andOrTest() {
        var bool1 = new ScBoolean(true);
        var bool2 = new ScBoolean(false);
        StringBuilder zero1 = new StringBuilder();
        StringBuilder ones1 = new StringBuilder();
        StringBuilder zero2 = new StringBuilder();
        StringBuilder ones2 = new StringBuilder();
        for (int i=0; i<s1.length();i++) {
            zero1.append('0');
            ones1.append('1');
        }
        for (int j=0;j<s2.length();j++) {
            zero2.append('0');
            ones2.append('1');
        }
        ScBinary expected10 = new ScBinary(zero1.toString());
        ScBinary expected11 = new ScBinary(ones1.toString());
        ScBinary expected20 = new ScBinary(zero2.toString());
        ScBinary expected21 = new ScBinary(ones2.toString());
        ScBinary actual1 = (ScBinary) bin1.and(bool1);
        ScBinary actual2 = (ScBinary) bin1.and(bool2);
        ScBinary actual3 = (ScBinary) bin1.or(bool1);
        ScBinary actual4 = (ScBinary) bin1.or(bool2);
        ScBinary actual5 = (ScBinary) bin2.and(bool1);
        ScBinary actual6 = (ScBinary) bin2.and(bool2);
        ScBinary actual7 = (ScBinary) bin2.or(bool1);
        ScBinary actual8 = (ScBinary) bin2.or(bool2);
        assertEquals(bin1, actual1);
        assertEquals(expected10, actual2);
        assertEquals(expected11, actual3);
        assertEquals(bin1, actual4);
        assertEquals(bin2, actual5);
        assertEquals(expected20, actual6);
        assertEquals(expected21, actual7);
        assertEquals(bin2, actual8);
    }

    @RepeatedTest(100)
    void andOrBooleanTest() {
        var bool1 = new ScBoolean(true);
        var bool2 = new ScBoolean(false);
        StringBuilder zero1 = new StringBuilder();
        StringBuilder ones1 = new StringBuilder();
        StringBuilder zero2 = new StringBuilder();
        StringBuilder ones2 = new StringBuilder();
        for (int i=0; i<s1.length();i++) {
            zero1.append('0');
            ones1.append('1');
        }
        for (int j=0;j<s2.length();j++) {
            zero2.append('0');
            ones2.append('1');
        }
        ScBinary expected10 = new ScBinary(zero1.toString());
        ScBinary expected11 = new ScBinary(ones1.toString());
        ScBinary expected20 = new ScBinary(zero2.toString());
        ScBinary expected21 = new ScBinary(ones2.toString());
        ScBinary actual1 = bin1.andBool(bool1);
        ScBinary actual2 = bin1.andBool(bool2);
        ScBinary actual3 = bin1.orBool(bool1);
        ScBinary actual4 = bin1.orBool(bool2);
        ScBinary actual5 = bin2.andBool(bool1);
        ScBinary actual6 = bin2.andBool(bool2);
        ScBinary actual7 = bin2.orBool(bool1);
        ScBinary actual8 = bin2.orBool(bool2);
        assertEquals(bin1, actual1);
        assertEquals(expected10, actual2);
        assertEquals(expected11, actual3);
        assertEquals(bin1, actual4);
        assertEquals(bin2, actual5);
        assertEquals(expected20, actual6);
        assertEquals(expected21, actual7);
        assertEquals(bin2, actual8);
    }

    @RepeatedTest(100)
    void andOrBinaryTest() {
        assertNull(bin1.andBinary(bin2));
        assertNull(bin2.andBinary(bin3));
        assertNull(bin3.andBinary(bin1));
        assertNull(bin1.orBinary(bin2));
        assertNull(bin2.orBinary(bin3));
        assertNull(bin3.orBinary(bin1));
    }

    @RepeatedTest(100)
    void addScIntTest() {
        int n1 = p1 + p3;
        int n2 = p2 - p3;
        int expInt1 = p1 + n1;
        int expInt2 = p1 + n2;
        int expInt3 = p2 + n1;
        int expInt4 = p2 + n2;
        var var1 = new ScInt(n1);
        var var2 = new ScInt(n2);
        var expected1 = new ScInt(expInt1);
        var expected2 = new ScInt(expInt2);
        var expected3 = new ScInt(expInt3);
        var expected4 = new ScInt(expInt4);
        ScInt actual1 = bin1.addToInt(var1);
        ScInt actual2 = bin1.addToInt(var2);
        ScInt actual3 = bin2.addToInt(var1);
        ScInt actual4 = bin2.addToInt(var2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(100)
    void addIntTest() {
        int n1 = p1 + p3;
        int n2 = p2 - p3;
        int expInt1 = p1 + n1;
        int expInt2 = p1 + n2;
        int expInt3 = p2 + n1;
        int expInt4 = p2 + n2;
        var var1 = new ScInt(n1);
        var var2 = new ScInt(n2);
        var expected1 = new ScInt(expInt1);
        var expected2 = new ScInt(expInt2);
        var expected3 = new ScInt(expInt3);
        var expected4 = new ScInt(expInt4);
        ScInt actual1 = (ScInt) var1.add(bin1);
        ScInt actual2 = (ScInt) var2.add(bin1);
        ScInt actual3 = (ScInt) var1.add(bin2);
        ScInt actual4 = (ScInt) var2.add(bin2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(100)
    void subScIntTest() {
        int n1 = p1 + p3;
        int n2 = p2 - p3;
        int expInt1 = n1 - p1;
        int expInt2 = n2 - p1;
        int expInt3 = n1 - p2;
        int expInt4 = n2 - p2;
        var var1 = new ScInt(n1);
        var var2 = new ScInt(n2);
        var expected1 = new ScInt(expInt1);
        var expected2 = new ScInt(expInt2);
        var expected3 = new ScInt(expInt3);
        var expected4 = new ScInt(expInt4);
        ScInt actual1 = bin1.subToInt(var1);
        ScInt actual2 = bin1.subToInt(var2);
        ScInt actual3 = bin2.subToInt(var1);
        ScInt actual4 = bin2.subToInt(var2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(100)
    void subIntTest() {
        int n1 = p1 + p3;
        int n2 = p2 - p3;
        int expInt1 = n1 - p1;
        int expInt2 = n2 - p1;
        int expInt3 = n1 - p2;
        int expInt4 = n2 - p2;
        var var1 = new ScInt(n1);
        var var2 = new ScInt(n2);
        var expected1 = new ScInt(expInt1);
        var expected2 = new ScInt(expInt2);
        var expected3 = new ScInt(expInt3);
        var expected4 = new ScInt(expInt4);
        ScInt actual1 = (ScInt) var1.sub(bin1);
        ScInt actual2 = (ScInt) var2.sub(bin1);
        ScInt actual3 = (ScInt) var1.sub(bin2);
        ScInt actual4 = (ScInt) var2.sub(bin2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(100)
    void mulScIntTest() {
        int n1 = p1 + p3;
        int n2 = p2 - p3;
        int expInt1 = p1 * n1;
        int expInt2 = p1 * n2;
        int expInt3 = p2 * n1;
        int expInt4 = p2 * n2;
        var var1 = new ScInt(n1);
        var var2 = new ScInt(n2);
        var expected1 = new ScInt(expInt1);
        var expected2 = new ScInt(expInt2);
        var expected3 = new ScInt(expInt3);
        var expected4 = new ScInt(expInt4);
        ScInt actual1 = bin1.mulToInt(var1);
        ScInt actual2 = bin1.mulToInt(var2);
        ScInt actual3 = bin2.mulToInt(var1);
        ScInt actual4 = bin2.mulToInt(var2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(100)
    void mulIntTest() {
        int n1 = p1 + p3;
        int n2 = p2 - p3;
        int expInt1 = p1 * n1;
        int expInt2 = p1 * n2;
        int expInt3 = p2 * n1;
        int expInt4 = p2 * n2;
        var var1 = new ScInt(n1);
        var var2 = new ScInt(n2);
        var expected1 = new ScInt(expInt1);
        var expected2 = new ScInt(expInt2);
        var expected3 = new ScInt(expInt3);
        var expected4 = new ScInt(expInt4);
        ScInt actual1 = (ScInt) var1.mul(bin1);
        ScInt actual2 = (ScInt) var2.mul(bin1);
        ScInt actual3 = (ScInt) var1.mul(bin2);
        ScInt actual4 = (ScInt) var2.mul(bin2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(100)
    void divScIntTest() {
        int n1 = p1 + p3;
        int n2 = p2 - p3;
        if (p1 == 0) {
            p1 = 2;
            bin1 = new ScBinary(intToBin(p1));
        }
        if (p2 == 0) {
            p2 = 2;
            bin2 = new ScBinary(intToBin(p2));
        }
        int expInt1 = n1 / p1;
        int expInt2 = n2 / p1;
        int expInt3 = n1 / p2;
        int expInt4 = n2 / p2;
        var var1 = new ScInt(n1);
        var var2 = new ScInt(n2);
        var expected1 = new ScInt(expInt1);
        var expected2 = new ScInt(expInt2);
        var expected3 = new ScInt(expInt3);
        var expected4 = new ScInt(expInt4);
        ScInt actual1 = bin1.divToInt(var1);
        ScInt actual2 = bin1.divToInt(var2);
        ScInt actual3 = bin2.divToInt(var1);
        ScInt actual4 = bin2.divToInt(var2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(100)
    void divIntTest() {
        int n1 = p1 + p3;
        int n2 = p2 - p3;
        if (p1 == 0) {
            p1 = 2;
            bin1 = new ScBinary(intToBin(p1));
        }
        if (p2 == 0) {
            p2 = 2;
            bin2 = new ScBinary(intToBin(p2));
        }
        int expInt1 = n1 / p1;
        int expInt2 = n2 / p1;
        int expInt3 = n1 / p2;
        int expInt4 = n2 / p2;
        var var1 = new ScInt(n1);
        var var2 = new ScInt(n2);
        var expected1 = new ScInt(expInt1);
        var expected2 = new ScInt(expInt2);
        var expected3 = new ScInt(expInt3);
        var expected4 = new ScInt(expInt4);
        ScInt actual1 = (ScInt) var1.div(bin1);
        ScInt actual2 = (ScInt) var2.div(bin1);
        ScInt actual3 = (ScInt) var1.div(bin2);
        ScInt actual4 = (ScInt) var2.div(bin2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(100)
    void addScBinaryTest() {
        int n1 = p1 + p3;
        int n2 = p2 - p3;
        int expInt1 = p1 + n1;
        int expInt2 = p1 + n2;
        int expInt3 = p2 + n1;
        int expInt4 = p2 + n2;
        var var1 = new ScBinary(intToBin(n1));
        var var2 = new ScBinary(intToBin(n2));
        ScBinary expected1 = new ScBinary(intToBin(expInt1));
        ScBinary expected2 = new ScBinary(intToBin(expInt2));
        ScBinary expected3 = new ScBinary(intToBin(expInt3));
        ScBinary expected4 = new ScBinary(intToBin(expInt4));
        ScBinary actual1 = bin1.addToBin(var1);
        ScBinary actual2 = bin1.addToBin(var2);
        ScBinary actual3 = bin2.addToBin(var1);
        ScBinary actual4 = bin2.addToBin(var2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(100)
    void addBinaryTest() {
        int n1 = p1 + p3;
        int n2 = p2 - p3;
        int expInt1 = p1 + n1;
        int expInt2 = p1 + n2;
        int expInt3 = p2 + n1;
        int expInt4 = p2 + n2;
        var var1 = new ScBinary(intToBin(n1));
        var var2 = new ScBinary(intToBin(n2));
        ScBinary expected1 = new ScBinary(intToBin(expInt1));
        ScBinary expected2 = new ScBinary(intToBin(expInt2));
        ScBinary expected3 = new ScBinary(intToBin(expInt3));
        ScBinary expected4 = new ScBinary(intToBin(expInt4));
        ScBinary actual1 = (ScBinary) bin1.add(var1);
        ScBinary actual2 = (ScBinary) bin1.add(var2);
        ScBinary actual3 = (ScBinary) bin2.add(var1);
        ScBinary actual4 = (ScBinary) bin2.add(var2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(100)
    void subScBinaryTest() {
        int n1 = p1 + p3;
        int n2 = p2 - p3;
        int expInt1 = n1 - p1;
        int expInt2 = n2 - p1;
        int expInt3 = n1 - p2;
        int expInt4 = n2 - p2;
        var var1 = new ScBinary(intToBin(n1));
        var var2 = new ScBinary(intToBin(n2));
        ScBinary expected1 = new ScBinary(intToBin(expInt1));
        ScBinary expected2 = new ScBinary(intToBin(expInt2));
        ScBinary expected3 = new ScBinary(intToBin(expInt3));
        ScBinary expected4 = new ScBinary(intToBin(expInt4));
        ScBinary actual1 = bin1.subToBin(var1);
        ScBinary actual2 = bin1.subToBin(var2);
        ScBinary actual3 = bin2.subToBin(var1);
        ScBinary actual4 = bin2.subToBin(var2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(100)
    void subBinaryTest() {
        int n1 = p1 + p3;
        int n2 = p2 - p3;
        int expInt1 = p1 - n1;
        int expInt2 = p1 - n2;
        int expInt3 = p2 - n1;
        int expInt4 = p2 - n2;
        var var1 = new ScBinary(intToBin(n1));
        var var2 = new ScBinary(intToBin(n2));
        ScBinary expected1 = new ScBinary(intToBin(expInt1));
        ScBinary expected2 = new ScBinary(intToBin(expInt2));
        ScBinary expected3 = new ScBinary(intToBin(expInt3));
        ScBinary expected4 = new ScBinary(intToBin(expInt4));
        ScBinary actual1 = (ScBinary) bin1.sub(var1);
        ScBinary actual2 = (ScBinary) bin1.sub(var2);
        ScBinary actual3 = (ScBinary) bin2.sub(var1);
        ScBinary actual4 = (ScBinary) bin2.sub(var2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(100)
    void mulScBinaryTest() {
        int n1 = p1 + p3;
        int n2 = p2 - p3;
        int expInt1 = p1 * n1;
        int expInt2 = p1 * n2;
        int expInt3 = p2 * n1;
        int expInt4 = p2 * n2;
        var var1 = new ScBinary(intToBin(n1));
        var var2 = new ScBinary(intToBin(n2));
        ScBinary expected1 = new ScBinary(intToBin(expInt1));
        ScBinary expected2 = new ScBinary(intToBin(expInt2));
        ScBinary expected3 = new ScBinary(intToBin(expInt3));
        ScBinary expected4 = new ScBinary(intToBin(expInt4));
        ScBinary actual1 = bin1.mulToBin(var1);
        ScBinary actual2 = bin1.mulToBin(var2);
        ScBinary actual3 = bin2.mulToBin(var1);
        ScBinary actual4 = bin2.mulToBin(var2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(100)
    void mulBinaryTest() {
        int n1 = p1 + p3;
        int n2 = p2 - p3;
        int expInt1 = p1 * n1;
        int expInt2 = p1 * n2;
        int expInt3 = p2 * n1;
        int expInt4 = p2 * n2;
        var var1 = new ScBinary(intToBin(n1));
        var var2 = new ScBinary(intToBin(n2));
        ScBinary expected1 = new ScBinary(intToBin(expInt1));
        ScBinary expected2 = new ScBinary(intToBin(expInt2));
        ScBinary expected3 = new ScBinary(intToBin(expInt3));
        ScBinary expected4 = new ScBinary(intToBin(expInt4));
        ScBinary actual1 = (ScBinary) bin1.mul(var1);
        ScBinary actual2 = (ScBinary) bin1.mul(var2);
        ScBinary actual3 = (ScBinary) bin2.mul(var1);
        ScBinary actual4 = (ScBinary) bin2.mul(var2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(100)
    void divScBinaryTest() {
        int n1 = p1 + p3;
        int n2 = p2 - p3;
        if (n1 == 0) {
            n1 += 2;
        }
        if (n2 == 0) {
            n2 += 2;
        }
        int expInt1 = p1 / n1;
        int expInt2 = p1 / n2;
        int expInt3 = p2 / n1;
        int expInt4 = p2 / n2;
        var var1 = new ScBinary(intToBin(n1));
        var var2 = new ScBinary(intToBin(n2));
        ScBinary expected1 = new ScBinary(intToBin(expInt1));
        ScBinary expected2 = new ScBinary(intToBin(expInt2));
        ScBinary expected3 = new ScBinary(intToBin(expInt3));
        ScBinary expected4 = new ScBinary(intToBin(expInt4));
        ScBinary actual1 = var1.divToBin(bin1);
        ScBinary actual2 = var2.divToBin(bin1);
        ScBinary actual3 = var1.divToBin(bin2);
        ScBinary actual4 = var2.divToBin(bin2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(100)
    void divBinaryTest() {
        int n1 = p1 + p3;
        int n2 = p2 - p3;
        if (n1 == 0) {
            n1 += 2;
        }
        if (n2 == 0) {
            n2 += 2;
        }
        int expInt1 = p1 / n1;
        int expInt2 = p1 / n2;
        int expInt3 = p2 / n1;
        int expInt4 = p2 / n2;
        var var1 = new ScBinary(intToBin(n1));
        var var2 = new ScBinary(intToBin(n2));
        ScBinary expected1 = new ScBinary(intToBin(expInt1));
        ScBinary expected2 = new ScBinary(intToBin(expInt2));
        ScBinary expected3 = new ScBinary(intToBin(expInt3));
        ScBinary expected4 = new ScBinary(intToBin(expInt4));
        ScBinary actual1 = (ScBinary) bin1.div(var1);
        ScBinary actual2 = (ScBinary) bin1.div(var2);
        ScBinary actual3 = (ScBinary) bin2.div(var1);
        ScBinary actual4 = (ScBinary) bin2.div(var2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(100)
    void addScFloatTest() {
        ScFloat f1 = new ScFloat(r1.nextFloat());
        ScFloat f2 = new ScFloat(r2.nextFloat());
        ScFloat actual1 = bin1.addToFloat(f1);
        ScFloat actual2 = bin1.addToFloat(f2);
        ScFloat actual3 = bin2.addToFloat(f1);
        ScFloat actual4 = bin2.addToFloat(f2);
        assertNull(actual1);
        assertNull(actual2);
        assertNull(actual3);
        assertNull(actual4);
    }

    @RepeatedTest(100)
    void addFloatTest() {
        ScFloat f1 = new ScFloat(r1.nextFloat());
        ScFloat f2 = new ScFloat(r2.nextFloat());
        ScNumber actual1 = f1.add(bin1);
        ScNumber actual2 = f2.add(bin1);
        ScNumber actual3 = f1.add(bin2);
        ScNumber actual4 = f2.add(bin2);
        assertNull(actual1);
        assertNull(actual2);
        assertNull(actual3);
        assertNull(actual4);
    }

    @RepeatedTest(100)
    void subScFloatTest() {
        ScFloat f1 = new ScFloat(r1.nextFloat());
        ScFloat f2 = new ScFloat(r2.nextFloat());
        ScFloat expected1 = bin1.subToFloat(f1);
        ScFloat expected2 = bin1.subToFloat(f2);
        ScFloat expected3 = bin2.subToFloat(f1);
        ScFloat expected4 = bin2.subToFloat(f2);
        assertNull(expected1);
        assertNull(expected2);
        assertNull(expected3);
        assertNull(expected4);
    }

    @RepeatedTest(100)
    void subFloatTest() {
        ScFloat f1 = new ScFloat(r1.nextFloat());
        ScFloat f2 = new ScFloat(r2.nextFloat());
        ScNumber actual1 = f1.sub(bin1);
        ScNumber actual2 = f2.sub(bin1);
        ScNumber actual3 = f1.sub(bin2);
        ScNumber actual4 = f2.sub(bin2);
        assertNull(actual1);
        assertNull(actual2);
        assertNull(actual3);
        assertNull(actual4);
    }

    @RepeatedTest(100)
    void mulScFloatTest() {
        ScFloat f1 = new ScFloat(r1.nextFloat());
        ScFloat f2 = new ScFloat(r2.nextFloat());
        ScFloat expected1 = bin1.mulToFloat(f1);
        ScFloat expected2 = bin1.mulToFloat(f2);
        ScFloat expected3 = bin2.mulToFloat(f1);
        ScFloat expected4 = bin2.mulToFloat(f2);
        assertNull(expected1);
        assertNull(expected2);
        assertNull(expected3);
        assertNull(expected4);
    }

    @RepeatedTest(100)
    void mulFloatTest() {
        ScFloat f1 = new ScFloat(r1.nextFloat());
        ScFloat f2 = new ScFloat(r2.nextFloat());
        ScNumber actual1 = f1.mul(bin1);
        ScNumber actual2 = f2.mul(bin1);
        ScNumber actual3 = f1.mul(bin2);
        ScNumber actual4 = f2.mul(bin2);
        assertNull(actual1);
        assertNull(actual2);
        assertNull(actual3);
        assertNull(actual4);
    }

    @RepeatedTest(100)
    void divScFloatTest() {
        ScFloat f1 = new ScFloat(r1.nextFloat());
        ScFloat f2 = new ScFloat(r2.nextFloat());
        ScFloat expected1 = bin1.divToFloat(f1);
        ScFloat expected2 = bin1.divToFloat(f2);
        ScFloat expected3 = bin2.divToFloat(f1);
        ScFloat expected4 = bin2.divToFloat(f2);
        assertNull(expected1);
        assertNull(expected2);
        assertNull(expected3);
        assertNull(expected4);
    }

    @RepeatedTest(100)
    void divFloatTest() {
        ScFloat f1 = new ScFloat(r1.nextFloat());
        ScFloat f2 = new ScFloat(r2.nextFloat());
        ScNumber actual1 = f1.div(bin1);
        ScNumber actual2 = f2.div(bin1);
        ScNumber actual3 = f1.div(bin2);
        ScNumber actual4 = f2.div(bin2);
        assertNull(actual1);
        assertNull(actual2);
        assertNull(actual3);
        assertNull(actual4);
    }
}


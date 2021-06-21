package files;

import files.types.ScBoolean;
import files.types.ScString;
import files.types.numbers.ScBinary;
import files.types.numbers.ScFloat;
import files.types.numbers.ScInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static files.types.numbers.BinaryToInt.intToBin;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
    protected final int p1 = r1.nextInt() % 100;
    protected final int p2 = r2.nextInt() % 100;
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
    void addScIntTest() {
        int n1 = p1 + p3;
        int n2 = p2 - p3;
        int expInt1 = p1 + n1;
        int expInt2 = p1 + n2;
        int expInt3 = p2 + n1;
        int expInt4 = p2 + n2;
        var var1 = new ScInt(n1);
        var var2 = new ScInt(n2);
        ScBinary expected1 = new ScBinary(intToBin(expInt1));
        ScBinary expected2 = new ScBinary(intToBin(expInt2));
        ScBinary expected3 = new ScBinary(intToBin(expInt3));
        ScBinary expected4 = new ScBinary(intToBin(expInt4));
        ScBinary actual1 = bin1.addToInt(var1);
        ScBinary actual2 = bin1.addToInt(var2);
        ScBinary actual3 = bin2.addToInt(var1);
        ScBinary actual4 = bin2.addToInt(var2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(100)
    void subScIntTest() {
        int n1 = p1 + p3;
        int n2 = p2 - p3;
        int expInt1 = p1 - n1;
        int expInt2 = p1 - n2;
        int expInt3 = p2 - n1;
        int expInt4 = p2 - n2;
        var var1 = new ScInt(n1);
        var var2 = new ScInt(n2);
        ScBinary expected1 = new ScBinary(intToBin(expInt1));
        ScBinary expected2 = new ScBinary(intToBin(expInt2));
        ScBinary expected3 = new ScBinary(intToBin(expInt3));
        ScBinary expected4 = new ScBinary(intToBin(expInt4));
        ScBinary actual1 = bin1.subToInt(var1);
        ScBinary actual2 = bin1.subToInt(var2);
        ScBinary actual3 = bin2.subToInt(var1);
        ScBinary actual4 = bin2.subToInt(var2);
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
        ScBinary expected1 = new ScBinary(intToBin(expInt1));
        ScBinary expected2 = new ScBinary(intToBin(expInt2));
        ScBinary expected3 = new ScBinary(intToBin(expInt3));
        ScBinary expected4 = new ScBinary(intToBin(expInt4));
        ScBinary actual1 = bin1.mulToInt(var1);
        ScBinary actual2 = bin1.mulToInt(var2);
        ScBinary actual3 = bin2.mulToInt(var1);
        ScBinary actual4 = bin2.mulToInt(var2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(100)
    void divScIntTest() {
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
        var var1 = new ScInt(n1);
        var var2 = new ScInt(n2);
        ScBinary expected1 = new ScBinary(intToBin(expInt1));
        ScBinary expected2 = new ScBinary(intToBin(expInt2));
        ScBinary expected3 = new ScBinary(intToBin(expInt3));
        ScBinary expected4 = new ScBinary(intToBin(expInt4));
        ScBinary actual1 = bin1.divToInt(var1);
        ScBinary actual2 = bin1.divToInt(var2);
        ScBinary actual3 = bin2.divToInt(var1);
        ScBinary actual4 = bin2.divToInt(var2);
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
    void subScBinaryTest() {
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
        ScBinary actual1 = bin1.divToBin(var1);
        ScBinary actual2 = bin1.divToBin(var2);
        ScBinary actual3 = bin2.divToBin(var1);
        ScBinary actual4 = bin2.divToBin(var2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }
}


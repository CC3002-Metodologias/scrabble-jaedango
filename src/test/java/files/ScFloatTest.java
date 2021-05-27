package files;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static files.BinaryToInt.intToBin;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author jaedango
 * ScFloatTest : Test for ScFloat
 */

public class ScFloatTest {
    protected ScFloat float1;
    protected ScFloat float2;
    protected ScFloat float3;
    Random r1 = new Random();
    Random r2 = new Random();
    Random r3 = new Random();
    protected final float f1 = r1.nextFloat() * 100;
    protected final float f2 = r2.nextFloat() * 100;
    protected final float f3 = r3.nextFloat() * 100;

    @BeforeEach
    void setUp(){
        float1 = new ScFloat(f1);
        float2 = new ScFloat(f2);
        float3 = new ScFloat(f3);
    }

    @RepeatedTest(200)
    void constructTest() {
        var expectedScFloat1 = new ScFloat(f1);
        var expectedScFloat2 = new ScFloat(f2);
        var expectedScFloat3 = new ScFloat(f3);
        assertEquals(expectedScFloat1, float1);
        assertEquals(expectedScFloat2, float2);
        assertEquals(expectedScFloat3, float3);
        assertEquals(expectedScFloat1.toString(), float1.toString());
        assertEquals(expectedScFloat2.toString(), float2.toString());
        assertEquals(expectedScFloat3.toString(), float3.toString());
        assertEquals(expectedScFloat1.hashCode(), float1.hashCode(), "Hashes don't match");
        assertEquals(expectedScFloat2.hashCode(), float2.hashCode(), "Hashes don't match");
        assertEquals(expectedScFloat3.hashCode(), float3.hashCode(), "Hashes don't match");
        if (f1 != f2) {
            assertNotEquals(expectedScFloat1, float2);
        }
        if (f2 != f3) {
            assertNotEquals(expectedScFloat2, float3);
        }
        if (f3 != f1) {
            assertNotEquals(expectedScFloat3, float1);
        }
    }

    @RepeatedTest(200)
    void transformationScString() {
        var expectedScString1 = new ScString(String.valueOf(f1));
        var expectedScString2 = new ScString(String.valueOf(f2));
        var expectedScString3 = new ScString(String.valueOf(f3));
        ScString scStr1 = float1.toScString();
        ScString scStr2 = float2.toScString();
        ScString scStr3 = float3.toScString();
        assertEquals(expectedScString1, scStr1);
        assertEquals(expectedScString2, scStr2);
        assertEquals(expectedScString3, scStr3);
        assertEquals(expectedScString1.hashCode(), scStr1.hashCode(), "Hashes don't match");
        assertEquals(expectedScString2.hashCode(), scStr2.hashCode(), "Hashes don't match");
        assertEquals(expectedScString3.hashCode(), scStr3.hashCode(), "Hashes don't match");
        if (f1 != f2) {
            assertNotEquals(expectedScString1, scStr2);
        }
        if (f2 != f3) {
            assertNotEquals(expectedScString2, scStr3);
        }
        if (f3 != f1) {
            assertNotEquals(expectedScString3, scStr1);
        }
    }

    @RepeatedTest(20)
    void addFloatTest() {
        float sum1 = f1 + f1;
        float sum2 = f1 + f2;
        float sum3 = f2 + f1;
        float sum4 = f2 + f2;
        var expected1 = new ScFloat(sum1);
        var expected2 = new ScFloat(sum2);
        var expected3 = new ScFloat(sum3);
        var expected4 = new ScFloat(sum4);
        ScFloat actual1 = float1.add(float1);
        ScFloat actual2 = float1.add(float2);
        ScFloat actual3 = float2.add(float1);
        ScFloat actual4 = float2.add(float2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(20)
    void subFloatTest() {
        float sub1 = 0;
        float sub2 = f1 - f2;
        float sub3 = f2 - f1;
        float sub4 = f3 - f2;
        var expected1 = new ScFloat(sub1);
        var expected2 = new ScFloat(sub2);
        var expected3 = new ScFloat(sub3);
        var expected4 = new ScFloat(sub4);
        ScFloat actual1 = float1.sub(float1);
        ScFloat actual2 = float1.sub(float2);
        ScFloat actual3 = float2.sub(float1);
        ScFloat actual4 = float3.sub(float2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(20)
    void mulFloatTest() {
        float mul1 = f1 * f1;
        float mul2 = f1 * f2;
        float mul3 = f2 * f1;
        float mul4 = f2 * f2;
        var expected1 = new ScFloat(mul1);
        var expected2 = new ScFloat(mul2);
        var expected3 = new ScFloat(mul3);
        var expected4 = new ScFloat(mul4);
        ScFloat actual1 = float1.mul(float1);
        ScFloat actual2 = float1.mul(float2);
        ScFloat actual3 = float2.mul(float1);
        ScFloat actual4 = float2.mul(float2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(20)
    void divFloatTest() {
        float div1 = 1f;
        float div2 = f1 / f2;
        float div3 = f2 / f1;
        float div4 = f3 / f2;
        var expected1 = new ScFloat(div1);
        var expected2 = new ScFloat(div2);
        var expected3 = new ScFloat(div3);
        var expected4 = new ScFloat(div4);
        ScFloat actual1 = float1.div(float1);
        ScFloat actual2 = float1.div(float2);
        ScFloat actual3 = float2.div(float1);
        ScFloat actual4 = float3.div(float2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(20)
    void addIntTest() {
        int n1 = r1.nextInt() + r3.nextInt();
        int n2 = r2.nextInt() - r3.nextInt();
        var int1 = new ScInt(n1);
        var int2 = new ScInt(n2);
        float fl1 = f1 + (float) n1;
        float fl2 = f1 + (float) n2;
        float fl3 = f2 + (float) n1;
        float fl4 = f2 + (float) n2;
        ScFloat expected1 = new ScFloat(fl1);
        ScFloat expected2 = new ScFloat(fl2);
        ScFloat expected3 = new ScFloat(fl3);
        ScFloat expected4 = new ScFloat(fl4);
        ScFloat actual1 = float1.add(int1);
        ScFloat actual2 = float1.add(int2);
        ScFloat actual3 = float2.add(int1);
        ScFloat actual4 = float2.add(int2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(20)
    void subIntTest() {
        int n1 = r1.nextInt() + r3.nextInt();
        int n2 = r2.nextInt() - r3.nextInt();
        var int1 = new ScInt(n1);
        var int2 = new ScInt(n2);
        float fl1 = f1 - (float) n1;
        float fl2 = f1 - (float) n2;
        float fl3 = f2 - (float) n1;
        float fl4 = f2 - (float) n2;
        ScFloat expected1 = new ScFloat(fl1);
        ScFloat expected2 = new ScFloat(fl2);
        ScFloat expected3 = new ScFloat(fl3);
        ScFloat expected4 = new ScFloat(fl4);
        ScFloat actual1 = float1.sub(int1);
        ScFloat actual2 = float1.sub(int2);
        ScFloat actual3 = float2.sub(int1);
        ScFloat actual4 = float2.sub(int2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(20)
    void mulIntTest() {
        int n1 = r1.nextInt() + r3.nextInt();
        int n2 = r2.nextInt() - r3.nextInt();
        var int1 = new ScInt(n1);
        var int2 = new ScInt(n2);
        float fl1 = f1 * (float) n1;
        float fl2 = f1 * (float) n2;
        float fl3 = f2 * (float) n1;
        float fl4 = f2 * (float) n2;
        ScFloat expected1 = new ScFloat(fl1);
        ScFloat expected2 = new ScFloat(fl2);
        ScFloat expected3 = new ScFloat(fl3);
        ScFloat expected4 = new ScFloat(fl4);
        ScFloat actual1 = float1.mul(int1);
        ScFloat actual2 = float1.mul(int2);
        ScFloat actual3 = float2.mul(int1);
        ScFloat actual4 = float2.mul(int2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(20)
    void divIntTest() {
        int n1 = r1.nextInt() + r3.nextInt();
        int n2 = r2.nextInt() - r3.nextInt();
        var int1 = new ScInt(n1);
        var int2 = new ScInt(n2);
        float fl1 = f1 / (float) n1;
        float fl2 = f1 / (float) n2;
        float fl3 = f2 / (float) n1;
        float fl4 = f2 / (float) n2;
        ScFloat expected1 = new ScFloat(fl1);
        ScFloat expected2 = new ScFloat(fl2);
        ScFloat expected3 = new ScFloat(fl3);
        ScFloat expected4 = new ScFloat(fl4);
        ScFloat actual1 = float1.div(int1);
        ScFloat actual2 = float1.div(int2);
        ScFloat actual3 = float2.div(int1);
        ScFloat actual4 = float2.div(int2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(20)
    void addBinTest() {
        int n1 = r1.nextInt() + r3.nextInt();
        int n2 = r2.nextInt() - r3.nextInt();
        var bin1 = new ScBinary(intToBin(n1));
        var bin2 = new ScBinary(intToBin(n2));
        float fl1 = f1 + (float) n1;
        float fl2 = f1 + (float) n2;
        float fl3 = f2 + (float) n1;
        float fl4 = f2 + (float) n2;
        ScFloat expected1 = new ScFloat(fl1);
        ScFloat expected2 = new ScFloat(fl2);
        ScFloat expected3 = new ScFloat(fl3);
        ScFloat expected4 = new ScFloat(fl4);
        ScFloat actual1 = float1.add(bin1);
        ScFloat actual2 = float1.add(bin2);
        ScFloat actual3 = float2.add(bin1);
        ScFloat actual4 = float2.add(bin2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(20)
    void subBinTest() {
        int n1 = r1.nextInt() + r3.nextInt();
        int n2 = r2.nextInt() - r3.nextInt();
        var bin1 = new ScBinary(intToBin(n1));
        var bin2 = new ScBinary(intToBin(n2));
        float fl1 = f1 - (float) n1;
        float fl2 = f1 - (float) n2;
        float fl3 = f2 - (float) n1;
        float fl4 = f2 - (float) n2;
        ScFloat expected1 = new ScFloat(fl1);
        ScFloat expected2 = new ScFloat(fl2);
        ScFloat expected3 = new ScFloat(fl3);
        ScFloat expected4 = new ScFloat(fl4);
        ScFloat actual1 = float1.sub(bin1);
        ScFloat actual2 = float1.sub(bin2);
        ScFloat actual3 = float2.sub(bin1);
        ScFloat actual4 = float2.sub(bin2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(20)
    void mulBinTest() {
        int n1 = r1.nextInt() + r3.nextInt();
        int n2 = r2.nextInt() - r3.nextInt();
        var bin1 = new ScBinary(intToBin(n1));
        var bin2 = new ScBinary(intToBin(n2));
        float fl1 = f1 * (float) n1;
        float fl2 = f1 * (float) n2;
        float fl3 = f2 * (float) n1;
        float fl4 = f2 * (float) n2;
        ScFloat expected1 = new ScFloat(fl1);
        ScFloat expected2 = new ScFloat(fl2);
        ScFloat expected3 = new ScFloat(fl3);
        ScFloat expected4 = new ScFloat(fl4);
        ScFloat actual1 = float1.mul(bin1);
        ScFloat actual2 = float1.mul(bin2);
        ScFloat actual3 = float2.mul(bin1);
        ScFloat actual4 = float2.mul(bin2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(20)
    void divBinTest() {
        int n1 = r1.nextInt() + r3.nextInt();
        int n2 = r2.nextInt() - r3.nextInt();
        var bin1 = new ScBinary(intToBin(n1));
        var bin2 = new ScBinary(intToBin(n2));
        float fl1 = f1 / (float) n1;
        float fl2 = f1 / (float) n2;
        float fl3 = f2 / (float) n1;
        float fl4 = f2 / (float) n2;
        ScFloat expected1 = new ScFloat(fl1);
        ScFloat expected2 = new ScFloat(fl2);
        ScFloat expected3 = new ScFloat(fl3);
        ScFloat expected4 = new ScFloat(fl4);
        ScFloat actual1 = float1.div(bin1);
        ScFloat actual2 = float1.div(bin2);
        ScFloat actual3 = float2.div(bin1);
        ScFloat actual4 = float2.div(bin2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }
}

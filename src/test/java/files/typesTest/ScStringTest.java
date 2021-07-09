package files.typesTest;

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

/**
 * @author jaedango
 * ScStringTest : Test for ScString
 */

public class ScStringTest {
    Random r1 = new Random();
    Random r2 = new Random();
    int n1 = r1.nextInt() % 7; // Vamos a usar strings aleatoreos entre 7 y 14 caracteres.
    int n2 = r2.nextInt() % 7;
    int l1 = n1 + 7;
    int l2 = n2 + 7;
    byte[] arr1 = new byte[l1];
    byte[] arr2 = new byte[l2];
    protected String s1;
    protected String s2;
    protected ScString str1;
    protected ScString str2;

    @BeforeEach
    void setUp(){
        new Random().nextBytes(arr1);
        new Random().nextBytes(arr2);
        s1 = new String(arr1, StandardCharsets.UTF_8);
        s2 = new String(arr2, StandardCharsets.UTF_8);
        str1 = new ScString(s1);
        str2 = new ScString(s2);
    }

    @RepeatedTest(100)
    void constructorTest() {
        var ExpectedScString1 = new ScString(s1);
        var ExpectedScString2 = new ScString(s2);
        assertEquals(ExpectedScString1, str1);
        assertEquals(ExpectedScString2, str2);
        assertEquals(ExpectedScString1.toString(), str1.toString());
        assertEquals(ExpectedScString2.toString(), str2.toString());
        assertEquals(ExpectedScString1.hashCode(), str1.hashCode(), "Hashes don't match.");
        assertEquals(ExpectedScString2.hashCode(), str2.hashCode(), "Hashes don't match.");
        if (!s1.equals(s2)) {
            assertNotEquals(ExpectedScString1, str2);
            assertNotEquals(ExpectedScString2, str1);
        }
    }

    @RepeatedTest(100)
    void toScStringTest() {
        ScString expected1 = str1.toScString();
        ScString expected2 = str2.toScString();
        assertEquals(str1, expected1);
        assertEquals(str2, expected2);
    }

    @RepeatedTest(100)
    void addScStringTest() {
        String string1 = s2 + s1;
        String string2 = s1 + s2;
        String string3 = s1 + s1;
        String string4 = s2 + s2;
        ScString expectedSum1 = new ScString(string1);
        ScString expectedSum2 = new ScString(string2);
        ScString expectedSum3 = new ScString(string3);
        ScString expectedSum4 = new ScString(string4);
        ScString actualStr1 = str1.addScString(str2);
        ScString actualStr2 = str2.addScString(str1);
        ScString actualStr3 = str1.addScString(str1);
        ScString actualStr4 = str2.addScString(str2);
        assertEquals(expectedSum1, actualStr1);
        assertEquals(expectedSum2, actualStr2);
        assertEquals(expectedSum3, actualStr3);
        assertEquals(expectedSum4, actualStr4);
    }

    @RepeatedTest(100)
    void addStringTest() {
        String string1 = s1 + s2;
        String string2 = s2 + s1;
        String string3 = s1 + s1;
        String string4 = s2 + s2;
        var expected1 = new ScString(string1);
        var expected2 = new ScString(string2);
        var expected3 = new ScString(string3);
        var expected4 = new ScString(string4);
        ScString actual1 = str1.add(str2);
        ScString actual2 = str2.add(str1);
        ScString actual3 = str1.add(str1);
        ScString actual4 = str2.add(str2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @RepeatedTest(100)
    void addScBoolTest() {
        String string1 = true + s1;
        String string2 = false + s1;
        String string3 = true + s2;
        String string4 = false + s2;
        ScBoolean b1 = new ScBoolean(true);
        ScBoolean b2 = new ScBoolean(false);
        ScString expectedSum1 = new ScString(string1);
        ScString expectedSum2 = new ScString(string2);
        ScString expectedSum3 = new ScString(string3);
        ScString expectedSum4 = new ScString(string4);
        ScString actualStr1 = str1.addScBool(b1);
        ScString actualStr2 = str1.addScBool(b2);
        ScString actualStr3 = str2.addScBool(b1);
        ScString actualStr4 = str2.addScBool(b2);
        assertEquals(expectedSum1, actualStr1);
        assertEquals(expectedSum2, actualStr2);
        assertEquals(expectedSum3, actualStr3);
        assertEquals(expectedSum4, actualStr4);
    }

    @RepeatedTest(100)
    void addBoolTest() {
        String string1 = s1 + true;
        String string2 = s1 + false;
        String string3 = s2 + true;
        String string4 = s2 + false;
        ScBoolean b1 = new ScBoolean(true);
        ScBoolean b2 = new ScBoolean(false);
        ScString expectedSum1 = new ScString(string1);
        ScString expectedSum2 = new ScString(string2);
        ScString expectedSum3 = new ScString(string3);
        ScString expectedSum4 = new ScString(string4);
        ScString actualStr1 = str1.add(b1);
        ScString actualStr2 = str1.add(b2);
        ScString actualStr3 = str2.add(b1);
        ScString actualStr4 = str2.add(b2);
        assertEquals(expectedSum1, actualStr1);
        assertEquals(expectedSum2, actualStr2);
        assertEquals(expectedSum3, actualStr3);
        assertEquals(expectedSum4, actualStr4);
    }

    @RepeatedTest(100)
    void addScFloatTest() {
        float f1 = r1.nextFloat();
        float f2 = r2.nextFloat();
        ScFloat ScF1 = new ScFloat(f1);
        ScFloat ScF2 = new ScFloat(f2);
        String string1 = f1 + s1;
        String string2 = f2 + s1;
        String string3 = f1 + s2;
        String string4 = f2 + s2;
        ScString expectedSum1 = new ScString(string1);
        ScString expectedSum2 = new ScString(string2);
        ScString expectedSum3 = new ScString(string3);
        ScString expectedSum4 = new ScString(string4);
        ScString actualStr1 = str1.addScFloat(ScF1);
        ScString actualStr2 = str1.addScFloat(ScF2);
        ScString actualStr3 = str2.addScFloat(ScF1);
        ScString actualStr4 = str2.addScFloat(ScF2);
        assertEquals(expectedSum1, actualStr1);
        assertEquals(expectedSum2, actualStr2);
        assertEquals(expectedSum3, actualStr3);
        assertEquals(expectedSum4, actualStr4);
    }

    @RepeatedTest(100)
    void addFloatTest() {
        float f1 = r1.nextFloat();
        float f2 = r2.nextFloat();
        ScFloat ScF1 = new ScFloat(f1);
        ScFloat ScF2 = new ScFloat(f2);
        String string1 = s1 + f1;
        String string2 = s1 + f2;
        String string3 = s2 + f1;
        String string4 = s2 + f2;
        ScString expectedSum1 = new ScString(string1);
        ScString expectedSum2 = new ScString(string2);
        ScString expectedSum3 = new ScString(string3);
        ScString expectedSum4 = new ScString(string4);
        ScString actualStr1 = str1.add(ScF1);
        ScString actualStr2 = str1.add(ScF2);
        ScString actualStr3 = str2.add(ScF1);
        ScString actualStr4 = str2.add(ScF2);
        assertEquals(expectedSum1, actualStr1);
        assertEquals(expectedSum2, actualStr2);
        assertEquals(expectedSum3, actualStr3);
        assertEquals(expectedSum4, actualStr4);
    }

    @RepeatedTest(100)
    void addScIntTest() {
        int n1 = r1.nextInt();
        int n2 = r2.nextInt();
        ScInt ScInt1 = new ScInt(n1);
        ScInt ScInt2 = new ScInt(n2);
        String string1 = n1 + s1;
        String string2 = n2 + s1;
        String string3 = n1 + s2;
        String string4 = n2 + s2;
        ScString expectedSum1 = new ScString(string1);
        ScString expectedSum2 = new ScString(string2);
        ScString expectedSum3 = new ScString(string3);
        ScString expectedSum4 = new ScString(string4);
        ScString actualStr1 = str1.addScInt(ScInt1);
        ScString actualStr2 = str1.addScInt(ScInt2);
        ScString actualStr3 = str2.addScInt(ScInt1);
        ScString actualStr4 = str2.addScInt(ScInt2);
        assertEquals(expectedSum1, actualStr1);
        assertEquals(expectedSum2, actualStr2);
        assertEquals(expectedSum3, actualStr3);
        assertEquals(expectedSum4, actualStr4);
    }

    @RepeatedTest(100)
    void addIntTest() {
        int n1 = r1.nextInt();
        int n2 = r2.nextInt();
        ScInt ScInt1 = new ScInt(n1);
        ScInt ScInt2 = new ScInt(n2);
        String string1 = s1 + n1;
        String string2 = s1 + n2;
        String string3 = s2 + n1;
        String string4 = s2 + n2;
        ScString expectedSum1 = new ScString(string1);
        ScString expectedSum2 = new ScString(string2);
        ScString expectedSum3 = new ScString(string3);
        ScString expectedSum4 = new ScString(string4);
        ScString actualStr1 = str1.add(ScInt1);
        ScString actualStr2 = str1.add(ScInt2);
        ScString actualStr3 = str2.add(ScInt1);
        ScString actualStr4 = str2.add(ScInt2);
        assertEquals(expectedSum1, actualStr1);
        assertEquals(expectedSum2, actualStr2);
        assertEquals(expectedSum3, actualStr3);
        assertEquals(expectedSum4, actualStr4);
    }

    @RepeatedTest(100)
    void addScBinaryTest() {
        int n1 = r1.nextInt();
        int n2 = r2.nextInt();
        String bin1 = intToBin(n1);
        String bin2 = intToBin(n2);
        ScBinary ScBin1 = new ScBinary(bin1);
        ScBinary ScBin2 = new ScBinary(bin2);
        String string1 = bin1 + s1;
        String string2 = bin2 + s1;
        String string3 = bin1 + s2;
        String string4 = bin2 + s2;
        ScString expectedSum1 = new ScString(string1);
        ScString expectedSum2 = new ScString(string2);
        ScString expectedSum3 = new ScString(string3);
        ScString expectedSum4 = new ScString(string4);
        ScString actualStr1 = str1.addScBinary(ScBin1);
        ScString actualStr2 = str1.addScBinary(ScBin2);
        ScString actualStr3 = str2.addScBinary(ScBin1);
        ScString actualStr4 = str2.addScBinary(ScBin2);
        assertEquals(expectedSum1, actualStr1);
        assertEquals(expectedSum2, actualStr2);
        assertEquals(expectedSum3, actualStr3);
        assertEquals(expectedSum4, actualStr4);
    }

    @RepeatedTest(100)
    void addBinaryTest() {
        int n1 = r1.nextInt();
        int n2 = r2.nextInt();
        String bin1 = intToBin(n1);
        String bin2 = intToBin(n2);
        ScBinary ScBin1 = new ScBinary(bin1);
        ScBinary ScBin2 = new ScBinary(bin2);
        String string1 = s1 + bin1;
        String string2 = s1 + bin2;
        String string3 = s2 + bin1;
        String string4 = s2 + bin2;
        ScString expectedSum1 = new ScString(string1);
        ScString expectedSum2 = new ScString(string2);
        ScString expectedSum3 = new ScString(string3);
        ScString expectedSum4 = new ScString(string4);
        ScString actualStr1 = str1.add(ScBin1);
        ScString actualStr2 = str1.add(ScBin2);
        ScString actualStr3 = str2.add(ScBin1);
        ScString actualStr4 = str2.add(ScBin2);
        assertEquals(expectedSum1, actualStr1);
        assertEquals(expectedSum2, actualStr2);
        assertEquals(expectedSum3, actualStr3);
        assertEquals(expectedSum4, actualStr4);
    }
}

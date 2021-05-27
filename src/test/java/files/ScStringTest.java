package files;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

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

    @RepeatedTest(1000)
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

}

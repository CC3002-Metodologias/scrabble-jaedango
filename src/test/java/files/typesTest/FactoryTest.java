package files.typesTest;

import files.types.BooleanFactory;
import files.types.ScBoolean;
import files.types.ScString;
import files.types.StringFactory;
import files.types.numbers.NumberFactory;
import files.types.numbers.ScBinary;
import files.types.numbers.ScFloat;
import files.types.numbers.ScInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FactoryTest {
    NumberFactory numberFactory = new NumberFactory();
    BooleanFactory booleanFactory = new BooleanFactory();
    StringFactory stringFactory = new StringFactory();
    ScInt n1;
    ScInt n2;
    ScInt n3;
    ScFloat f1;
    ScFloat f2;
    ScFloat f3;
    ScBinary bin1;
    ScBinary bin2;
    ScBinary bin3;
    ScBoolean true1;
    ScBoolean true2;
    ScBoolean false1;
    ScBoolean false2;
    ScString str1;
    ScString str2;
    ScString str3;

    @BeforeEach
    void setUp() {
        n1 = numberFactory.getScInt(10);
        n2 = numberFactory.getScInt(15);
        n3 = numberFactory.getScInt(10);
        f1 = numberFactory.getScFloat(103.142f);
        f2 = numberFactory.getScFloat(3.5f);
        f3 = numberFactory.getScFloat(103.142f);
        bin1 = numberFactory.getScBinary("10010");
        bin2 = numberFactory.getScBinary("10110");
        bin3 = numberFactory.getScBinary("10010");
        true1 = booleanFactory.getScBoolean(true);
        true2 = booleanFactory.getScBoolean(true);
        false1 = booleanFactory.getScBoolean(false);
        false2 = booleanFactory.getScBoolean(false);
        str1 = stringFactory.getScString("hola");
        str2 = stringFactory.getScString("hola");
        str3 = stringFactory.getScString("chao");
    }

    @Test
    void NumberFactoryTest() {
        assertEquals(n1, n3);
        assertEquals(f1, f3);
        assertEquals(bin1, bin3);
        assertTrue(n1==n3);
        assertTrue(n1!=n2);
        assertTrue(f1==f3);
        assertTrue(f1!=f2);
        assertTrue(bin1==bin3);
        assertTrue(bin1!=bin2);
    }

    @Test
    void booleanFactoryTest() {
        assertEquals(true1, true2);
        assertEquals(false1, false2);
        assertTrue(true1==true2);
        assertTrue(false1==false2);
        assertTrue(true1!=false1);
    }

    @Test
    void stringFactoryTest() {
        assertEquals(str1, str2);
        assertTrue(str1==str2);
        assertTrue(str1!=str3);
    }

}

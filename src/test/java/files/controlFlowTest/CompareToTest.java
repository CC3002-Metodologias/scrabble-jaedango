package files.controlFlowTest;

import files.controlFlow.CompareTo;
import files.operations.constant.ConstantFactory;
import files.operations.constant.ConstantNum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static files.types.numbers.BinaryToInt.intToBin;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompareToTest {
    ConstantFactory c = new ConstantFactory();
    int greater, lesser, equal;
    int int1, int2, int3;
    float float1, float2, float3;
    String bin1, bin2, bin3;
    ConstantNum cn1, cn2, cn3, cf1, cf2, cf3, cb1, cb2, cb3;

    @BeforeEach
    void setUp() {
        // Values to compare
        greater = 1;
        lesser = -1;
        equal = 0;
        // int
        int1 = -534;
        int2 = 5;
        int3 = 423;
        cn1 = c.cNum(int1);
        cn2 = c.cNum(int2);
        cn3 = c.cNum(int3);
        // bin
        bin1 = intToBin(int1);
        bin2 = intToBin(int2);
        bin3 = intToBin(int3);
        cb1 = c.cNum(bin1);
        cb2 = c.cNum(bin2);
        cb3 = c.cNum(bin3);
        // float
        float1 = -534.342f;
        float2 = 5.0f;
        float3 = 423.165f;
        cf1 = c.cNum(float1);
        cf2 = c.cNum(float2);
        cf3 = c.cNum(float3);
    }

    @Test
    void CompareIntTest() {
        assertEquals(equal, new CompareTo(cn3, cn3).eval());
        assertEquals(greater, new CompareTo(cn3, cn2).eval());
        assertEquals(greater, new CompareTo(cn3, cn1).eval());
        assertEquals(lesser, new CompareTo(cn2, cn3).eval());
        assertEquals(equal, new CompareTo(cn2, cn2).eval());
        assertEquals(greater, new CompareTo(cn2, cn1).eval());
        assertEquals(lesser, new CompareTo(cn1, cn3).eval());
        assertEquals(lesser, new CompareTo(cn1, cn2).eval());
        assertEquals(equal, new CompareTo(cn1, cn1).eval());
    }

    @Test
    void CompareBinTest() {
        assertEquals(equal, new CompareTo(cb3, cb3).eval());
        assertEquals(greater, new CompareTo(cb3, cb2).eval());
        assertEquals(greater, new CompareTo(cb3, cb1).eval());
        assertEquals(lesser, new CompareTo(cb2, cb3).eval());
        assertEquals(equal, new CompareTo(cb2, cb2).eval());
        assertEquals(greater, new CompareTo(cb2, cb1).eval());
        assertEquals(lesser, new CompareTo(cb1, cb3).eval());
        assertEquals(lesser, new CompareTo(cb1, cb2).eval());
        assertEquals(equal, new CompareTo(cb1, cb1).eval());
    }

    @Test
    void CompareFloatTest() {
        assertEquals(equal, new CompareTo(cf3, cf3).eval());
        assertEquals(greater, new CompareTo(cf3, cf2).eval());
        assertEquals(greater, new CompareTo(cf3, cf1).eval());
        assertEquals(lesser, new CompareTo(cf2, cf3).eval());
        assertEquals(equal, new CompareTo(cf2, cf2).eval());
        assertEquals(greater, new CompareTo(cf2, cf1).eval());
        assertEquals(lesser, new CompareTo(cf1, cf3).eval());
        assertEquals(lesser, new CompareTo(cf1, cf2).eval());
        assertEquals(equal, new CompareTo(cf1, cf1).eval());
    }

    @Test
    void CompareIntBinTest() {
        assertEquals(equal, new CompareTo(cn3, cb3).eval());
        assertEquals(greater, new CompareTo(cn3, cb2).eval());
        assertEquals(greater, new CompareTo(cn3, cb1).eval());
        assertEquals(lesser, new CompareTo(cn2, cb3).eval());
        assertEquals(equal, new CompareTo(cn2, cb2).eval());
        assertEquals(greater, new CompareTo(cn2, cb1).eval());
        assertEquals(lesser, new CompareTo(cn1, cb3).eval());
        assertEquals(lesser, new CompareTo(cn1, cb2).eval());
        assertEquals(equal, new CompareTo(cn1, cb1).eval());

        assertEquals(equal, new CompareTo(cb3, cn3).eval());
        assertEquals(greater, new CompareTo(cb3, cn2).eval());
        assertEquals(greater, new CompareTo(cb3, cn1).eval());
        assertEquals(lesser, new CompareTo(cb2, cn3).eval());
        assertEquals(equal, new CompareTo(cb2, cn2).eval());
        assertEquals(greater, new CompareTo(cb2, cn1).eval());
        assertEquals(lesser, new CompareTo(cb1, cn3).eval());
        assertEquals(lesser, new CompareTo(cb1, cn2).eval());
        assertEquals(equal, new CompareTo(cb1, cn1).eval());
    }

    @Test
    void CompareIntFloatTest() {
        assertEquals(lesser, new CompareTo(cn3, cf3).eval());
        assertEquals(greater, new CompareTo(cn3, cf2).eval());
        assertEquals(greater, new CompareTo(cn3, cf1).eval());
        assertEquals(lesser, new CompareTo(cn2, cf3).eval());
        assertEquals(equal, new CompareTo(cn2, cf2).eval());
        assertEquals(greater, new CompareTo(cn2, cf1).eval());
        assertEquals(lesser, new CompareTo(cn1, cf3).eval());
        assertEquals(lesser, new CompareTo(cn1, cf2).eval());
        assertEquals(greater, new CompareTo(cn1, cf1).eval());

        assertEquals(greater, new CompareTo(cf3, cn3).eval());
        assertEquals(greater, new CompareTo(cf3, cn2).eval());
        assertEquals(greater, new CompareTo(cf3, cn1).eval());
        assertEquals(lesser, new CompareTo(cf2, cn3).eval());
        assertEquals(equal, new CompareTo(cf2, cn2).eval());
        assertEquals(greater, new CompareTo(cf2, cn1).eval());
        assertEquals(lesser, new CompareTo(cf1, cn3).eval());
        assertEquals(lesser, new CompareTo(cf1, cn2).eval());
        assertEquals(lesser, new CompareTo(cf1, cn1).eval());
    }

    @Test
    void CompareBinFloatTest() {
        assertEquals(lesser, new CompareTo(cb3, cf3).eval());
        assertEquals(greater, new CompareTo(cb3, cf2).eval());
        assertEquals(greater, new CompareTo(cb3, cf1).eval());
        assertEquals(lesser, new CompareTo(cb2, cf3).eval());
        assertEquals(equal, new CompareTo(cb2, cf2).eval());
        assertEquals(greater, new CompareTo(cb2, cf1).eval());
        assertEquals(lesser, new CompareTo(cb1, cf3).eval());
        assertEquals(lesser, new CompareTo(cb1, cf2).eval());
        assertEquals(greater, new CompareTo(cb1, cf1).eval());

        assertEquals(greater, new CompareTo(cf3, cb3).eval());
        assertEquals(greater, new CompareTo(cf3, cb2).eval());
        assertEquals(greater, new CompareTo(cf3, cb1).eval());
        assertEquals(lesser, new CompareTo(cf2, cb3).eval());
        assertEquals(equal, new CompareTo(cf2, cb2).eval());
        assertEquals(greater, new CompareTo(cf2, cb1).eval());
        assertEquals(lesser, new CompareTo(cf1, cb3).eval());
        assertEquals(lesser, new CompareTo(cf1, cb2).eval());
        assertEquals(lesser, new CompareTo(cf1, cb1).eval());
    }
}

package files.operationsTets;

import files.operations.constant.ConstantLogical;
import files.operations.constant.ConstantNum;
import files.operations.constant.ConstantString;
import files.operations.ops.LogicOps.And;
import files.operations.ops.NumOps.Add;
import files.types.BooleanFactory;
import files.types.StringFactory;
import files.types.numbers.NumberFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationsTest {
    BooleanFactory b = new BooleanFactory();
    NumberFactory n = new NumberFactory();
    StringFactory s = new StringFactory();
    ConstantLogical b1;
    ConstantLogical b2;
    ConstantLogical b3;
    ConstantNum n1;
    ConstantNum n2;
    ConstantNum n3;
    ConstantString s1;
    ConstantString s2;
    ConstantString s3;


    @BeforeEach
    void setUp() {
        b1 = new ConstantLogical(b.getScBoolean(true));
        b2 = new ConstantLogical(b.getScBoolean(false));
        b3 = new ConstantLogical(n.getScBinary("0101"));
        n1 = new ConstantNum(n.getScInt(10));
        n2 = new ConstantNum(n.getScInt(5));
        n3 = new ConstantNum(n.getScBinary("0010"));
        s1 = new ConstantString(s.getScString("hola"));
        s2 = new ConstantString(s.getScString("como estas? "));
        s3 = new ConstantString(s.getScString("010101"));

    }

    @Test
    void test1() {
        System.out.println(new And(b1, b2).eval());
        assertEquals(new And(b1, b2).eval(), b2);
        System.out.println(new And(b1, new And(b1, b2)).eval());
        System.out.println(new And(b2,b3).eval());
        System.out.println(new And(b1,n3).eval());
        System.out.println(new Add(n1, n2).eval());
        System.out.println(new Add(n1, new Add(n1, n2)).eval());
        System.out.println(new Add(new Add(n1,n1), new Add(n2, n2)).eval());
        System.out.println(new Add(n3, b3).eval());
        System.out.println(new Add(n1, b3).eval());
        System.out.println(new Add(b3, n1).eval());
        System.out.println(new Add(s1, s2).eval());
    }
}

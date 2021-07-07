package files;

import files.operations.numOps.Add;
import files.types.BooleanFactory;
import files.types.numbers.NumberFactory;
import files.types.numbers.ScNumber;
import org.junit.jupiter.api.Test;

import static files.operations.iOperations.*;

public class OperationsTest {
    NumberFactory n = new NumberFactory();
    BooleanFactory b = new BooleanFactory();

    @Test
    void test1() {
        System.out.println(add(n.getScInt(5), sub(n.getScInt(3),n.getScInt(2))).toString());
        System.out.println(and(b.getScBoolean(true), or (b.getScBoolean(false), b.getScBoolean(true))));
        System.out.println(
                add(
                    add(
                        n.getScBinary("1000"),
                        sub(
                            n.getScInt(25),
                                ((ScNumber) or(n.getScBinary("0101"), b.getScBoolean(false))).toScInt()

                        )
                    ),
                    n.getScFloat(6.9f)));
        System.out.println(((ScNumber) or(n.getScBinary("0101"), b.getScBoolean(false))).toScInt());
        System.out.println(sub(n.getScInt(25), n.getScInt(5)));
        System.out.println(add(n.getScBinary("1000"), n.getScInt(20)));
        System.out.println(n.getScBinary("1000").toScInt());

        // binary can't be used with or with another binary
        /*System.out.println(add(
                (ScNumber) or(
                    n.getScBinary("1000"),
                    sub(
                        n.getScInt(25),
                        n.getScBinary("0101")
                    ).toScInt().toScBinary()
                ),
                n.getScFloat(6.9f)));*/
    }

    @Test
    void test2() {
        System.out.println(new Add(n.getScInt(5), n.getScInt(7)));
        System.out.println(new Add(n.getScInt(1), new Add(n.getScInt(7), n.getScInt(2))));
    }

}

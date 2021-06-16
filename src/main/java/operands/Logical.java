package operands;

import types.ScBool;
import types.numbers.ScBinary;

/**
 * @author <a href=mailto:ignacio.slater@ug.uchile.cl>Ignacio Slater Muñoz</a>
 * @author jaedango
 */

public interface Logical {

    /**
     * Logical operations "and" & "or"
     */
    Logical and(Logical conjunct);

    Logical andBool(ScBool bool);

    Logical or(Logical operand);

    Logical orBool(Logical operand);

    Logical andBinary(ScBinary sBinary);

}

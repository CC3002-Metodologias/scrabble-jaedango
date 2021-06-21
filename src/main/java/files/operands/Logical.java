package files.operands;

import files.types.ScBoolean;
import files.types.numbers.ScBinary;

/**
 * @author jaedango
 */

public interface Logical {
    Logical and(Logical conjunct);

    Logical or(Logical conjunct);

    Logical andBool(ScBoolean operand);

    Logical orBool(ScBoolean operand);

    Logical andBinary(ScBinary operand);

    Logical orBinary(ScBinary operand);
}

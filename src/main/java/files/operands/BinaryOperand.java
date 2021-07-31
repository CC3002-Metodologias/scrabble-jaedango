package files.operands;

import files.types.numbers.ScBinary;
import files.types.numbers.ScFloat;
import files.types.numbers.ScInt;

/**
 * @author jaedango
 */

public interface BinaryOperand {
    /**
     * to cast a binary as other type
     */
    ScInt toScInt();

    ScBinary toScBinary();

    ScFloat toScFloat();

}

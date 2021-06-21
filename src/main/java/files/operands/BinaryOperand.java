package files.operands;

import files.types.numbers.ScBinary;
import files.types.numbers.ScFloat;
import files.types.numbers.ScInt;
import files.types.numbers.ScNumber;

/**
 * @author jaedango
 */

public interface BinaryOperand {
    /**
     * Binary Ops : add (+), subs (-), multiply (*), divide (/)
     * @return new ScBinary
     */
    ScNumber addToBin(ScBinary addend);

    ScNumber subToBin(ScBinary substrate);

    ScNumber mulToBin(ScBinary product);

    ScNumber divToBin(ScBinary dividend);

    /**
     * to cast a binary as other type
     */
    ScInt toScInt();

    ScBinary toScBinary();

    ScFloat toScFloat();

}

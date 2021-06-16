package operands;

import types.numbers.ScBinary;
import types.numbers.ScInt;

/**
 * @author <a href=mailto:ignacio.slater@ug.uchile.cl>Ignacio Slater Muñoz</a>
 * @author jaedango
 */
public interface BinaryOperand {

    /**
     * Binary Ops : add (+), subs (-), multiply (*), divide (/)
     * @return new ScBinary
     */
    ScBinary addToBinary(ScBinary addend);

    ScBinary subtractToBinary(ScBinary subtractor);

    ScBinary multiplyToBinary(ScBinary product);

    ScBinary divideToBinary(ScBinary dividend);

    /**
     * to cast a binary as other type
     */
    ScInt asInt();

    ScBinary asBinary();

}

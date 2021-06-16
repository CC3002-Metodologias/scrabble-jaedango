package types.numbers;

import operands.BinaryOperand;
import operands.Logical;
import types.AbstractType;
import types.ScBool;
import types.ScString;

import static types.numbers.BinaryToInt.binToInt;

/**
 * @author <a href=mailto:ignacio.slater@ug.uchile.cl>Ignacio Slater Muñoz</a>
 * @author jaedango
 */

public class ScBinary extends AbstractType implements ScNumber, BinaryOperand, Logical {
    private final String value;


    public ScBinary(String value) {
        this.value = value;
    }

    // region : CAST
    @Override
    public ScString asString() {
        return new ScString(value);
    }

    @Override
    public ScFloat asFloat() {
        return null;
    }

    @Override
    public ScInt asInt() {
        return new ScInt(binToInt(this.value));
    }

    @Override
    public ScBinary asBinary() {
        return new ScBinary(this.value);
    }
    
    // endregion

    // region : OPERATIONS
    @Override
    public Logical and(Logical conjunct) {
        return conjunct.andBinary(this);
    }

    @Override
    public Logical or(Logical operand) {
        return null;
    }

    public BinaryOperand add(BinaryOperand addend) {
        return addend.addToBinary(this);
    }

    public BinaryOperand multiply(BinaryOperand product) {
        return product.multiplyToBinary(this);
    }

    public BinaryOperand subtract(BinaryOperand subtractor) {
        return subtractor.subtractToBinary(this);
    }

    public BinaryOperand divide(BinaryOperand divisor) {
        return divisor.divideToBinary(this);
    }
    // endregion

    // region : DOUBLE DISPATCH
    @Override
    public ScString addToString(ScString addend) {
        return new ScString(this.value + addend.toString());
    }

    @Override
    public ScBinary addToBinary(ScBinary addend) {
        return null;
    }

    @Override
    public ScBinary subtractToBinary(ScBinary subtractor) {
        return null;
    }

    @Override
    public ScBinary multiplyToBinary(ScBinary product) {
        return null;
    }

    @Override
    public ScBinary divideToBinary(ScBinary dividend) {
        return null;
    }

    @Override
    public Logical andBool(ScBool bool) {
        return null;
    }

    @Override
    public Logical orBool(Logical operand) {
        return null;
    }

    @Override
    public Logical andBinary(ScBinary sBinary) {
        return null;
    }

    @Override
    public ScBinary addToInt(ScInt addend) {
        return null;
    }

    @Override
    public ScNumber subtractToInt(ScInt subtrahend) {
        return null;
    }

    @Override
    public ScBinary multiplyToInt(ScInt product) {
        return null;
    }

    @Override
    public ScBinary divideToInt(ScInt dividend) {
        return null;
    }

    @Override
    public ScFloat addToFloat(ScFloat addend) {
        return null;
    }

    @Override
    public ScFloat subtractToFloat(ScFloat subtrahend) {
        return null;
    }

    @Override
    public ScFloat multiplyToFloat(ScFloat product) {
        return null;
    }

    @Override
    public ScFloat divideToFloat(ScFloat divisor) {
        return null;
    }



    // endregion
}

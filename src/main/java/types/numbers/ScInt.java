package types.numbers;

import operands.BinaryOperand;
import types.AbstractType;
import types.ScString;

/**
 * @author <a href=mailto:ignacio.slater@ug.uchile.cl>Ignacio Slater Muñoz</a>
 * @author jaedango
 */

public class ScInt extends AbstractType implements ScNumber, BinaryOperand {
    private final int value;

    public ScInt(int value) {
        this.value = value;
    }

    protected int getValue() {
        return this.value;
    }

    // region : Casts
    @Override
    public ScString asString() {
        return new ScString(Integer.toString(value));
    }

    @Override
    public ScInt asInt() {
        return new ScInt(value);
    }

    @Override
    public ScBinary asBinary() {
        return new ScBinary(this.toBinaryStr());
    }

    @Override
    public ScFloat asFloat() {
        return null;
    }

    @Override
    public ScString addToString(ScString addend) {
        return new ScString(Integer.toString(value) + addend.toString());
    }
    // endregion

    // region : Operations
    public ScNumber add(ScNumber addend) {
        return addend.addToInt(this);
    }

    public ScNumber subtract(ScNumber subtrahend) {
        return subtrahend.subtractToInt(this);
    }

    public ScNumber multiply(ScNumber product) {
        return product.multiplyToInt(this);
    }

    public ScNumber divide(ScNumber divisor) {
        return divisor.divideToInt(this);
    }
    // endregion

    // region : Double Dispatch
    @Override
    public ScInt addToInt(ScInt addend) {
        return new ScInt(this.value + addend.value);
    }

    @Override
    public ScInt subtractToInt(ScInt subtrahend) {
        return new ScInt(this.value - subtrahend.value);
    }

    @Override
    public ScInt multiplyToInt(ScInt product) {
        return new ScInt(this.value * product.value);
    }

    @Override
    public ScInt divideToInt(ScInt dividend) {
        return new ScInt(this.value / dividend.value);
    }


    @Override
    public ScFloat addToFloat(ScFloat addend) {
        return new ScFloat((double)this.value + addend.getValue());
    }
    @Override
    public ScFloat subtractToFloat(ScFloat subtrahend) {
        return new ScFloat((double) this.value - subtrahend.getValue());
    }

    @Override
    public ScFloat multiplyToFloat(ScFloat product) {
        return new ScFloat((double) this.value * product.getValue());
    }

    @Override
    public ScFloat divideToFloat(ScFloat divisor) {
        return new ScFloat((double) this.value / divisor.getValue());
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

    // endregion
    private String toBinaryStr() {
        return null;
    }
}

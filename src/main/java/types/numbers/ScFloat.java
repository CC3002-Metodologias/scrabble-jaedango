package types.numbers;

import types.ScString;

/**
 * @author <a href=mailto:ignacio.slater@ug.uchile.cl>Ignacio Slater Muñoz</a>
 * @author jaedango
 */

public class ScFloat implements ScNumber {
    protected double value;

    public ScFloat(double value) {
        this.value = value;
    }

    protected double getValue() {
        return this.value;
    }

    // region : Cast
    @Override
    public ScString asString() {
        return new ScString(Double.toString(value));
    }

    @Override
    public ScString addToString(ScString addend) {
        return new ScString(Double.toString(value) + addend.toString());
    }

    public ScFloat asFloat() {
        return new ScFloat(value);
    }
    // endregion

    // region : operations
    public ScFloat add(ScNumber addend) {
        return addend.addToFloat(this);
    }

    public ScFloat subtract(ScNumber subtractor) {
        return subtractor.subtractToFloat(this);
    }

    public ScFloat multiply(ScNumber product) {
        return product.multiplyToFloat(this);
    }

    public ScFloat divide(ScNumber divisor) {
        return divisor.divideToFloat(this);
    }
    // endregion

    // region : Double Dispatch

    @Override
    public ScFloat addToInt(ScInt addend) {
        return new ScFloat(this.value + (double) addend.getValue());
    }

    @Override
    public ScFloat subtractToInt(ScInt subtrahend) {
        return new ScFloat(this.value - (double) subtrahend.getValue());
    }

    @Override
    public ScFloat multiplyToInt(ScInt product) {
        return new ScFloat(this.value * (double) product.getValue());
    }

    @Override
    public ScFloat divideToInt(ScInt dividend) {
        return new ScFloat(this.value / (double) dividend.getValue());
    }

    @Override
    public ScFloat addToFloat(ScFloat addend) {
        return new ScFloat(this.value + addend.value);
    }

    @Override
    public ScFloat subtractToFloat(ScFloat subtrahend) {
        return new ScFloat(this.value - subtrahend.value);
    }

    @Override
    public ScFloat multiplyToFloat(ScFloat product) {
        return new ScFloat(this.value * product.value);
    }

    @Override
    public ScFloat divideToFloat(ScFloat divisor) {
        return new ScFloat(this.value / divisor.value);
    }
    // endregion

}

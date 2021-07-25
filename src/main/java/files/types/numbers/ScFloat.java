package files.types.numbers;

import files.types.ScString;

import java.util.Objects;

import static files.types.numbers.BinaryToInt.binToInt;

/**
 * @author jaedango
 * ScFloat : float for Scrabble
 */

public class ScFloat implements ScNumber {
    protected float value;

    public ScFloat(float v) {
        this.value = v;
    }

    public ScString addScString(ScString addend) {
        return new ScString(addend.toString() + this.toString());
    }

    /**
     * @return float value
     */
    public float getValue() {
        return this.value;
    }

    /**
     * ScFloat getter Method
     * @return String with ScFloat Value
     */
    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScFloat.class, this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScFloat) {
            var other = (ScFloat) obj;
            return Float.compare(this.value, other.value) == 0;
        }
        return false;
    }

    /**
     * Method to transform ScFloat into other classes
     */
    public ScString toScString() {
        return new ScString(String.valueOf(this.value));
    }

    public ScFloat toScFloat() { return new ScFloat(this.value); }

    public ScInt toScInt() {
        return null;
    }

    /**
     * Basic Operations
     */
    public ScFloat add(ScNumber addend) {
        return addend.addToFloat(this);
    }

    public ScFloat sub(ScNumber subtrahend) {
        return subtrahend.subToFloat(this);
    }

    public ScFloat mul(ScNumber product) {
        return product.mulToFloat(this);
    }

    public ScFloat div(ScNumber dividend) {
        return dividend.divToFloat(this);
    }

    /**
     * Methods '+', '-', '*', '/' to operate with other ScFloat
     * @return ScFloat
     */
    public ScFloat addToFloat(ScFloat fl) {
        return new ScFloat(fl.value + this.value);
    }

    public ScFloat subToFloat(ScFloat fl) {
        return new ScFloat(fl.value - this.value);
    }

    public ScFloat mulToFloat(ScFloat fl) {
        return new ScFloat(fl.value * this.value);
    }

    public ScFloat divToFloat(ScFloat fl) {
        return new ScFloat(fl.value / this.value);
    }

    /**
     * Methods '+', '-', '*', '/' to operate with ScInt
     * @return ScFloat
     */
    public ScFloat addToInt(ScInt n) {
        return new ScFloat((float)n.value + this.value);
    }

    public ScFloat subToInt(ScInt n) {
        return new ScFloat((float)n.value - this.value);
    }

    public ScFloat mulToInt(ScInt n) {
        return new ScFloat((float)n.value * this.value);
    }

    public ScFloat divToInt(ScInt n) {
        return new ScFloat((float)n.value / this.value);
    }

    /**
     * Methods '+', '-', '*', '/' to operate with ScBinary
     * @return ScFloat
     */
    public ScFloat addToBin(ScBinary bin) {
        int n = binToInt(bin.value);
        return new ScFloat((float) n + this.value);
    }

    public ScFloat subToBin(ScBinary bin) {
        int n = binToInt(bin.value);
        return new ScFloat((float) n - this.value);
    }

    public ScFloat mulToBin(ScBinary bin) {
        int n = binToInt(bin.value);
        return new ScFloat((float) n * this.value);
    }

    public ScFloat divToBin(ScBinary bin) {
        int n = binToInt(bin.value);
        return new ScFloat((float) n / this.value);
    }
}

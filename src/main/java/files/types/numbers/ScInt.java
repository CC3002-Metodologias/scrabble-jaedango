package files.types.numbers;

import files.operands.BinaryOperand;
import files.types.AbstractType;
import files.types.ScString;

import java.util.Objects;

import static files.types.numbers.BinaryToInt.intToBin;
import static files.types.numbers.BinaryToInt.binToInt;

/**
 * @author jaedango
 * ScInt : Integers for Scrabble
 */

public class ScInt extends AbstractType implements BinaryOperand, ScNumber {
    protected int value;

    public ScInt(int n) {
        this.value = n;
    }

    public int getValue() {
        return this.value;
    }

    /**
     * ScInt getter Method
     * @return String with ScInt value
     */
    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScInt.class, this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScInt) {
            var other = (ScInt) obj;
            return Integer.compare(this.value, other.value) == 0;
        }
        return false;
    }

    public ScString addScString(ScString addend) {
        return new ScString(addend.toString() + this.toString());
    }

    /**
     * Method to transform ScInt into other classes
     */
    @Override
    public ScString toScString() {
        return new ScString(String.valueOf(this.value));
    }

    @Override
    public ScFloat toScFloat() {
        return new ScFloat((float) this.value);
    }

    @Override
    public ScBinary toScBinary() {
        return new ScBinary(intToBin(this.value));
    }

    @Override
    public ScInt toScInt() { return new ScInt(this.value); }

    /**
     * Basic Operations
     */
    public ScNumber add(ScNumber addend) {
        return addend.addToInt(this);
    }

    public ScNumber sub(ScNumber subtrahend) {
        return subtrahend.subToInt(this);
    }

    public ScNumber mul(ScNumber product) {
        return product.mulToInt(this);
    }

    public ScNumber div(ScNumber dividend) {
        return dividend.divToInt(this);
    }

    /**
     * Methods '+', '-', '*', '/' to operate with ScFloat
     * @return ScFloat
     */
    @Override
    public ScFloat addToFloat(ScFloat fl) {
        return new ScFloat(fl.value + (float) this.value);
    }

    @Override
    public ScFloat subToFloat(ScFloat fl) {
        return new ScFloat(fl.value - (float) this.value);
    }

    @Override
    public ScFloat mulToFloat(ScFloat fl) {
        return new ScFloat(fl.value * (float) this.value);
    }

    @Override
    public ScFloat divToFloat(ScFloat fl) {
        return new ScFloat(fl.value / (float) this.value);
    }

    /**
     * Methods '+', '-', '*', '/' to operate with other ScInt
     * @return ScInt
     */
    @Override
    public ScInt addToInt(ScInt n) {
        return new ScInt(n.value + this.value);
    }

    @Override
    public ScInt subToInt(ScInt n) {
        return new ScInt(n.value - this.value);
    }

    @Override
    public ScInt mulToInt(ScInt n) {
        return new ScInt(n.value * this.value);
    }

    @Override
    public ScInt divToInt(ScInt n) {
        return new ScInt(n.value / this.value);
    }

    /**
     * Methods '+', '-', '*', '/' to operate with ScBinary
     * @return ScInt
     */
    @Override
    public ScBinary addToBin(ScBinary bin) {
        int n = binToInt(bin.value);
        return new ScBinary(intToBin(n + this.value));
    }

    @Override
    public ScBinary subToBin(ScBinary bin) {
        int n = binToInt(bin.value);
        return new ScBinary(intToBin(n - this.value));
    }

    @Override
    public ScBinary mulToBin(ScBinary bin) {
        int n = binToInt(bin.value);
        return new ScBinary(intToBin(n * this.value));
    }

    @Override
    public ScBinary divToBin(ScBinary bin) {
        int n = binToInt(bin.value);
        return new ScBinary(intToBin(n / this.value));
    }

}

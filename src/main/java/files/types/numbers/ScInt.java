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
        return new ScString(this.toString() + addend.toString());
    }

    /**
     * Method to transform ScInt into other classes
     */
    public ScString toScString() {
        return new ScString(String.valueOf(this.value));
    }

    public ScFloat toScFloat() {
        return new ScFloat((float) this.value);
    }

    public ScBinary toScBinary() {
        return new ScBinary(intToBin(this.value));
    }

    public ScInt toScInt() { return new ScInt(this.value); }

    /**
     * Methods '+', '-', '*', '/' to operate with ScFloat
     * @return ScFloat
     */
    public ScFloat addToFloat(ScFloat fl) {
        return new ScFloat((float) this.value + fl.value);
    }

    public ScFloat subToFloat(ScFloat fl) {
        return new ScFloat((float) this.value - fl.value);
    }

    public ScFloat mulToFloat(ScFloat fl) {
        return new ScFloat((float) this.value * fl.value);
    }

    public ScFloat divToFloat(ScFloat fl) {
        return new ScFloat((float) this.value / fl.value);
    }

    /**
     * Methods '+', '-', '*', '/' to operate with other ScInt
     * @return ScInt
     */
    public ScInt addToInt(ScInt n) {
        return new ScInt(this.value + n.value);
    }

    public ScInt subToInt(ScInt n) {
        return new ScInt(this.value - n.value);
    }

    public ScInt mulToInt(ScInt n) {
        return new ScInt(this.value * n.value);
    }

    public ScInt divToInt(ScInt n) {
        return new ScInt(this.value / n.value);
    }

    /**
     * Methods '+', '-', '*', '/' to operate with ScBinary
     * @return ScInt
     */
    public ScInt addToBin(ScBinary bin) {
        int n = binToInt(bin.value);
        return new ScInt(this.value + n);
    }

    public ScInt subToBin(ScBinary bin) {
        int n = binToInt(bin.value);
        return new ScInt(this.value - n);
    }

    public ScInt mulToBin(ScBinary bin) {
        int n = binToInt(bin.value);
        return new ScInt(this.value * n);
    }

    public ScInt divToBin(ScBinary bin) {
        int n = binToInt(bin.value);
        return new ScInt(this.value / n);
    }

}

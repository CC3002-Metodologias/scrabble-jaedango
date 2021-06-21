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
        return new ScString(this.toString() + addend.toString());
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

    /**
     * Methods '+', '-', '*', '/' to operate with other ScFloat
     * @return ScFloat
     */
    public ScFloat addToFloat(ScFloat fl) {
        return new ScFloat(this.value + fl.value);
    }

    public ScFloat subToFloat(ScFloat fl) {
        return new ScFloat(this.value - fl.value);
    }

    public ScFloat mulToFloat(ScFloat fl) {
        return new ScFloat(this.value * fl.value);
    }

    public ScFloat divToFloat(ScFloat fl) {
        return new ScFloat(this.value / fl.value);
    }

    /**
     * Methods '+', '-', '*', '/' to operate with ScInt
     * @return ScFloat
     */
    public ScFloat addToInt(ScInt n) {
        return new ScFloat(this.value + (float)n.value);
    }

    public ScFloat subToInt(ScInt n) {
        return new ScFloat(this.value - (float)n.value);
    }

    public ScFloat mulToInt(ScInt n) {
        return new ScFloat(this.value * (float)n.value);
    }

    public ScFloat divToInt(ScInt n) {
        return new ScFloat(this.value / (float)n.value);
    }

    /**
     * Methods '+', '-', '*', '/' to operate with ScBinary
     * @return ScFloat
     */
    public ScFloat addToBin(ScBinary bin) {
        int n = binToInt(bin.value);
        return new ScFloat(this.value + (float) n);
    }

    public ScFloat subToBin(ScBinary bin) {
        int n = binToInt(bin.value);
        return new ScFloat(this.value - (float) n);
    }

    public ScFloat mulToBin(ScBinary bin) {
        int n = binToInt(bin.value);
        return new ScFloat(this.value * (float) n);
    }

    public ScFloat divToBin(ScBinary bin) {
        int n = binToInt(bin.value);
        return new ScFloat(this.value / (float) n);
    }
}

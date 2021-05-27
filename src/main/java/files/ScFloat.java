package files;

import java.util.Objects;

import static files.BinaryToInt.toInt;

/**
 * @author jaedango
 * ScFloat : float for Scrabble
 */

public class ScFloat {
    protected float value;

    public ScFloat(float v) {
        this.value = v;
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
            if (Float.compare(this.value, other.value) == 0) {
                return true;
            } return false;
        }
        return false;
    }

    /**
     * Method to transform ScFloat into other classes
     */
    public ScString toScString() {
        return new ScString(String.valueOf(this.value));
    }

    /**
     * Methods '+', '-', '*', '/' to operate with other ScFloat
     * @return ScFloat
     */
    public ScFloat add(ScFloat fl) {
        return new ScFloat(this.value + fl.value);
    }

    public ScFloat sub(ScFloat fl) {
        return new ScFloat(this.value - fl.value);
    }

    public ScFloat mul(ScFloat fl) {
        return new ScFloat(this.value * fl.value);
    }

    public ScFloat div(ScFloat fl) {
        return new ScFloat(this.value / fl.value);
    }

    /**
     * Methods '+', '-', '*', '/' to operate with ScInt
     * @return ScFloat
     */
    public ScFloat add(ScInt n) {
        return new ScFloat(this.value + (float)n.value);
    }

    public ScFloat sub(ScInt n) {
        return new ScFloat(this.value - (float)n.value);
    }

    public ScFloat mul(ScInt n) {
        return new ScFloat(this.value * (float)n.value);
    }

    public ScFloat div(ScInt n) {
        return new ScFloat(this.value / (float)n.value);
    }

    /**
     * Methods '+', '-', '*', '/' to operate with ScBinary
     * @return ScFloat
     */
    public ScFloat add(ScBinary bin) {
        int n = toInt(bin.value);
        return new ScFloat(this.value + (float) n);
    }

    public ScFloat sub(ScBinary bin) {
        int n = toInt(bin.value);
        return new ScFloat(this.value - (float) n);
    }

    public ScFloat mul(ScBinary bin) {
        int n = toInt(bin.value);
        return new ScFloat(this.value * (float) n);
    }

    public ScFloat div(ScBinary bin) {
        int n = toInt(bin.value);
        return new ScFloat(this.value / (float) n);
    }
}

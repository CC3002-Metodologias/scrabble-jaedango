package files.types;

import files.types.numbers.ScBinary;
import files.types.numbers.ScFloat;
import files.types.numbers.ScInt;

import java.util.Objects;

/**
 * @author jaedango
 * ScString : String for Scrabble
 */

public class ScString extends AbstractType {
    protected String value;

    public ScString(String str) {
        this.value = str;
    }

    /**
     * ScString getter method
     * @return String with ScString value
     */
    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScString.class, this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScString) {
            var other = (ScString) obj;
            return value.equals(other.value);
        }
        return false;
    }


    /**
     * cast this as other types
     * @return new ScString
     */
    public ScString toScString() {
        return new ScString(this.value);
    }

    /**
     * Add to a ScString
     * @param val -> addend
     * @return new ScString with (val + this)
     */
    public ScString add(ScType val) {
        return val.addScString(this);
    }

    /**
     * Method to concatenate ScString with other ScString
     * @return ScString
     */
    public ScString addScString(ScString str) {
        return new ScString(str.value + this.value);
    }

    /**
     * Method to concatenate ScString with ScBoolean
     * @return ScString
     */
    public ScString addScBool(ScBoolean bool) {
        return new ScString(bool.toString() + this.value);
    }

    /**
     * Method to concatenate ScString with ScFloat
     * @return ScString
     */
    public ScString addScFloat(ScFloat fl) {
        return new ScString(fl.toString() + this.value);
    }

    /**
     * Method to concatenate ScString with ScInt
     * @return ScString
     */
    public ScString addScInt(ScInt n) {
        return new ScString(n.toString() + this.value);
    }

    /**
     * Method to concatenate ScString with ScBinary
     * @return ScString
     */
    public ScString addScBinary(ScBinary bin) {
        return new ScString(bin.toString() + this.value);
    }

}

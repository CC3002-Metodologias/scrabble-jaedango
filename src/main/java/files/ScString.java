package files;

import java.util.Objects;

/**
 * @author jaedango
 * ScString : String for Scrabble
 */

public class ScString {
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
        return "ScString { " + this.value + "}";
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
     * Method to concatenate ScString with other ScString
     * @return ScString
     */
    public ScString add(ScString str) {
        return new ScString(this.value + str.value);
    }

    /**
     * Method to concatenate ScString with ScBoolean
     * @return ScString
     */
    public ScString add(ScBoolean bool) {
        return new ScString(this.value + bool.toString());
    }

    /**
     * Method to concatenate ScString with ScFloat
     * @return ScString
     */
    public ScString add(ScFloat fl) {
        return new ScString(this.value + fl.toString());
    }

    /**
     * Method to concatenate ScString with ScInt
     * @return ScString
     */
    public ScString add(ScInt n) {
        return new ScString(this.value + n.toString());
    }

    /**
     * Method to concatenate ScString with ScBinary
     * @return ScString
     */
    public ScString add(ScBinary bin) {
        return new ScString(this.value + bin.toString());
    }

}

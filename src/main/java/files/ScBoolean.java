package files;

import java.util.Objects;

/**
 * @author jaedango
 * ScBoolean : Boolean for Scrabble
 * accepts only true y false values
 */
public class ScBoolean {
    protected boolean value;

    public ScBoolean(boolean val) {
        this.value = val;
    }

    /**
     * ScBoolean getter method
     * @return String with ScBoolean value
     */
    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScBoolean.class, this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScBoolean) {
            var other = (ScBoolean) obj;
            if (Boolean.compare(this.value, other.value) == 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * Method to transform ScBoolean into other classes.
     * @return
     */
    public ScString toScString() {
        return new ScString(String.valueOf(this.value));
    }

    /**
     * Boolean 'not' Method
     * @return not value
     */
    public ScBoolean not() {
        return new ScBoolean(!this.value);
    }

    /**
     * Booleans 'and' and 'or' methods with other booleans
     */
    public ScBoolean and(ScBoolean bool) {
        return new ScBoolean(this.value && bool.value);
    }

    public ScBoolean or(ScBoolean bool) {
        return new ScBoolean(this.value || bool.value);
    }

    /**
     * Boolean 'and' and 'or' method with binary
     */
    public ScBinary and(ScBinary bin) {
        String copy = bin.value;
        StringBuilder str = new StringBuilder();
        for (int i=0;i<copy.length();i++) {
            char c = copy.charAt(i);
            if (c == '0' || !this.value) {
                str.append("0");
            } else {
                str.append("1");
            }
        }
        return new ScBinary(str.toString());
    }

    public ScBinary or(ScBinary bin) {
        String copy = bin.value;
        StringBuilder str = new StringBuilder();
        for (int i=0;i<copy.length();i++) {
            char c = copy.charAt(i);
            if (c == '0' && !this.value) {
                str.append("0");
            } else {
                str.append("1");
            }
        }
        return new ScBinary(str.toString());
    }
}

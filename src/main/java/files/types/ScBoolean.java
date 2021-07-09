package files.types;

import files.operands.Logical;
import files.types.numbers.ScBinary;

import java.util.Objects;

/**
 * @author jaedango
 * ScBoolean : Boolean for Scrabble
 * accepts only true y false values
 */
public class ScBoolean implements ScType, Logical {
    protected boolean value;

    public ScBoolean(boolean val) {
        this.value = val;
    }

    public boolean getValue() {
        return this.value;
    }

    public ScString addScString(ScString addend) {
        return new ScString (addend.toString() + this);
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
            return Boolean.compare(this.value, other.value) == 0;
        }
        return false;
    }

    /**
     * Method to transform ScBoolean into other classes.
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
     * Logical 'and' & 'or'
     * @return new Logical
     */
    public Logical and(Logical bool) {
        return bool.andBool(this);
    }

    public Logical or(Logical bool) {
        return bool.orBool(this);
    }

    /**
     * Booleans 'and' and 'or' methods with other booleans
     */
    public ScBoolean andBool(ScBoolean bool) {
        return new ScBoolean(this.value && bool.value);
    }

    public ScBoolean orBool(ScBoolean bool) {
        return new ScBoolean(this.value || bool.value);
    }

    /**
     * Boolean 'and' and 'or' method with binary
     */
    public ScBinary andBinary(ScBinary bin) {
        String copy = bin.getValue();
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

    public ScBinary orBinary(ScBinary bin) {
        String copy = bin.getValue();
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

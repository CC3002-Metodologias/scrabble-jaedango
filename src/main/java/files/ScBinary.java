package files;

import java.util.Objects;

import static files.BinaryToInt.intToBin;
import static files.BinaryToInt.binToInt;

/**
 * @author jaedango
 * ScBinary : binary for Scrabble
 * accepts only Strings that contains 1's & 0's
 * note that 00001 and 0001 are different
 */

public class ScBinary {
    protected String value;

    public ScBinary(String bin) {
        if (bin.matches("^[01]+$")) {
            this.value = bin;
        } else {
            this.value = "0";
        }
    }

    /**
     * ScBinary getter method
     * @return String with ScBinary value
     */
    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScBinary.class, this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScBinary) {
            var other = (ScBinary) obj;
            return value.equals(other.value);
        }
        return false;
    }

    /**
     * Methods to transform ScBinary into other classes
     */
    public ScString toScString() {
        return new ScString(this.value);
    }

    public ScFloat toScFloat() {
        float f = (float) binToInt(this.value);
        return new ScFloat(f);
    }

    public ScInt toScInt() {
        int n = binToInt(this.value);
        return new ScInt(n);
    }

    /**
     * boolean 'and' operator between boolean and binary
     */

    public ScBinary and(ScBoolean bool) {
        String copy = this.value;
        StringBuilder str = new StringBuilder();
        for (int i=0;i<copy.length();i++) {
            char c = copy.charAt(i);
            if (c=='0' || !bool.value) {
                str.append('0');
            } else {
                str.append('1');
            }
        }
        return new ScBinary(str.toString());
    }

    /**
     * boolean 'or' operator netween boolean and binary
     */
    public ScBinary or(ScBoolean bool) {
        String copy = this.value;
        StringBuilder str = new StringBuilder();
        for (int i=0;i<copy.length();i++) {
            char c = copy.charAt(i);
            if (c=='0' && !bool.value) {
                str.append('0');
            } else {
                str.append('1');
            }
        }
        return new ScBinary(str.toString());
    }

    /**
     * Binary operations with ints
     * @return ScBinary
     */
    public ScBinary add(ScInt n) {
        int val = binToInt(this.value) + n.value;
        return new ScBinary(intToBin(val));
    }

    public ScBinary sub(ScInt n) {
        int val = binToInt(this.value) - n.value;
        return new ScBinary(intToBin(val));
    }

    public ScBinary mul(ScInt n) {
        int val = binToInt(this.value) * n.value;
        return new ScBinary(intToBin(val));
    }

    public ScBinary div(ScInt n) {
        int val = binToInt(this.value) / n.value;
        return new ScBinary(intToBin(val));
    }

    /**
     * Binary operations with other Binary
     * @return
     */
    public ScBinary add(ScBinary bin) {
        int val = binToInt(this.value) + binToInt(bin.value);
        return new ScBinary(intToBin(val));
    }

    public ScBinary sub(ScBinary bin) {
        int val = binToInt(this.value) - binToInt(bin.value);
        return new ScBinary(intToBin(val));
    }

    public ScBinary mul(ScBinary bin) {
        int val = binToInt(this.value) * binToInt(bin.value);
        return new ScBinary(intToBin(val));
    }

    public ScBinary div(ScBinary bin) {
        int val = binToInt(this.value) / binToInt(bin.value);
        return new ScBinary(intToBin(val));
    }

}

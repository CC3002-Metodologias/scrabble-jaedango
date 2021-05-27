package files;

import java.math.BigInteger;
import java.util.Objects;

import static files.BinaryToInt.intToBin;
import static files.BinaryToInt.toInt;

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
            /*if (bin.matches("^[0|1]+.[0|1]+$")){
                this.value = bin;
            }
            else {
                this.value = "Error";
            }*/
            this.value = "0";
        }
    }

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

    public ScString toScString() {
        return new ScString(this.value);
    }

    public ScFloat toScFloat() {
        float f = (float) toInt(this.value);
        return new ScFloat(f);
    }

    public ScInt toScInt() {
        int n = toInt(this.value);
        return new ScInt(n);
    }

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

    public ScBinary add(ScInt n) {
        int val = toInt(this.value) + n.value;
        return new ScBinary(intToBin(val));
    }

    public ScBinary sub(ScInt n) {
        int val = toInt(this.value) - n.value;
        return new ScBinary(intToBin(val));
    }

    public ScBinary mul(ScInt n) {
        int val = toInt(this.value) * n.value;
        return new ScBinary(intToBin(val));
    }

    public ScBinary div(ScInt n) {
        int val = toInt(this.value) / n.value;
        return new ScBinary(intToBin(val));
    }

    public ScBinary add(ScBinary bin) {
        int val = toInt(this.value) + toInt(bin.value);
        return new ScBinary(intToBin(val));
    }

    public ScBinary sub(ScBinary bin) {
        int val = toInt(this.value) - toInt(bin.value);
        return new ScBinary(intToBin(val));
    }

    public ScBinary mul(ScBinary bin) {
        int val = toInt(this.value) * toInt(bin.value);
        return new ScBinary(intToBin(val));
    }

    public ScBinary div(ScBinary bin) {
        int val = toInt(this.value) / toInt(bin.value);
        return new ScBinary(intToBin(val));
    }

}

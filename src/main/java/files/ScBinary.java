package files;

import java.math.BigInteger;
import java.util.Objects;

/**
 * @author jaedango
 * ScBinary : binario para Scrabble
 * acepta solamente Strings que contengan 1's y 0's, ademas de un "." para los tipo float
 */

public class ScBinary {
    private String value;

    public ScBinary(String bin) {
        if (bin.matches("^[01]+$")){
            this.value = bin;
        } else {
            if (bin.matches("^[0|1]+.[0|1]+$")){
                this.value = bin;
            }
            else {
                this.value = "Error";
            }
        }
    }

    @Override
    public String toString() {
        return "ScBinary {" + this.value + "}";
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
        int intBits = new BigInteger(this.value, 2).intValue();
        return new ScFloat(Float.intBitsToFloat(intBits));
    }

    public ScInt toScInt() {
        int n;
        if (this.value.charAt(0) == 1) {
            n = 1;
        } else {
            n = -1;
        }
        String str = this.value.substring(1, this.value.length());
        return new ScInt(n * Integer.parseInt(str, 2));
    }

}

package files;

import java.math.BigInteger;
import java.util.Objects;

import static files.BinaryToInt.toInt;

/**
 * @author jaedango
 * ScBinary : binario para Scrabble
 * acepta solamente Strings que contengan 1's y 0's
 * notese que dada la forma que esta construido 0001 es distinto a 001
 */

public class ScBinary {
    private String value;

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
        float f = (float) toInt(this.value);
        return new ScFloat(f);
    }

    public ScInt toScInt() {
        int n = toInt(this.value);
        return new ScInt(n);
    }

}

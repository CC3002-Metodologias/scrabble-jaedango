package files;

import java.util.Objects;

import static files.BinaryToInt.intToBin;

/**
 * @author jaedango
 * ScInt : Enteros para Scrabble
 */

public class ScInt {
    private int value;

    public ScInt(int n) {
        this.value = n;
    }

    @Override
    public String toString() {
        return "ScInt {" + String.valueOf(this.value) + "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScInt.class, this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScInt) {
            var other = (ScInt) obj;
            if (Integer.compare(this.value, other.value) == 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public ScString toScString() {
        return new ScString(String.valueOf(this.value));
    }

    public ScFloat toScFloat() {
        return new ScFloat((float) this.value);
    }

    public ScBinary toScBinary() {
        return new ScBinary(intToBin(this.value));
    }

}

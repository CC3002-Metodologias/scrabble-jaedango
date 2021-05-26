package files;

import java.util.Objects;

/**
 * @author jaedango
 * ScInt : Enteros para Scrabble
 */

public class ScInt {
    private int val;

    public ScInt(int n) {
        this.val = n;
    }

    @Override
    public String toString() {
        return "ScInt {" + String.valueOf(this.val) + "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScInt.class, this.val);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScInt) {
            var other = (ScInt) obj;
            if (Integer.compare(this.val, other.val) == 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public ScFloat toScFloat() {
        return new ScFloat((float) this.val);
    }

    public ScBinary toScBinary() {
        return new ScBinary(Integer.toBinaryString(this.val));
    }

}

package files;

/**
 * @author jaedango
 * ScInt : Enteros para Scrabble
 */

public class ScInt {
    int val;

    public ScInt(int n) {
        this.val = n;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }

    public ScFloat toScFloat() {
        return new ScFloat((float) this.val);
    }

    public ScBinary toScBinary() {
        return new ScBinary(Integer.toBinaryString(this.val));
    }

}

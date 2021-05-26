package files;

/**
 * @author jaedango
 * ScFloat : float para Scrabble
 */

public class ScFloat {
    float value;

    public ScFloat(float v) {
        this.value = v;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public ScString toScString() {
        return new ScString(this.toString());
    }

}

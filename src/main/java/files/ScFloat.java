package files;

import java.util.Objects;

/**
 * @author jaedango
 * ScFloat : float para Scrabble
 */

public class ScFloat {
    private float value;

    public ScFloat(float v) {
        this.value = v;
    }

    @Override
    public String toString() {
        return "ScFloat {" + String.valueOf(this.value) + "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScFloat.class, this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScFloat) {
            var other = (ScFloat) obj;
            if (Float.compare(this.value, other.value) == 0) {
                return true;
            } return false;
        }
        return false;
    }

    public ScString toScString() {
        return new ScString(String.valueOf(this.value));
    }

}

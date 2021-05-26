package files;

import java.util.Objects;

/**
 * @author jaedango
 * ScBoolean : Booleano para Scrabble
 * acepta valores true y false solamente
 */
public class ScBoolean {
    private boolean value;

    public ScBoolean(boolean val) {
        this.value = val;
    }

    @Override
    public String toString() {
        return "ScBoolean {" + String.valueOf(this.value) + "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScBoolean.class, this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScBoolean) {
            var other = (ScBoolean) obj;
            if (Boolean.compare(this.value, other.value) == 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public ScString toScString() {
        return new ScString(String.valueOf(this.value));
    }

}

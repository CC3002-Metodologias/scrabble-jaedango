package files;

import java.util.Objects;

/**
 * @author jaedango
 * ScString : String para Scrabble
 */

public class ScString {
    private String str;

    public ScString(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "ScString { " + this.str + "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScString.class, this.str);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScString) {
            var other = (ScString) obj;
            return str.equals(other.str);
        }
        return false;
    }
}

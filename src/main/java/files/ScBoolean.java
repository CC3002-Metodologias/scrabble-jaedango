package files;

/**
 * ScBoolean
 */
public class ScBoolean {
    boolean value;
    public ScBoolean(boolean aTrue) {
        this.value = aTrue;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public ScString toScString() {
        return new ScString(this.toString());
    }

}

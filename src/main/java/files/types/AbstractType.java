package files.types;

public abstract class AbstractType implements ScType {
    /**
     * appends ScString at the end of another ScString
     */
    public ScString addToString(ScString addend) {
        return new ScString(this + addend.value);
    }
}

package files.types;

import java.util.Hashtable;

/**
 * @author jaedango
 */

public class BooleanFactory {
    private Hashtable<Boolean, ScBoolean> hashtable = new Hashtable<>();

    /**
     * Scolean Factory
     * @param b -> boolean
     * @return new ScBoolean (or ScBoolean used before with same value)
     */
    public ScBoolean getScBoolean(boolean b) {
        boolean key = b;
        ScBoolean bool = hashtable.get(key);
        if (bool != null) {
            return bool;
        } else {
            bool = new ScBoolean(b);
            hashtable.put(key, bool);
        }
        return bool;
    }
}

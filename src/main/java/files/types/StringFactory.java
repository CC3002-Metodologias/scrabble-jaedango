package files.types;

import java.util.Hashtable;

/**
 * @author jaedango
 */

public class StringFactory {
    private Hashtable<String, ScString> hashtable = new Hashtable<>();

    public ScString getScString(String str) {
        String key = str;
        ScString string = hashtable.get(key);
        if (string != null) {
            return string;
        } else {
            string = new ScString(str);
            hashtable.put(key, string);
        }
        return string;
    }
}

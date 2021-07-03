package files.types.numbers;

import java.util.Hashtable;

/**
 * @author jaedango
 * Number Factory (float, binary or int)
 */

public class NumberFactory {
    private Hashtable<String, ScNumber> hashTable = new Hashtable<>();

    /**
     * ScInt Factory
     * @param num -> some integer
     * @return new ScInt (or an old one with same value)
     */
    public ScInt getScInt(int num) {
        String key = String.valueOf(num);
        ScInt scInt = (ScInt) hashTable.get(key);
        if (scInt != null) {
            return scInt;
        }
        else {
            scInt = new ScInt(num);
            hashTable.put(key, scInt);
        }
        return scInt;
    }

    /**
     * ScFloat Factory
     * @param num -> float point value
     * @return new ScFloat if no one existed, or an old one with same value
     */
    public ScFloat getScFloat(float num) {
        String key = String.valueOf(num);
        ScFloat scFloat = (ScFloat) hashTable.get(key);
        if (scFloat != null) {
            return scFloat;
        }
        else {
            scFloat = new ScFloat(num);
            hashTable.put(key, scFloat);
        }
        return scFloat;
    }

    /**
     * ScBinary Factory
     * @param bin -> Binary String
     * @return new ScBinary if no other used before, or a old one with same value
     */
    public ScBinary getScBinary(String bin) {
        String key = bin;
        ScBinary scBinary = (ScBinary) hashTable.get(key);
        if (scBinary != null) {
            return scBinary;
        } else {
            scBinary = new ScBinary(bin);
            hashTable.put(key, scBinary);
        }
        return scBinary;
    }
}

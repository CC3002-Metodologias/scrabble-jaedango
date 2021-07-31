package files.operations.constant;

import files.operands.Logical;
import files.types.ScBoolean;
import files.types.ScString;
import files.types.numbers.ScBinary;
import files.types.numbers.ScFloat;
import files.types.numbers.ScInt;
import files.types.numbers.ScNumber;

import java.util.Hashtable;

/**
 * @author jaedango
 */

public class ConstantFactory {
    private Hashtable<String, Constant> hashTable = new Hashtable<>();

    /**
     * ConstantNum Factory
     * @param value -> some ScNumber or int, float, binary
     * @return new constantNum (or one already used)
     */
    public ConstantNum cNum(ScNumber value) {
        String key = value.toString() + "cNum";
        ConstantNum constantNum = (ConstantNum) hashTable.get(key);
        if (constantNum != null) {
            return constantNum;
        } else {
            constantNum = new ConstantNum(value);
            hashTable.put(key, constantNum);
        }
        return constantNum;
    }

    // Constant int
    public ConstantNum cNum(int value) {
        String key = String.valueOf(value) + "cNum";
        ConstantNum constantNum = (ConstantNum) hashTable.get(key);
        if (constantNum != null) {
            return constantNum;
        } else {
            constantNum = new ConstantNum(new ScInt(value));
            hashTable.put(key, constantNum);
        }
        return constantNum;
    }

    // Constant float
    public ConstantNum cNum(float value) {
        String key = String.valueOf(value) + "cNum";
        ConstantNum constantNum = (ConstantNum) hashTable.get(key);
        if (constantNum != null) {
            return constantNum;
        } else {
            constantNum = new ConstantNum(new ScFloat(value));
            hashTable.put(key, constantNum);
        }
        return constantNum;
    }

    // Constant binary
    public ConstantNum cNum (String value) {
        String key = value + "cNum";
        ConstantNum constantNum = (ConstantNum) hashTable.get(key);
        if (constantNum != null) {
            return constantNum;
        } else {
            constantNum = new ConstantNum(new ScBinary(value));
            hashTable.put(key, constantNum);
        }
        return constantNum;
    }

    /**
     * ConstantString factory
     * @param value -> some ScString or String
     * @return new ConstantString (or one already used with same value)
     */
    public ConstantString cStr(ScString value) {
        String key = value.toString() + "cStr";
        ConstantString constantString = (ConstantString) hashTable.get(key);
        if (constantString != null) {
            return constantString;
        } else {
            constantString = new ConstantString(value);
            hashTable.put(key, constantString);
        }
        return constantString;
    }

    // Constant String
    public ConstantString cStr(String value) {
        String key = value + "cStr";
        ConstantString constantString = (ConstantString) hashTable.get(key);
        if (constantString != null) {
            return constantString;
        } else {
            constantString = new ConstantString(new ScString(value));
            hashTable.put(key, constantString);
        }
        return constantString;
    }

    /**
     * ConstantLogical factory
     * @param value -> Some Logical or binary, bool
     * @return -> new ConstantLogical (or one already used with same value)
     */
    public ConstantLogical cLog(Logical value) {
        String key = value.toString() + "cLog";
        ConstantLogical constantLogical = (ConstantLogical) hashTable.get(key);
        if (constantLogical != null) {
            return constantLogical;
        } else {
            constantLogical = new ConstantLogical(value);
            hashTable.put(key, constantLogical);
        }
        return constantLogical;
    }

    public ConstantLogical cLog(boolean value) {
        String key = String.valueOf(value) + "cLog";
        ConstantLogical constantLogical = (ConstantLogical) hashTable.get(key);
        if (constantLogical != null) {
            return constantLogical;
        } else {
            constantLogical = new ConstantLogical(new ScBoolean(value));
            hashTable.put(key, constantLogical);
        }
        return constantLogical;
    }
    public ConstantLogical cLog(String value) {
        String key = value + "cLog";
        ConstantLogical constantLogical = (ConstantLogical) hashTable.get(key);
        if (constantLogical != null) {
            return constantLogical;
        } else {
            constantLogical = new ConstantLogical(new ScBinary(value));
            hashTable.put(key, constantLogical);
        }
        return constantLogical;
    }

    // Variables

    /**
     * Variables values -> can be String, float, int, binary or boolean
     * @param name -> String representing the variable name
     * @param value -> Value of the variable
     */
    public ConstantNum variable(String name, int value) {
        ConstantNum constantNum = new ConstantNum(new ScInt(value));
        hashTable.put(name, constantNum);
        return constantNum;
    }

    public ConstantNum variable(String name, float value) {
        ConstantNum constantNum = new ConstantNum(new ScFloat(value));
        hashTable.put(name, constantNum);
        return constantNum;
    }

    public Constant variable(String name, String value) {
        if (value.matches("^[01]+$")) {
            ConstantNum constantNum = new ConstantNum(new ScBinary(value));
            hashTable.put(name, constantNum);
            return constantNum;
        }
        else {
            ConstantString constantString = new ConstantString(new ScString(value));
            hashTable.put(name, constantString);
            return constantString;
        }
    }

    public ConstantLogical variable(String name, boolean value) {
        ConstantLogical constantLogical = new ConstantLogical(new ScBoolean(value));
        hashTable.put(name, constantLogical);
        return constantLogical;
    }

    public Constant variable(String value) {
        Constant constant = hashTable.get(value);
        return constant;
    }


}

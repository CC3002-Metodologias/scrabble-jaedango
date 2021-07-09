package files.operations.constant;

import files.operands.Logical;
import files.types.ScString;
import files.types.ScType;
import files.types.numbers.ScNumber;

import java.util.Hashtable;

public class ConstantFactory {
    private Hashtable<String, Constant> hashTable = new Hashtable<>();

    /**
     * ConstantNum Factory
     * @param value -> some ScNumber
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
}

package files.operations.constant;

import files.operations.Ops;
import files.operations.ops.Operations;
import files.types.ScBoolean;
import files.types.ScString;
import files.types.numbers.ScBinary;
import files.types.numbers.ScFloat;
import files.types.numbers.ScInt;

import java.util.Hashtable;

public class VariableFactory {
    private Hashtable<String, Ops> hashTable = new Hashtable<>();


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

    public Ops variable(String name) {
        return hashTable.get(name);
    }

    public Operations variable(String name, Operations value) {
        Constant operations = value.eval();
        hashTable.put(name, operations);
        return value;
    }

}
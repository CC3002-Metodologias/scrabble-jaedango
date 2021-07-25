package files.controlFlow;

import files.operations.Ops;
import files.operations.constant.Constant;
import files.operations.constant.ConstantLogical;
import files.operations.ops.Operations;
import files.types.ScBoolean;

public class While implements Control {
    ConstantLogical condition;
    Ops whileTrue;


    public While(ConstantLogical condition, Ops whileTrue) {
        this.condition = condition;
        this.whileTrue = whileTrue;
    }

    public While(boolean condition, Ops whileTrue) {
        this.condition = new ConstantLogical(new ScBoolean(condition));
        this.whileTrue = whileTrue;
    }



    @Override
    public Ops eval() {
        ScBoolean scBoolean = (ScBoolean) condition.getValue();
        boolean aBool = scBoolean.getValue();
        Ops stay = whileTrue;
        System.out.println(stay);
        Constant var1 = (Constant) whileTrue.eval();
        System.out.println(stay + " " + var1);

        if (aBool) {
            return var1;
        } else {
            //whileTrue.getValue();
            //this.condition = condition;
            return new While(condition, stay).eval();
        }
    }

    public Ops val() {
        int i=0;
        while (i<5) {
            i++;
            System.out.println(whileTrue.eval());
        }
        return whileTrue;
    }

}

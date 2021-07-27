package files.controlFlow;

import files.operations.Ops;
import files.operations.constant.Constant;
import files.operations.ops.Operations;

public class While2 implements Control{
    Operations whileTrue;

    public While2(Operations whileTrue) {

        int i=0;
        while(i<3) {
            Operations p = whileTrue;
            System.out.println(whileTrue.eval());
            i++;
        }
        this.whileTrue = whileTrue;
    }

    @Override
    public Ops eval() {
        return whileTrue;
    }
}

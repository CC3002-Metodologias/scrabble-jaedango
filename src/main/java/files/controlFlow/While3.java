package files.controlFlow;

import files.operations.Ops;
import files.operations.constant.Constant;
import files.operations.ops.Operations;

import java.util.function.Supplier;

public class While3 implements Control{
    //Operations whileTrue;
    Supplier<Ops> variable;

    public While3(Ops whileTrue) {
        variable = () -> whileTrue;
    }

    @Override
    public Ops eval() {
        for(int i=0;i<5;i++) {
            variable.get();
            System.out.println(variable.get().eval());
        }

        return null;
    }
}

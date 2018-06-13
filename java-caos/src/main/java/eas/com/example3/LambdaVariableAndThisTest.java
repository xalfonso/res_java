package eas.com.example3;

import eas.com.example1.model.Process;
import org.junit.jupiter.api.Test;

public class LambdaVariableAndThisTest {

    private int variable;

    @Test
    public void testThisInsideLambda() {
        Process process = new Process()
                .setSource("A")
                .setTarget("B")
                .setAction(transitionContext -> {
                    if (this.variable > 0) {
                        System.out.println("Do something");
                    }
                });
        process.execute();
    }


    @Test
    public void testFinalVariable() {
        int result = 1;
        Process process = new Process()
                .setSource("A")
                .setTarget("B")
                .setAction(transitionContext -> {
                    if (result > 0) {
                        System.out.println("Do something");
                    }
                    //result += 1;
                });
        process.execute();
    }


}

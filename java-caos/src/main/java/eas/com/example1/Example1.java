package eas.com.example1;

import eas.com.example1.model.Process;

/**
 * For test ours functional interface.
 *
 * @author Eduardo Alfonso Sanchez
 */
public class Example1 {

    public static void main(String[] args) {
        Process process = new Process()
                .setSource("A")
                .setTarget("B")
                .setAction(transitionContext -> System.out.println("Do something"))
                .setActionWithReturn(string -> string.length());


        process.execute();
    }
}

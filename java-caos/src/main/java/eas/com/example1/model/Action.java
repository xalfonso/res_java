package eas.com.example1.model;

@FunctionalInterface
public interface Action {

    void execute(TransitionContext transitionContext);
}

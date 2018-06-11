package eas.com.example1.model;

public class Process {

    private String source;

    private String target;

    private Action action;

    private ActionWithReturn actionWithReturn;

    public String getSource() {
        return source;
    }

    public Process setSource(String source) {
        this.source = source;
        return this;
    }

    public String getTarget() {
        return target;
    }

    public Process setTarget(String target) {
        this.target = target;
        return this;
    }

    public Action getAction() {
        return action;
    }

    public Process setAction(Action action) {
        this.action = action;
        return this;
    }

    public Process setActionWithReturn(ActionWithReturn actionWithReturn) {
        this.actionWithReturn = actionWithReturn;
        return this;
    }

    public void execute() {
        System.out.println("Execute Lambda of Action Interface: ");
        this.action.execute(new TransitionContext());
        String valor = "Horeca";
        System.out.println("Executing Lambda of ActionWithReturn. String test: " + valor);
        int result = this.actionWithReturn.execute(valor);
        System.out.println("Finished executing Lambda of ActionWithReturn. Result: " + result);
    }
}

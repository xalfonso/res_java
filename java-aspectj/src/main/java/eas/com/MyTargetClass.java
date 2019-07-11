package eas.com;

public class MyTargetClass {

    private String name;

    private Integer value;

    public String exampleMethod() {
        return "The value is " + value;
    }

    public String exampleExternalMethod(){
        return this.exampleMethod();
    }
}

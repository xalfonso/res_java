package eas.com;

public class MainClass {

    public static void main(String[] args) {
        MyTargetClass myTargetClass = new MyTargetClass();
        System.out.println(myTargetClass.exampleMethod());

        System.out.println(myTargetClass.exampleExternalMethod());
    }
}

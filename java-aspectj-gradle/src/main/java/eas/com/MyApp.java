package eas.com;

public class MyApp {
    public void sayHi() {
        System.out.println("Hello World!");
    }

    public void hello() {
        System.out.println("Hello Interceptor");
        sayHi();
    }

}
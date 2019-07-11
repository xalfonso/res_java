package eas.com;

public aspect MannersAspect {
    pointcut callSayMessage() : call(public void eas.com.MyApp.hello*(..));
    before() : callSayMessage() {
        System.out.println("Good day!");
    }
    after() : callSayMessage() {
        System.out.println("Thank you!");
    }
}

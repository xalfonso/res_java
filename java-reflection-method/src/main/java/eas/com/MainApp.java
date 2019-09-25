package eas.com;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainApp {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        SomeInterface someInterface = new SomeClass();
        Class[] parametrosType = new Class[]{String.class, String.class, String.class};
        Object[] parametrosValue = new Object[]{"Eduardo", "Alfonso", "Sanchez"};

        Method metodo = someInterface.getClass().getInterfaces()[0].getMethod("someMethod", parametrosType);
        System.out.println(metodo.invoke(someInterface, parametrosValue));
    }
}

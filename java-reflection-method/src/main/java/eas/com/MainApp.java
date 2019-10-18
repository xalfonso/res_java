package eas.com;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        SomeInterface someInterface = new SomeClass();
        Class[] paramsType = new Class[]{String.class, String.class, String.class};
        Object[] paramsValue = new Object[]{"Eduardo", "Alfonso", "Sanchez"};

        boolean flag = true;

        if (flag) {
            paramsType = Arrays.copyOf(paramsType, paramsType.length + 1);
            paramsType[paramsType.length - 1] = String.class;

            paramsValue = Arrays.copyOf(paramsValue, paramsValue.length + 1);
            paramsValue[paramsValue.length - 1] = "Yess!!!";

        }


        Method metodo = someInterface.getClass().getInterfaces()[0].getMethod("someMethod", paramsType);
        System.out.println(metodo.invoke(someInterface, paramsValue));
    }
}

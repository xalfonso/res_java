package eas.com;

import org.junit.jupiter.api.Test;

public class Temporary {

    @Test
    public void test(){
        System.out.println("Is Assinable Class1 from Interfaz2 " + Interfaz2.class.isAssignableFrom(Class2.class));
    }
}

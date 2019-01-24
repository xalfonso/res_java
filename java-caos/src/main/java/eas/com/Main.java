package eas.com;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String a = new String("Wilmer");
        String b = new String("Wilmer");
        if (Objects.equals(a, b)) System.out.println("true");
        else System.out.println("false");
    }
}

package org.example;

public class App {

    public static void main(String[] args) {

        String logIn = "lepeniy783@elastit.com";
        String password = "lepeniy783";

        new EditProfile().edit(logIn, password);
        new Purchase().purchase(logIn, password);
    }
}

package org.example;

public class Main {
    public static void main(String[] args) {
        String l="lepeniy783@elastit.com";
        String p="lepeniy783";

        new EditProfile().edit(l, p);

        new Purchase().purchase(l, p);
    }
}

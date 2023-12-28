package com.example;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list.toString((String value) -> value));
    }
}

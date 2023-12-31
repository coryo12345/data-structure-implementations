package com.example;

import java.util.ArrayList;
import java.util.Optional;

import com.example.common.FormatterFunction;

interface IStack<T> {
    public void push(T value);

    public Optional<T> pop();

    public Optional<T> peek();

    public int size();

    public String toString(FormatterFunction<T> formatter);
}

public class Stack<T> implements IStack<T> {
    private ArrayList<T> values;

    public Stack() {
        this.values = new ArrayList<>();
    }

    public Stack(T[] arr) {
        this();
        for (T t : arr) {
            this.values.add(t);
        }
    }

    public void push(T value) {
        this.values.add(value);
    }

    public Optional<T> pop() {
        if (this.values.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(this.values.remove(this.values.size() - 1));
        }
    }

    public Optional<T> peek() {
        if (this.values.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(this.values.get(this.values.size() - 1));
        }
    }

    public int size() {
        return this.values.size();
    }

    public String toString(FormatterFunction<T> formatter) {
        ArrayList<String> elems = new ArrayList<>();
        for (T t : this.values) {
            elems.add(formatter.apply(t));
        }
        return "[" + String.join(",", elems) + "]";
    }
}

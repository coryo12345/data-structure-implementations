package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.common.FormatterFunction;

interface IQueue<T> {
    public void add(T value);

    public Optional<T> remove();

    public Optional<T> peek();

    public int size();

    public String toString(FormatterFunction<T> formatter);
}

public class Queue<T> implements IQueue<T> {
    private ArrayList<T> values;

    public Queue() {
        this.values = new ArrayList<>();
    }

    public Queue(T[] arr) {
        this();
        for (int i = 0; i < arr.length; i++) {
            this.add(arr[i]);
        }
    }

    public Queue(List<T> values) {
        this.values = new ArrayList<>(values);
    }

    public void add(T value) {
        this.values.add(value);
    }

    public Optional<T> remove() {
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

    @Override
    public String toString(FormatterFunction<T> formatter) {
        ArrayList<String> elems = new ArrayList<>();
        for (T t : this.values) {
            elems.add(formatter.apply(t));
        }
        return "[" + String.join(",", elems) + "]";
    }

}

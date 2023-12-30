package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.common.FormatterFunction;

interface CustomList<T> {
    public Optional<T> get(int index);

    public void add(T value);

    public Optional<T> remove(int index);

    public int size();

    public String toString(FormatterFunction<T> formatter);
}

public class LinkedList<T> implements CustomList<T> {
    private int length;
    private Optional<LinkedListNode<T>> head;

    public LinkedList() {
        this.length = 0;
        this.head = Optional.empty();
    }

    public LinkedList(T[] array) {
        this();
        for (T elem : array) {
            this.add(elem);
        }
    }

    public LinkedList(List<T> list) {
        this();
        for (T value : list) {
            this.add(value);
        }
    }

    public Optional<T> get(int index) {
        int pos = 0;
        Optional<LinkedListNode<T>> node = this.head;
        while (node.isPresent() && pos < index) {
            node = node.get().next;
            pos++;
        }
        if (node.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(node.get().value);
    }

    public void add(T value) {
        LinkedListNode<T> newNode = new LinkedListNode<>();
        newNode.value = value;
        newNode.next = Optional.empty();

        if (this.head.isEmpty()) {
            this.head = Optional.of(newNode);
        } else {
            Optional<LinkedListNode<T>> lastNode = this.head;
            while (lastNode.isPresent()) {
                if (lastNode.get().next.isEmpty()) {
                    break;
                } else {
                    lastNode = lastNode.get().next;
                }
            }
            lastNode.get().next = Optional.of(newNode);
        }
        this.length++;
    }

    public Optional<T> remove(int index) {
        Optional<LinkedListNode<T>> prevNode = Optional.empty();
        Optional<LinkedListNode<T>> node = this.head;
        Optional<T> valueToReturn;

        for (int pos = 1; pos <= index; pos++) {
            if (node.isEmpty() || (node.get().next.isEmpty() && pos == index)) {
                return Optional.empty();
            }
            prevNode = node;
            node = node.get().next;
        }

        valueToReturn = Optional.of(node.get().value);

        if (prevNode.isEmpty()) {
            this.head = node.get().next;
        } else {
            prevNode.get().next = node.get().next;
        }
        this.length--;

        return valueToReturn;
    }

    public int size() {
        return this.length;
    }

    @Override
    public String toString(FormatterFunction<T> formatter) {
        ArrayList<String> elems = new ArrayList<>();
        Optional<LinkedListNode<T>> lastNode = this.head;
        while (lastNode.isPresent()) {
            elems.add(formatter.apply(lastNode.get().value));
            lastNode = lastNode.get().next;
        }
        return "[" + String.join(",", elems) + "]";
    }
}

class LinkedListNode<T> {
    T value;
    Optional<LinkedListNode<T>> next;
}
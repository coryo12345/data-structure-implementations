package com.example;

import java.util.List;
import java.util.Optional;

@FunctionalInterface
interface Function {
    void apply();
}

interface CustomList<T> {
    public Optional<T> get(int index);

    public void add(T value);

    public Optional<T> remove(int index);

    public int size();

    public String toString(Function formatter);
}

public class LinkedList<T> implements CustomList<T> {
    private int length;
    private Optional<LinkedListNode<T>> head;

    public LinkedList() {
        this.length = 0;
        this.head = null;
    }

    public LinkedList(T[] array) {
        this();
        // TODO
    }

    public LinkedList(List<T> list) {
        this();
        // TODO
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
        return;
    }

    public Optional<T> remove(int index) {
        Optional<LinkedListNode<T>> prevNode = Optional.empty();
        Optional<LinkedListNode<T>> node = this.head;
        Optional<T> valueToReturn = Optional.empty();

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

    public String toString(Function formatter) {
        return "";
    }
}

class LinkedListNode<T> {
    T value;
    Optional<LinkedListNode<T>> next;
}
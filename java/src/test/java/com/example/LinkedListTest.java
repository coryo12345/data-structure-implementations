package com.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class LinkedListTest extends TestCase {
    public LinkedListTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(LinkedListTest.class);
    }

    private final Struct[] values = {
            new Struct(2),
            new Struct(4),
            new Struct(6),
            new Struct(8),
            new Struct(10),
    };

    public void testListAdd() {
        LinkedList<Struct> list = new LinkedList<>();

        for (int i = 0; i < values.length; i++) {
            Struct val = values[i];
            list.add(val);

            assertEquals(list.size(), i + 1);
        }

        for (int i = 0; i < values.length; i++) {
            Struct val = values[i];
            Struct v = list.get(i).get();
            assertEquals(val.val, v.val);
        }
    }

    public void testListGetFromArray() {
        LinkedList<Struct> list = new LinkedList<>(values);

        for (int i = 0; i < values.length; i++) {
            Struct val = values[i];
            Struct v = list.get(i).get();
            assertEquals(val.val, v.val);
        }
    }

    public void testListRemoveElement() {
        LinkedList<Struct> list = new LinkedList<>(values);

        Struct last = list.remove(4).get();
        assertEquals(last.val, 10);
        assertEquals(list.size(), 4);

        Struct middle = list.remove(2).get();
        assertEquals(middle.val, 6);
        assertEquals(list.size(), 3);

        Struct first = list.remove(0).get();
        assertEquals(first.val, 2);
        assertEquals(list.size(), 2);
    }

    public void testListToString() {
        LinkedList<Struct> list = new LinkedList<>(values);
        String str = list.toString((Struct s) -> String.valueOf(s.val));
        String expected = "[2,4,6,8,10]";
        assertEquals(str, expected);
    }
}

class Struct {
    public int val;

    public Struct(int value) {
        this.val = value;
    }
}
package com.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class QueueTest extends TestCase {
    public QueueTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(QueueTest.class);
    }

    private final Struct[] values = {
            new Struct(2),
            new Struct(4),
            new Struct(6),
            new Struct(8),
            new Struct(10),
    };

    public void testQueueAdd() {
        Queue<Struct> queue = new Queue<>();

        for (int i = 0; i < values.length; i++) {
            Struct val = values[i];
            queue.add(val);

            assertEquals(queue.size(), i + 1);
        }

        for (int i = 0; i < values.length; i++) {
            Struct val = values[i];
            Struct v = queue.remove().get();
            assertEquals(val.val, v.val);
        }
        assertEquals(queue.remove().isEmpty(), true);
    }

    public void testGetFromArray() {
        Queue<Struct> queue = new Queue<>(values);

        for (int i = 0; i < values.length; i++) {
            Struct val = values[i];
            Struct v = queue.remove().get();
            assertEquals(val.val, v.val);
        }
        assertEquals(queue.remove().isEmpty(), true);
    }

    public void testPeekElement() {
        Queue<Struct> queue = new Queue<>(values);
        for (int i = 0; i < values.length; i++) {
            Struct val = values[i];
            Struct v = queue.peek().get();
            assertEquals(val.val, v.val);
            queue.remove();
        }
        assertEquals(queue.remove().isEmpty(), true);
    }

    public void testListToString() {
        Queue<Struct> queue = new Queue<>(values);

        String str = queue.toString((Struct s) -> String.valueOf(s.val));
        assertEquals(str, "[2,4,6,8,10]");

        str = queue.toString((Struct s) -> String.valueOf(s.val) + "0");
        assertEquals(str, "[20,40,60,80,100]");
    }
}

class Struct {
    public int val;

    public Struct(int value) {
        this.val = value;
    }
}
package com.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class StackTest extends TestCase {
    public StackTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(StackTest.class);
    }

    private final Struct[] values = {
            new Struct(2),
            new Struct(4),
            new Struct(6),
            new Struct(8),
            new Struct(10),
    };

    public void testStackAdd() {
        Stack<Struct> stack = new Stack<>();

        for (int i = 0; i < values.length; i++) {
            Struct val = values[i];
            stack.push(val);

            assertEquals(stack.size(), i + 1);
        }

        for (int i = values.length-1; i >= 0; i--) {
            Struct val = values[i];
            Struct v = stack.pop().get();
            assertEquals(val.val, v.val);
        }
        assertEquals(stack.pop().isEmpty(), true);
    }

    public void testGetFromArray() {
        Stack<Struct> stack = new Stack<>(values);

        for (int i = values.length-1; i >= 0; i--) {
            Struct val = values[i];
            Struct v = stack.pop().get();
            assertEquals(val.val, v.val);
        }
        assertEquals(stack.pop().isEmpty(), true);
    }

    public void testPeekElement() {
        Stack<Struct> stack = new Stack<>(values);
        for (int i = values.length-1; i >= 0; i--) {
            Struct val = values[i];
            Struct v = stack.peek().get();
            assertEquals(val.val, v.val);
            stack.pop();
        }
        assertEquals(stack.pop().isEmpty(), true);
    }

    public void testStackToString() {
        Stack<Struct> stack = new Stack<>(values);

        String str = stack.toString((Struct s) -> String.valueOf(s.val));
        assertEquals(str, "[2,4,6,8,10]");

        str = stack.toString((Struct s) -> String.valueOf(s.val) + "0");
        assertEquals(str, "[20,40,60,80,100]");
    }
}

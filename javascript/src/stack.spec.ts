import { describe, expect, it } from "bun:test";
import { Stack } from "./stack";

const values: number[] = [5, 10, 15, 20, 25];

describe("Stack", () => {
  it("adds and retrieves items", () => {
    const stack = new Stack<number>();
    stack.push(values[0]);
    expect(stack.pop()).toBe(values[0]);

    stack.push(values[1]);
    stack.push(values[2]);
    expect(stack.pop()).toBe(values[2]);
  });

  it("can initialize from an array and remove items", () => {
    const stack = new Stack(values);
    [...values].reverse().forEach((val) => {
      expect(stack.pop()).toEqual(val);
    });
    expect(stack.pop()).toBe(undefined as any);
  });

  it("can peek the last item", () => {
    const stack = new Stack<number>();
    values.forEach((val, idx) => {
      stack.push(val);
      expect(stack.peek()).toBe(val);
      expect(stack.size()).toBe(idx + 1);
    });
  });

  it("formats to a string using provided formatter", () => {
    const stack = new Stack(values);
    expect(stack.toString((val) => val.toString())).toBe("[5,10,15,20,25]");
    expect(stack.toString((val) => val.toString() + "0")).toBe(
      "[50,100,150,200,250]"
    );
  });
});

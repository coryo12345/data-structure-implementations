import { describe, expect, it } from "bun:test";
import { Queue } from "./queue";

const values: number[] = [5, 10, 15, 20, 25];

describe("Queue", () => {
  it("adds and retrieves items", () => {
    const queue = new Queue<number>();
    queue.add(values[0]);
    expect(queue.remove()).toBe(values[0]);

    queue.add(values[1]);
    queue.add(values[2]);
    expect(queue.remove()).toBe(values[1]);
    expect(queue.remove()).toBe(values[2]);
  });

  it("can initialize from an array and remove items", () => {
    const queue = new Queue(values);
    values.forEach((val) => {
      expect(queue.remove()).toEqual(val);
    });
    expect(queue.remove()).toBe(undefined as any);
  });

  it("can peek the next item", () => {
    const queue = new Queue<number>();
    values.forEach((val, idx) => {
      queue.add(val);
      expect(queue.peek()).toBe(values[0]);
      expect(queue.size()).toBe(idx + 1);
    });
  });

  it("formats to a string using provided formatter", () => {
    const queue = new Queue(values);
    expect(queue.toString((val) => val.toString())).toBe("[5,10,15,20,25]");
    expect(queue.toString((val) => val.toString() + "0")).toBe(
      "[50,100,150,200,250]"
    );
  });
});

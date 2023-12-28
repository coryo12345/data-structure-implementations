import { describe, expect, it } from "bun:test";
import { LinkedList } from "./linkedlist";

type TestObj = { val: number };
const values: TestObj[] = [
  { val: 2 },
  { val: 4 },
  { val: 6 },
  { val: 8 },
  { val: 10 },
];

describe("Linked List", () => {
  it("can add and retrieve values with add/get methods", () => {
    const list = new LinkedList<TestObj>();

    values.forEach((value, idx) => {
      list.add(value);
      expect(list.size()).toBe(idx + 1);
    });

    values.forEach((value, idx) => {
      const v = list.get(idx);
      expect(v).not.toBeNull();
      expect(v?.val).toBe(value.val);
    });
  });

  it("can retrieve values from list constructed from an array", () => {
    const list = new LinkedList<TestObj>(values);

    values.forEach((value, idx) => {
      expect(list.get(idx)?.val).toBe(value.val);
    });
  });

  it("can remove elements from list", () => {
    const list = new LinkedList<TestObj>(values);

    const last = list.remove(4);
    expect(last?.val).toBe(10);
    expect(list.size()).toBe(4);

    const middle = list.remove(2);
    expect(middle?.val).toBe(6);
    expect(list.size()).toBe(3);

    const first = list.remove(0);
    expect(first?.val).toBe(2);
    expect(list.size()).toBe(2);
  });

  it("can convert list to string based on provided formatter", () => {
    const list = new LinkedList<TestObj>(values);
    const str = list.toString((val) => val.val.toString());
    expect(str).toEqual("[2,4,6,8,10]");
  });
});

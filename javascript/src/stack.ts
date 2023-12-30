interface IStack<T> {
  push(value: T): void;
  pop(): T | undefined;
  peek(): T | undefined;
  size(): number;
  toString(formatter: (value: T) => string): string;
}

// JS is pretty easy since arrays have built in stack methods
export class Stack<T> implements IStack<T> {
  private values: T[];

  constructor(arr?: T[]) {
    if (arr) {
      this.values = [...arr];
    } else {
      this.values = [];
    }
  }

  push(value: T): void {
    this.values.push(value);
  }

  pop(): T | undefined {
    return this.values.pop();
  }

  peek(): T | undefined {
    return this.values.at(this.values.length - 1);
  }

  size(): number {
    return this.values.length;
  }

  toString(formatter: (value: T) => string): string {
    return "[" + this.values.map((v) => formatter(v)).join(",") + "]";
  }
}

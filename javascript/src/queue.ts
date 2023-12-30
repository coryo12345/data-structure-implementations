interface IQueue<T> {
  add(value: T): void;
  remove(): T | undefined;
  peek(): T | undefined;
  size(): number;
  toString(formatter: (value: T) => string): string;
}

export class Queue<T> implements IQueue<T> {
  private values: T[];

  constructor(arr?: T[]) {
    if (arr) {
      this.values = arr;
    } else {
      this.values = [];
    }
  }

  add(value: T): void {
    this.values.unshift(value);
  }

  remove(): T | undefined {
    return this.values.shift();
  }

  peek(): T | undefined {
    return this.values.at(0);
  }

  size(): number {
    return this.values.length;
  }

  toString(formatter: (value: T) => string): string {
    return "[" + this.values.map((v) => formatter(v)).join(",") + "]";
  }
}

interface List<T> {
  get(index: number): T | null;
  add(value: T): void;
  remove(index: number): T | null;
  size(): number;
  toString(formatter: (value: T) => string): string;
}

export class LinkedList<T> implements List<T> {
  private length: number;
  private head: ListNode<T> | null;

  constructor(array?: T[]) {
    this.length = 0;
    this.head = null;

    !!array &&
      array.forEach((element) => {
        this.add(element);
      });
  }

  get(index: number): T | null {
    let pos = 0;
    let node = this.head;
    while (node !== null && pos < index) {
      node = node.next;
      pos++;
    }
    if (node === null) {
      throw new Error(
        `index-out-of-bounds accessing index ${index} from linked list`
      );
    }
    return node.value;
  }

  add(value: T) {
    const newNode = new ListNode<T>(value);
    if (this.head === null) {
      this.head = newNode;
    } else {
      let lastNode = this.head;
      while (lastNode != null) {
        if (lastNode.next === null) {
          break;
        } else {
          lastNode = lastNode.next;
        }
      }
      lastNode.next = newNode;
    }
    this.length++;
  }

  remove(index: number): T | null {
    const err = () => {
      throw new Error(
        `index-out-of-bounds: attempted to remove item from linked list at index ${index}`
      );
    };
    let prevNode: ListNode<T> | null = null;
    let node: ListNode<T> | null = this.head;
    let valueToReturn: T | null = null;

    for (let pos = 1; pos <= index; pos++) {
      if (node === null || (node.next === null && pos === index)) {
        return err();
      }
      prevNode = node;
      node = node.next;
    }

    if (node === null) {
      return err();
    }

    valueToReturn = node.value;

    if (prevNode === null) {
      this.head = node.next;
    } else {
      prevNode.next = node.next;
    }
    this.length--;

    return valueToReturn;
  }

  size(): number {
    return this.length;
  }

  toString(formatter: (value: T) => string): string {
    const elements: string[] = [];
    let node = this.head;
    while (node !== null) {
      elements.push(formatter(node.value));
      node = node.next;
    }
    return "[" + elements.join(",") + "]";
  }
}

class ListNode<T> {
  value: T;
  next: ListNode<T> | null;

  constructor(value: T, next?: ListNode<T>) {
    this.value = value;
    this.next = next ?? null;
  }
}

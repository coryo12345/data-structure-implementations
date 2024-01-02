# LinkedList Implementations

Implementing Linked Lists in a different languages.

## TODO

- rewrite go linkedlist to return errors instead of panic
- go stack
- go queue
- python stack
- python queue
- update readme to be data structure agnostic
- update readme with a table to show languages & data structures

## Languages

### Currently Implemented

- Go
- JavaScript
- Python
- Java

### To Implement

- C
- Rust
- C++
- PHP

## Requirements

1. All list objects must (loosely) conform to the following interface:  
   Loosely meaning that minor changes can be made based on language requirements (i.e. returning pointers, wrappers, etc...)

```ts
interface List<T> {
  get(index: int): T;
  add(value: T): void;
  remove(index: int): T;
  size(): int;
  toString(formatter: (value: T) => string): string; // in the form ['a','b',1,2]
}
```

2. All implementations must have 2 methods to construct the list

   1. Empty constructor, that creates an empty linked list of size 0
   2. Construct from an array (or slice), that creates a linked list with the same length and values as the provided array

3. All implementations must have (& pass!) the following test cases
   - Test add / get methods (with empty constructors). Must be able to access the first, last, and an element in the middle of the list.
   - Test get method with the array constructor. Must be able to access the first, last, and an element in the middle of the list.
   - Test the remove method. Create a linked list with N elements. Remove the first element, the last element, and an element in the middle. After each removal, the size should decrease by 1 and the values retrieved by get should change accordingly
   - Test the toString method. Ensure it properly creates a string representation of the list

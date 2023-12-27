use std::borrow::Borrow;

fn main() {
    let ll: LinkedList<char> = LinkedList::new();

    println!("{}", ll.size());
    println!("{}", ll.to_string(|value| value.to_string()));
}

pub trait List<T> {
    fn get(&self, index: i32) -> &T;
    fn add(&mut self, value: T);
    fn remove(&mut self, index: i32) -> &T;
    fn size(&self) -> i32;
    fn to_string(&self, formatter: fn(value: T) -> String) -> String;
}

pub struct LinkedList<T> {
    length: i32,
    head: Option<Box<LinkedListNode<T>>>,
}

struct LinkedListNode<T> {
    value: Box<T>,
    next: Option<Box<LinkedListNode<T>>>,
}

impl<T> LinkedList<T> {
    pub fn new() -> Self {
        LinkedList {
            length: 0,
            head: None,
        }
    }

    // new from array
}

impl<T> List<T> for LinkedList<T> {
    fn get(&self, index: i32) -> &T {
        self.head.as_ref().unwrap().value.borrow()
    }

    fn add(&mut self, value: T) {}

    fn remove(&mut self, index: i32) -> &T {
        self.head.as_ref().unwrap().value.borrow()
    }

    fn size(&self) -> i32 {
        self.length
    }

    fn to_string(&self, formatter: fn(value: T) -> String) -> String {
        "".to_string()
    }
}

package main

import (
	"fmt"
	"strings"
)

func main() {
	values := []int{2, 4, 6, 8}
	list := NewLinkedListFromArray[int](values)

	println(list.Size())
	println(list.ToString(func(val *int) string {
		return fmt.Sprintf("%d", *val)
	}))

	println(*list.Get(0))
	println(*list.Get(1))
	println(*list.Get(2))
	println(*list.Get(3))

	list.Remove(2)
	println(list.ToString(func(val *int) string {
		return fmt.Sprintf("%d", *val)
	}))
}

type List[T any] interface {
	Get(index int) *T
	Add(value *T)
	Remove(index int) *T
	Size() int
	ToString(formatter func(value *T) string) string
}

func NewLinkedList[T any]() List[T] {
	return &LinkedList[T]{
		length: 0,
		head:   nil,
	}
}

func NewLinkedListFromArray[T any](elements []T) List[T] {
	list := LinkedList[T]{
		length: 0,
		head:   nil,
	}

	for _, elem := range elements {
		e := elem
		list.Add(&e)
	}

	return &list
}

type LinkedList[T any] struct {
	length int
	head   *listNode[T]
}

type listNode[T any] struct {
	value *T
	next  *listNode[T]
}

func (l *LinkedList[T]) Get(index int) *T {
	pos := 0
	node := l.head
	for node != nil && pos < index {
		node = node.next
		pos++
	}
	if node == nil {
		panic(fmt.Sprintf("Index-out-of-bounds accessing index %d from linked list", index))
	}
	return node.value
}

func (l *LinkedList[T]) Add(value *T) {
	newNode := listNode[T]{
		value: value,
		next:  nil,
	}
	if l.head == nil {
		l.head = &newNode
	} else {
		lastNode := l.head
		for lastNode != nil {
			if lastNode.next == nil {
				break
			} else {
				lastNode = lastNode.next
			}
		}
		lastNode.next = &newNode
	}
	l.length++
}

func (l *LinkedList[T]) Remove(index int) *T {
	var prevNode *listNode[T] = nil
	var node *listNode[T] = l.head
	var valueToReturn *T = nil

	for pos := 1; pos <= index; pos++ {
		if node == nil || (node.next == nil && pos == index) {
			panic("index-out-of-bounds: attempted to remove item from linked list")
		}
		prevNode = node
		node = node.next
	}

	valueToReturn = node.value

	if prevNode == nil {
		l.head = node.next
	} else {
		prevNode.next = node.next
	}
	l.length--

	return valueToReturn
}

func (l *LinkedList[T]) Size() int {
	return l.length
}

func (l *LinkedList[T]) ToString(formatter func(value *T) string) string {
	elems := []string{}
	lastNode := l.head
	for lastNode != nil {
		elems = append(elems, formatter(lastNode.value))
		lastNode = lastNode.next
	}
	s := "[" + strings.Join(elems, ",") + "]"
	return s
}

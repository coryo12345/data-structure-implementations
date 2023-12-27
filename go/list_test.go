package main

import (
	"fmt"
	"testing"
)

var values = []TestStruct{
	{val: 2},
	{val: 4},
	{val: 6},
	{val: 8},
	{val: 10},
}

func TestListAdd(t *testing.T) {
	list := NewLinkedList[TestStruct]()

	for idx, val := range values {
		v := val
		list.Add(&v)

		if list.Size() != idx+1 {
			t.Error("list has incorrect size after addition")
		}
	}

	for idx, val := range values {
		v := list.Get(idx)
		if v.val != val.val {
			t.Error("list has inccorect element position")
		}
	}

}

func TestListGetFromArray(t *testing.T) {
	list := NewLinkedListFromArray[TestStruct](values)

	for idx, val := range values {
		v := list.Get(idx)
		if v.val != val.val {
			t.Error("list has inccorect element position")
		}
	}
}

func TestListRemoveElement(t *testing.T) {
	list := NewLinkedListFromArray[TestStruct](values)

	last := list.Remove(4)
	if last.val != 10 || list.Size() != 4 {
		t.Errorf("failed to remove last element from list. Expected value %d but got value %d. Expected size %d but got %d", 10, last.val, 4, list.Size())
	}

	middle := list.Remove(2)
	if middle.val != 6 || list.Size() != 3 {
		t.Errorf("failed to remove last element from list. Expected value %d but got value %d. Expected size %d but got %d", 6, middle.val, 3, list.Size())
	}

	first := list.Remove(0)
	if first.val != 2 || list.Size() != 2 {
		t.Errorf("failed to remove last element from list. Expected value %d but got value %d. Expected size %d but got %d", 2, first.val, 2, list.Size())
	}
}

func TestListToString(t *testing.T) {
	list := NewLinkedListFromArray[TestStruct](values)
	str := list.ToString(func(t *TestStruct) string {
		return fmt.Sprintf("%d", t.val)
	})
	expected := "[2,4,6,8,10]"
	if str != expected {
		t.Errorf("ToString returned '%s'  expected: '%s'", str, expected)
	}
}

type TestStruct struct {
	val int
}

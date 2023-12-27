
def main():
    values = [2,4,6,8,10]
    linkedlist = LinkedList(values)
    print(linkedlist.to_string(lambda x: str(x)))
    linkedlist.add(123)
    print(linkedlist.to_string(lambda x: str(x)))
    print('index 0', linkedlist.get(0))
    print('index 5', linkedlist.get(5))
    linkedlist.remove(5)
    linkedlist.remove(0)
    print(linkedlist.size(), linkedlist.to_string(lambda x: str(x)))


class LinkedList:
    def __init__(self, array=None):
        self.length = 0
        self.head = None

        if array != None:
            for value in array:
                self.add(value)

    
    def get(self, index):
        pos = 0
        node = self.head
        while node != None and pos < index:
            node = node.next
            pos+=1
        if node == None:
            raise IndexError("attempted to access index that does not exist")
        return node.value


    def add(self, value):
        new_node = LinkedListNode(value)
        if self.head == None:
            self.head = new_node
        else:
            last_node = self.head
            while last_node != None:
                if last_node.next == None:
                    break
                else:
                    last_node = last_node.next
            last_node.next = new_node
        self.length+=1


    def remove(self, index):
        prev_node = None
        node = self.head
        value_to_return = None

        for pos in range(1, index+1, 1):
            if node == None or (node.next == None and pos == index):
                raise IndexError('attempted to remove item from linked list at invalid index')
            prev_node = node
            node = node.next
        
        value_to_return = node.value

        if prev_node == None:
            self.head = node.next
        else:
            prev_node.next = node.next
        self.length-=1

        return value_to_return


    def size(self):
        return self.length


    def to_string(self, formatter):
        elems = []
        last_node = self.head
        while last_node != None:
            elems.append(formatter(last_node.value))
            last_node = last_node.next
        return '[' + ','.join(elems) + ']'
    

class LinkedListNode:
    def __init__(self, value):
        self.value = value
        self.next = None


if __name__ == '__main__':
    main()

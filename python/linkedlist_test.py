import unittest
from linkedlist import LinkedList

values = [
    {'val': 2},
    {'val': 4},
    {'val': 6},
    {'val': 8},
    {'val': 10},
]

class TestLinkedList(unittest.TestCase):
    def test_list_add(self):
        global values
        linkedlist = LinkedList()

        for i, v in enumerate(values):
            linkedlist.add(v)
            self.assertEqual(linkedlist.size(), i+1)
        
        for i, v in enumerate(values):
            val = linkedlist.get(i)
            self.assertEqual(val['val'], v['val'])


    def test_list_get_from_array(self):
        global values
        linkedlist = LinkedList(values)

        for idx, val in enumerate(values):
            v = linkedlist.get(idx)
            self.assertEqual(v['val'], val['val'])


    def test_list_remove_element(self):
        global values
        linkedlist = LinkedList(values)

        last = linkedlist.remove(4)
        self.assertEqual(last['val'], 10)
        self.assertEqual(linkedlist.size(), 4)

        middle = linkedlist.remove(2)
        self.assertEqual(middle['val'], 6)
        self.assertEqual(linkedlist.size(), 3)

        first = linkedlist.remove(0)
        self.assertEqual(first['val'], 2)
        self.assertEqual(linkedlist.size(), 2)


    def test_list_to_string(self):
        global values
        linkedlist = LinkedList(values)
        s = linkedlist.to_string(lambda x: str(x['val']))
        self.assertEqual(s, '[2,4,6,8,10]')


if __name__ == '__main__':
    unittest.main()

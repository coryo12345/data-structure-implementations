import unittest
from queue_list import Queue

values = [
    {'val': 2},
    {'val': 4},
    {'val': 6},
    {'val': 8},
    {'val': 10},
]

class TestQueue(unittest.TestCase):
    def test_queue_add(self):
        global values
        queue = Queue()

        for i, v in enumerate(values):
            queue.add(v)
            self.assertEqual(queue.size(), i+1)
        
        for i, val in enumerate(values):
            v = queue.remove()
            self.assertEqual(val['val'], v['val'])


    def test_get_from_array(self):
        global values
        queue = Queue(values)

        for i, val in enumerate(values):
            v = queue.remove()
            self.assertEqual(val['val'], v['val'])


    def test_peek_element(self):
        global values
        queue = Queue(values)

        for i, val in enumerate(values):
            v = queue.peek()
            self.assertEqual(val['val'], v['val'])
            queue.remove()
        self.assertEqual(queue.remove(), None)


    def test_to_string(self):
        global values
        queue = Queue(values)
        s = queue.to_string(lambda x: str(x['val']))
        self.assertEqual(s, '[2,4,6,8,10]')


if __name__ == '__main__':
    unittest.main()

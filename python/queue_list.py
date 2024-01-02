
class Queue:
    def __init__(self, array=None):
        if array != None:
            arr = [x for x in array]
            arr.reverse()
            self.values = arr
        else:
            self.values = []


    def add(self, value):
        self.values.insert(0, value)


    def remove(self):
        try:
            return self.values.pop()
        except IndexError:
            return None


    def peek(self):
        return None if len(self.values) == 0 else self.values[-1]


    def size(self):
        return len(self.values)


    def to_string(self, formatter):
        elems = []
        for val in reversed(self.values):
            elems.append(formatter(val))
        return '[' + ','.join(elems) + ']'

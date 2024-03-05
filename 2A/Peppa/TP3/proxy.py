class Proxy:
    def __init__(self, obj, forbidden_methods):
        self._obj = obj
        self._forbidden_methods = forbidden_methods
    
    def __getattr__(self, name):
        if name in self._forbidden_methods:
            raise AttributeError(f'Forbidden method: {name}')
        return getattr(self._obj, name)

    def __repr__(self):
        return repr(self._obj)

class List:
    def __init__(self):
        self._list = []
    
    def append(self, value):
        self._list.append(value)
    
    def remove(self, value):
        self._list.remove(value)

    def __repr__(self):
        return repr(self._list)

list = List()
list.append(1)
print(list)
list = Proxy(list, ['append', 'remove'])
try:
    list.append(2)
except AttributeError as e:
    print(e)
finally:
    print(list)
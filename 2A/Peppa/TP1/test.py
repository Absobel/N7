
class Test:
    __x = 0

    def __init__(self, x):
        self.__x = x

t = Test(10)
print(t._Test__x)
t._Test__x = 20
print(t._Test__x)
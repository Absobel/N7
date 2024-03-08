import functools

_level = 0  # nombre d'appels imbriqués
_TABSIZE = 4
_CALL = '--> '
_BACK = '<-- '
_EXCEPTION = '<-/\\/- '

def trace(f=None,*,tabsize=_TABSIZE,call=_CALL,back=_BACK,exception=_EXCEPTION):
    @functools.wraps(f)	# Copier les informations f dans local_trace
    def local_trace(*p, **k):
        global _level
        try:
            indentation = ' ' * _level * tabsize
            _level += 1
            positionnels = [repr(pp) for pp in p]
            nommes = ['{}={}'.format(c, repr(v)) for c, v in k.items()]
            if call is not None:
                print(indentation + call + '{name}({args})'.format(name=f.__qualname__,
                    args=', '.join(positionnels + nommes)))
            r = f(*p, **k)
        except BaseException as e:
            if exception is not None:
                print(indentation + exception + type(e).__name__ + ' : ' + str(e))
            raise
        else:
            if back is not None:
                print(indentation + back + repr(r))
        finally:
            _level -= 1
        return r
    if f is None:   # called with args
        def decorator(f):   # decorator function to return to Python interpreteur
            assert callable(f)
            return trace(f, tabsize=tabsize, call=call, back=back, exception=exception)
        return decorator
    else:
        assert callable(f)
        return local_trace

if __name__ == '__main__':

    @trace
    def fact(n):
        if n <= 1:
            return 1
        else:
            return n * fact(n - 1)

    print(fact(6))
    print(fact.__qualname__)
    # help(fact)	# Help on function fact in module __main__:

    @trace(exception="<-/\\/\\-")
    def f_erreur(x):
        print("dans f, x = " + str(x))
        if x < 0:
            raise ValueError("x == " + repr(x))

    @trace
    def f_nop(g, *args, **kwargs):
        g(*args, **kwargs)

    @trace
    def f(x, *, a):
        print('f: x vaut {} et a {}'.format(x, a))

    @trace
    def f2(p, q):
        print('f2: p vaut {} et q {}'.format(p, q))
        f(p, a=q)

    @trace(call='-->>-- ', back='--<<--')
    def g(a, b):
        try:
            print('dans g')
            f(0, a='XXX')
            print('après f()')
            b(1, a='AAA')
            f_nop(f_erreur, 3)
            f_nop(f_erreur, -5)
        except BaseException as e:
            print("Exception récupérée : " + type(e).__name__ + ' ' + str(e))

    f(10, a='A')
    f('x', a=10)
    f(a='x', x=10)
    g(421, f)


    f2(1, 'un')

    print("f_erreur.__name__ =", f_erreur.__name__)
    print("f_erreur.__qualname__ =", f_erreur.__qualname__)

    print("fact.__name__ =", fact.__name__)
    print("fact.__qualname__ =", fact.__qualname__)

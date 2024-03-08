import functools
import trace

def deprecated(f=None, /, *, replacement=None):
    '''
    Décorateur qui signale qu'une fonction est dépreciée.
    '''
    # print("deprecated:", f if f is None else f.__name__, replacement)
    if f is None:   # décorateur `deprecated` utilisé avec un paramètre
        def deprecated_with_param(f):
            return deprecated(f, replacement=replacement)
        return deprecated_with_param

    if replacement:
        advice = "  " f"Consider using: `{replacement}`."
    else:
        advice = ""
    print(f"Warning: `{f.__name__}` is deprecated.{advice}")

    return f

if __name__ == "__main__":

    @deprecated
    def f():
        return 1;

    @deprecated(replacement="the_new_function")
    def g():
        return 2

    def the_new_function():
        return 3

    assert f() == 1
    assert g() == 2
    assert the_new_function() == 3



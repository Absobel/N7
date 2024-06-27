import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class ProtectionHandler implements InvocationHandler {
    private Object obj;
    private List<String> forbiddenMethods;

    public ProtectionHandler(Object obj, List<String> forbiddenMethods) {
        this.obj = obj;
        this.forbiddenMethods = forbiddenMethods;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException, InvocationTargetException {
        if (forbiddenMethods.contains(method.getName())) {
            throw new RuntimeException();
        }
        return method.invoke(obj, args);
    }
}

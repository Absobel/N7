import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(List.of(2, 3, 5, 7));
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        
        List<String> forbiddenMethods = List.of("add", "addAll", "remove", "removeAll");
        Proxy proxy = (Proxy) Proxy.newProxyInstance(
                List.class.getClassLoader(),
                new Class<?>[]{List.class},
                new ProtectionHandler(list, forbiddenMethods)
        );
        List<Integer> protectedList = (List<Integer>) proxy;
        try {
            protectedList.add(11);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println(protectedList);


        // Same thing for map methods : "put" and "clear"
        System.out.println();
        Map<String, Integer> map = Map.of("one", 1, "two", 2);
        System.out.println(map);

        List<String> forbiddenMethodsMap = new ArrayList<String>();
        forbiddenMethodsMap.addAll(List.of("put", "clear"));
        Proxy proxyMap = (Proxy) Proxy.newProxyInstance(
                Map.class.getClassLoader(),
                new Class<?>[]{Map.class},
                new ProtectionHandler(map, forbiddenMethodsMap)
        );
        Map<String, Integer> protectedMap = (Map<String, Integer>) proxyMap;
        try {
            protectedMap.clear();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println(protectedMap);
    }
}
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LinkedLists {

    public static void main(String[] args) {

        LinkedList<Object> strings = new LinkedList<>();

        strings.add("a");
        strings.add("a");
        strings.add("b");
        strings.add("b");
        strings.add("c");
        strings.add("c");

        makeDistinct(strings);
        System.out.println(strings);

    }

    private static Object getElementFromTail(LinkedList<Object> objects, int index){
        return objects.get(objects.size() - 1 - index);
    }

    private static void makeDistinct(LinkedList<Object> objects) {
        List<Object> distinctList = objects
                .stream()
                .distinct()
                .collect(Collectors.toList());
        objects.clear();
        objects.addAll(distinctList);
    }
}

package Collections;

import java.util.*;

/**
 * Created by RXC8414 on 2/7/2017.
 */
public class CollectionUtils {

    public void linkList(){
        List<String> link = new LinkedList<>();

        link.add("One");
        link.add("Three");
        link.add("Two");
        link.add("Three");

        /*
        for(String value: link){
            System.out.println(value);
        }*/

        //Using lambdas as fluid calls
        link.forEach(value -> System.out.println(value));

    }

    public void treeSet(){
        Set<String> set = new TreeSet<>();

        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("1");
        set.add("Three");

        for(String value: set){
            System.out.println(value);
        }
    }

    public void treeMap(){
        Map<Integer, String> map = new TreeMap<>();

        map.put(1,"One");
        map.put(2,"Two");
        map.put(3,"Three");
        map.put(5,"Four");

        Set<Integer> keys = map.keySet();

        for(Integer key:keys)
        {
            System.out.println("Key : " + key + " Value : " + map.get(key));
        }
    }

    public void dequeStack(){
        Deque<String> stack = new ArrayDeque<>();

        stack.push("One");
        stack.push("Two");
        stack.push("Three");

        int size = stack.size();
        for(int i=0; i<size; i++){
            System.out.println(stack.pop());
        }
    }

    public void dequeQueue(){
        Deque<String> queue = new ArrayDeque<>();

        queue.add("One");
        queue.add("Two");
        queue.add("Three");

        int size = queue.size();
        for(int i=0; i<size; i++){
            System.out.println(queue.remove());
        }
    }

}

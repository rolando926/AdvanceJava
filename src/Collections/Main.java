package Collections;

import java.util.*;

/**
 * Created by RXC8414 on 2/7/2017.
 */
public class Main {
    static String[] arry = {"Jean Paul","Britanny","Tom",
            "Sandhya","Archana","Jay","Sravanthi",
            "Kinnari","Rolando","Kimberly"};
    static boolean blnSort = true;

    public static void main(String[] args) {
        CollectionUtils utils = new CollectionUtils();

        //utils.linkList();
        //utils.treeSet();
        //utils.treeMap();
        //utils.dequeStack();
        //utils.dequeQueue();
        //sortComparable();
        //sortComparator();
        sortStringArray();

    }

    public static void sortComparable(){
        Set<ComparableUtils> list = new TreeSet<>();

        list.add(new ComparableUtils("Leonardo DaVinci",10003,3.98));
        list.add(new ComparableUtils("Galileo Galilei",10001,3.90));
        list.add(new ComparableUtils("Albert Einstein",10000,3.99));
        list.add(new ComparableUtils("Isaac Newton",10002,4.00));


        for(ComparableUtils scientist:list){
            System.out.println(scientist);
        }
    }

    public static void sortComparator(){
        List<ComparatorUtils> list = new ArrayList<>();
        Comparator<ComparatorUtils> sortName = new ComparatorSortName();
        Comparator<ComparatorUtils> sortGPA = new ComparatorSortGPA();

        list.add(new ComparatorUtils("Leonardo DaVinci",10003,3.98));
        list.add(new ComparatorUtils("Galileo Galilei",10001,3.90));
        list.add(new ComparatorUtils("Albert Einstein",10000,3.99));
        list.add(new ComparatorUtils("Isaac Newton",10002,4.00));

        //Collections.sort(list,sortName);
        Collections.sort(list,sortGPA);
        for (ComparatorUtils value:list) {
            System.out.println(value);
        }

    }

    public static void sortStringArray(){
        SortUtils sort = new SortUtils();

        for (String element:sort.sort(arry)) {
            System.out.println(element);
        }
    }


}

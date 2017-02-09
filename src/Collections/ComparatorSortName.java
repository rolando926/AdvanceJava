package Collections;

import java.util.Comparator;

/**
 * Created by RXC8414 on 2/8/2017.
 */
public class ComparatorSortName implements Comparator<ComparatorUtils>{
    public int compare(ComparatorUtils name1, ComparatorUtils name2){
        int result = name1.getName().compareTo(name2.getName());
        if(result != 0){return result;}
        else{
            return 0;
        }
    }
}

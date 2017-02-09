package Collections;

import java.util.Comparator;

/**
 * Created by RXC8414 on 2/8/2017.
 */
public class ComparatorSortGPA implements Comparator<ComparatorUtils> {
    public int compare(ComparatorUtils gpa1, ComparatorUtils gpa2){
        if(gpa1.getGpa() < gpa2.getGpa()){return -1;}
        else if(gpa1.getGpa() > gpa2.getGpa()){return 1;}
        else {return 0;}
    }
}

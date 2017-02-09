package Collections;

/**
 * Created by RXC8414 on 2/9/2017.
 */
public class SortUtils {
    int counter = 1;

    public String[] sort(String[] arry){
        int size = arry.length;
        while(counter > 0) {
            counter=0;
            for (int i = 0; i < size - 1; i++) {arry = compareAndFlip(i,arry);}
        }
        return arry;
    }

    public String[] compareAndFlip(int position, String[] arry){
        String temp1 = arry[position];
        String temp2 = arry[position+1];
        if(compare(temp1,temp2) > 0){
            arry[position] = temp2;
            arry[position+1] = temp1;
            counter++;
        }
        return arry;
    }

    public int compare(String value1, String value2){
        int size = value1.length();
        int size2 = value2.length();
        if(size > size2){size = size2;}
        for(int i = 0; i < size; i++ ){
            int ascii1 = (int)value1.charAt(i);
            int ascii2 = (int)value2.charAt(i);
            if(ascii1 > ascii2){return 1;}
            else if(ascii1 < ascii2){return -1;}
            else {continue;}
        }
        return 0;
    }
}

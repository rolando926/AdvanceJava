package Collections;

/**
 * Created by RXC8414 on 2/7/2017.
 */
public class ComparableUtils implements Comparable<ComparableUtils> {

    private String name;
    private int id=0;
    private double gpa=0.0;

    ComparableUtils(String name, int id, double gpa){
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getGpa() {
        return gpa;
    }

    public String toString(){
        String result = "Name: "+this.name+" ID:"+this.id+" GPA:"+this.gpa;
        return result;
    }

    public int compareTo(ComparableUtils value){
        int result = this.name.compareTo(value.getName());
        if(result > 0){return 1;} // Comes after the current element
        else if(result < 0){return -1;} // It comes before the current element
        else {return 0;} // Equal to the current element
    }
}

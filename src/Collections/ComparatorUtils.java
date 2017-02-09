package Collections;

/**
 * Created by RXC8414 on 2/8/2017.
 */
public class ComparatorUtils {
    private String name;
    private int id=0;
    private double gpa=0.0;

    ComparatorUtils(String name, int id, double gpa){
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
}

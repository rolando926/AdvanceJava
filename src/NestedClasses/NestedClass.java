package NestedClasses;

/**
 * Created by RXC8414 on 1/27/2017.
 */
public class NestedClass {
    // private variable of the outer class
    private int num = 175;

    // inner class
    public class Inner_Demo {
        public int getNum() {
            System.out.println("This is the getnum method of the inner class");
            return num;
        }
    }

    public static void main(String args[]) {
        // Instantiating the outer class
        NestedClass outer = new NestedClass();

        // Instantiating the inner class
        NestedClass.Inner_Demo inner = outer.new Inner_Demo();
        System.out.println(inner.getNum());
    }
}



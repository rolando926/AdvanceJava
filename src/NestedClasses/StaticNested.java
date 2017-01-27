package NestedClasses;

/**
 * Created by RXC8414 on 1/27/2017.
 */
public class StaticNested {
    static class Nested_Demo {
        public void my_method() {
            System.out.println("This is my nested class");
        }
    }

    public static void main(String args[]) {
        StaticNested.Nested_Demo nested = new StaticNested.Nested_Demo();
        nested.my_method();
    }
}

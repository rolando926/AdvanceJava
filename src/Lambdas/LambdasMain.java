package Lambdas;

import java.util.concurrent.TimeUnit;

/**
 * Created by RXC8414 on 2/6/2017.
 */
public class LambdasMain{
    public static void main(String[] args) {
        Operator tester = new Operator();

        //with type declaration
        MathOperation addition = (a, b) -> a + b;

        //with out type declaration
        MathOperation subtraction = (a, b) -> a - b;

        //with return statement along with curly braces
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        //without return statement and without curly braces
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("======= Prior to Java 8 - Anonymous Inner Classes =========");
        System.out.println("10 + 5 = " + tester.operate(10, 5, new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return (a+b);
            }
        }));
        System.out.println("10 - 5 = " + tester.operate(10, 5, new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return (a-b);
            }
        }));
        System.out.println("10 x 5 = " + tester.operate(10, 5, new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return (a * b);
            }
        }));
        System.out.println("10 / 5 = " + tester.operate(10, 5, new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return (a / b);
            }
        }));

        System.out.println("======= Using Lambdas Expressions =========");
        //System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 + 5 = " + tester.operate(10, 5, (a,b)->a+b));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        System.out.println("======= More uses for Lambdas Expressions =========");



    }

    /*
    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
    */
}

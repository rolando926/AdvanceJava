package Lambdas;

/**
 * Created by RXC8414 on 2/6/2017.
 */
public class Operator {
    public int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }

}

package lambdas.whyDoLocalVariablesHaveToBeFinalOrEff;

import java.util.function.Function;

/**
 * Lambda expressions can use variables defined in an outer scope. We refer to these lambdas as capturing lambdas.
 * They can capture static variables, instance variables, and local variables,
 * but only local variables must be final or effectively final.
 * <br>
 * <b>We could say that a variable is effectively final if the compiler wouldn't complain were we to declare it final.</b>
 * But, why does it make a copy? Well, notice that we are returning the lambda from our method. Thus, the lambda won't
 * get run until after the start method parameter gets garbage collected.
 * Java has to make a copy of start in order for this lambda to live outside of this method.
 */

public class CapturingLambdas {
    static int key = 1;

    public static void main(String[] args) {
        Function<Integer, Integer> lambda = a -> key * a;
        key = 100;
        System.out.println(lambda.apply(2));
    }

//    Supplier<Integer> incrementer(int start) {
//        return () -> start++; //error The basic reason this won't compile is that the lambda is capturing the value of start, meaning making a copy of it.
//    }

}

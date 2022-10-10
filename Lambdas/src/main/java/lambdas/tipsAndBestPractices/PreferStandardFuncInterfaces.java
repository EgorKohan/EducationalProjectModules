package lambdas.tipsAndBestPractices;

import java.util.function.Function;

@FunctionalInterface
interface Foo {
    String method(String string);
}

class UseFoo{

    public String add(String string, Function<String, String> foo) {
        return foo.apply(string);
    }

    private String value = "Enclosing scope value";

    public String scopeExperimental(){
        Foo foo = new Foo() {
            private final String value = "Inner class value";

            @Override
            public String method(String string) {
                return this.value;
            }
        };

        System.out.println(foo.method(""));

        Foo fooLambda = string -> {
            String value = "Lambda value";
            return this.value;
        };

        System.out.println(fooLambda.method(""));

        return "";
    }

}

public class PreferStandardFuncInterfaces {

    public static void main(String[] args) {
        UseFoo useFoo = new UseFoo();
        Function<String, String> foo = string -> string + " from lambda";
        String result = useFoo.add("Method", foo);
        System.out.println(result);
    }

}

/**
 * Functional interfaces can be extended by other functional interfaces if their abstract methods have the same signature:
 */

@FunctionalInterface
interface FooExtended extends Baz, Bar {}

@FunctionalInterface
interface Baz {
    String method(String string);
    default String defaultBaz() {
        return "";
    }
}

@FunctionalInterface
interface Bar {
    String method(String string);
    default String defaultBar() {
        return "";
    }
}

@FunctionalInterface
interface Baz2 {
    String method(String string);
    default String defaultBaz() { return "";}
    default String defaultCommon(){ return "";}
}

@FunctionalInterface
interface Bar2 {
    String method(String string);
    default String defaultBar() { return "";}
    default String defaultCommon() { return "";}
}

/**
 * Just as with regular interfaces, extending different functional interfaces with the same default method can be problematic.
 * To fix this, the defaultCommon() method should be overridden in the FooExtended interface.
 * We can provide a custom implementation of this method; however, we can also reuse the implementation from the parent interface:
 */

@FunctionalInterface
interface FooExtended2 extends Baz2, Bar2 {
    @Override
    default String defaultCommon() {
        return "";
    }
}

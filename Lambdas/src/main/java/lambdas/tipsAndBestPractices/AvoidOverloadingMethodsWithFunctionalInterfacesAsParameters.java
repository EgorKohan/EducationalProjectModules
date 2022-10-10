package lambdas.tipsAndBestPractices;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

/**
 * We should use methods with different names to avoid collisions:
 */
interface Processor {
    String process(Callable<String> c) throws Exception;
    String process(Supplier<String> s);
}

class ProcessorImpl implements Processor {
    @Override
    public String process(Callable<String> c) throws Exception {
        return "Call process";
    }

    @Override
    public String process(Supplier<String> s) {
        return "Supp process";
    }
}

public class AvoidOverloadingMethodsWithFunctionalInterfacesAsParameters {

    private String number = "1";

    public static void main(String[] args) {
        ProcessorImpl processor = new ProcessorImpl();
//        String result = processor.process(() -> "abc"); //error reference to process is ambiguous
        // The first option is to use methods with different names:
        //The second option is to perform casting manually, which is not preferred:
        String result = processor.process((Supplier<String>)() -> "Da");
        UseFoo useFoo = new UseFoo();
        useFoo.scopeExperimental();
    }

    public void method() {
        String localVariable = "Local";
        Foo foo = parameter -> {
//            String localVariable = parameter; //Error Variable 'localVariable' is already defined in the scope.
            number = "asd";
            return localVariable;
        };
    }

}

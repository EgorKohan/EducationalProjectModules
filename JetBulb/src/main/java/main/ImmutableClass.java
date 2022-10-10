package main;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableClass {

    private final int a;
    private final List<String> strings;

    public ImmutableClass(int a, List<String> strings) {
        this.a = a;
        this.strings = new ArrayList<>(strings);
    }

    public List<String> getStrings() {
        return List.copyOf(strings);
    }
}

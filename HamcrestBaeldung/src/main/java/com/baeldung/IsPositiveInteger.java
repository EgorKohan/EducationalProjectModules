package com.baeldung;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;


public class IsPositiveInteger extends TypeSafeMatcher<Integer> {

    @Override
    protected boolean matchesSafely(Integer integer) {
        return integer > 0;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a positive integer");
    }

    public static Matcher<Integer> isAPositiveInteger(){
        return new IsPositiveInteger();
    }

}

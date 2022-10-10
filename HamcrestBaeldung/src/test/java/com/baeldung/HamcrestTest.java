package com.baeldung;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class HamcrestTest {

    @Test
    void giver2Strings_whenEqual_thenSuccess() {
        String a = "foo";
        String b = "FOO";
        assertThat(a, equalToIgnoringCase(b));
    }

    @Test
    void givenBean_whenToStringReturnsRequiredString_thenSuccess() {
        Person person = new Person("Barrack", "Washington");
        String str = person.toString();
        assertThat(person, hasToString(str));
    }

    @Test
    void given2Classes_whenOneInheritsFromOther_thenSuccess() {
        assertThat(Cat.class, typeCompatibleWith(Animal.class));
    }

    @Test
    void test() {
        List<String> list = Arrays.asList("", "asd");
        assertThat(list, hasItem(""));
        assertThat(list, Matchers.notNullValue());

    }

    @Test
    void givenBean_whenHasValue_thenSuccess() {
        Person person = new Person("Baeldung", "Com");
        assertThat(person, hasProperty("name"));
    }

    @Test
    void givenBean_whenHasValueAddress_thenSuccess() {
        Person person = new Person("Baeldung", "New York");
        assertThat(person, hasProperty("address", equalTo("New York")));
    }

    @Test
    void given2Beans_whenHavingSameValues_thenSuccess() {
        Person person = new Person("Baeldung", "New York");
        Person person2 = new Person("Baeldung", "New York");
        assertThat(person, samePropertyValuesAs(person2));
    }

    @Test
    void givenCollection_whenEmpty_thenSuccess() {
        Collection<?> collection = Collections.emptyList();
        assertThat(collection, empty());
    }

    @Test
    void givenCollection_whenCheckSize_thenSuccess() {
        String[] strings = {"collection", "of", "beans"};
        assertThat(strings, arrayWithSize(3));
    }

    @Test
    void givenAListAndValues_whenChecksListForGivenValues_thenSuccess() {
        List<String> matchersStrings = Arrays.asList("Collection", "beans", "test", "number");
        assertThat(matchersStrings, containsInAnyOrder("beans", "test", "number", "Collection"));
    }

    @Test
    void givenAListAndValues_whenChecksListForGivenValuesWithOrder_thenSuccess() {
        List<String> matchersStrings = Arrays.asList("Collection", "beans", "test", "number");
        assertThat(matchersStrings, contains("Collection", "beans", "test", "number"));
    }

    @Test
    void givenArrayAndValue_whenValueFoundInArray_thenSuccess() {
        String[] strings = {"collections", "text", "beans", "number"};
        assertThat(strings, hasItemInArray("text"));
    }

    @Test
    void givenArrayAndValue_whenValueIsOneOfArrayValues_thenSuccess() {
        String[] strings = {"collections", "text", "beans", "number"};
        assertThat("text", isOneOf(strings));
    }

    @Test
    void givenValueAndArray_whenValueFoundInArray_thenSuccess() {
        String[] strings = {"collections", "text", "beans", "number"};
        assertThat("beans", isIn(strings));
    }

    @Test
    void givenArrayAndValues_whenValuesFoundInArray_thenSuccess() {
        String[] strings = {"collections", "text", "beans", "number"};
        assertThat(strings, arrayContainingInAnyOrder("text", "beans", "collections", "number"));
    }

    @Test
    void givenArrayAndValues_whenValuesFoundInArrayWithOrder_thenSuccess() {
        String[] strings = {"collections", "text", "beans", "number"};
        assertThat(strings, arrayContaining("collections", "text", "beans", "number"));
    }

    @Test
    void givenMapAndKey_whenKeyFoundInMap_thenSuccess() {
        Map<String, String> map = new HashMap<>();
        map.put("blogname", "baeldung");
        assertThat(map, hasKey("blogname"));
    }

    @Test
    void givenMapAndValue_whenValueFoundInMap_thenSuccess() {
        Map<String, String> map = new HashMap<>();
        map.put("blogname", "baeldung");
        assertThat(map, hasValue("baeldung"));
    }

    @Test
    void givenMapAndValue_whenEntryFoundInMap_thenSuccess() {
        Map<String, String> map = new HashMap<>();
        map.put("blogname", "baeldung");
        assertThat(map, hasEntry("blogname", "baeldung"));
    }

    // Then following number, text matchers

    @Test
    void given2Strings_whenIsNotEqualRegardlessWhiteSpace_thenCorrect() {
        String str1 = "text";
        String str2 = " texts ";
        assertThat(str1, not(equalToIgnoringWhiteSpace(str2)));
    }

    @Test
    void givenList_whenEachElementGreaterThan0_thenSuccess() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(integers, everyItem(greaterThan(0)));
    }

    @Test
    void givenString_whenMeetsAnyOfGivenConditions_thenSuccess() {
        String str = "calligraphy";
        String start = "call";
        String end = "foo";
        assertThat(str, anyOf(startsWith(start), containsString(end)));
    }

    @Test
    void givenString_whenNotMeetsAllOfGivenConditions_thenSuccess() {
        String str = "calligraphy";
        String start = "call";
        String end = "phy";
        assertThat(str, allOf(startsWith(start), containsString(end)));
    }

    @Test
    void givenInteger_whenIsPositiveInteger_thenSuccess(){
        Integer integer = 5;
        assertThat(integer, IsPositiveInteger.isAPositiveInteger());
    }

}

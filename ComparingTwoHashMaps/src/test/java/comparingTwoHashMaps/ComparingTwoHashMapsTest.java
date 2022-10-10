package comparingTwoHashMaps;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.lang.NonNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ComparingTwoHashMapsTest {


    Map<String, String> asiaCapital1 = new HashMap<>();
    Map<String, String> asiaCapital2 = new HashMap<>();
    Map<String, String> asiaCapital3 = new HashMap<>();

    Map<String, List<String>> asianCountryToTownsMap = new HashMap<>();
    Map<String, List<String>> asianCountryToTownsMap2 = new HashMap<>();

    @Before
    public void beforeMethod() {
        asiaCapital1.put("Japan", "Tokyo");
        asiaCapital1.put("South Korea", "Seoul");

        asiaCapital2.put("South Korea", "Seoul");
        asiaCapital2.put("Japan", "Tokyo");

        asiaCapital3.put("Japan", "Tokyo");
        asiaCapital3.put("China", "Beijing");

        asianCountryToTownsMap.put("Japan", Arrays.asList("Tokyo", "Hiroshima", "Nagasaki"));
        asianCountryToTownsMap2.put("Japan", Arrays.asList("Tokyo", "Nagasaki", "Hiroshima"));

    }

    /**
     * The way that Map.equals() works is by comparing keys and values using the
     * Object.equals() method. This means it only works properly when both key and value
     * objects implement equals() properly.
     * <b>For example, Map.equals() doesn't work when the value type is array, as and array's
     * equals() method compares identity and not the contents of the array</b>
     */

    @Test
    @SuppressWarnings("SimplifiableAssertion")
    public void whenCompareTwoHashMapsUsingEquals_thenSuccess() {
        assertTrue(asiaCapital1.equals(asiaCapital2));
        assertFalse(asiaCapital1.equals(asiaCapital3));

    }

    /**
     * As said in the previous point, we cannot compare maps with arrays in them
     */

    @Test
    @SuppressWarnings({"SimplifiableAssertion"})
    public void whenCompareTwoHashMapsWithArrays_thenFail() {
        assertFalse(asianCountryToTownsMap.equals(asianCountryToTownsMap2));
    }

    /**
     * Methods for comparing of two maps
     *
     * @param first
     * @param second
     * @return
     */

    public boolean areEqual(Map<String, String> first, Map<String, String> second) {
        if (first.size() != second.size()) return false;
        return first.entrySet().stream()
                .allMatch(e -> e.getValue().equals(second.get(e.getKey())));
    }

    public boolean areEqualWithArrayValue(Map<String, String[]> first, Map<String, String[]> second) {
        return first.size() == second.size() &&
                first.entrySet().stream()
                        .allMatch(e -> second.get(e.getKey()) != null && e.getValue().length == second.get(e.getKey()).length &&
                                Arrays.asList(e.getValue()).containsAll(Arrays.asList(second.get(e.getKey())))
                        );
    }

    @Test
    public void whenCompareTwoHashMapsUsingStreamAPI_thenSuccess() {
        assertTrue(areEqual(asiaCapital1, asiaCapital2));
        assertFalse(areEqual(asiaCapital3, asiaCapital1));
    }

    @Test
    public void whenCompareTwoHashMapsWithArraysUsingStreamAPI_thenSuccess() {
        Map<String, String[]> asianCountryToTownsMap = new HashMap<>();
        asianCountryToTownsMap.put("Japan", new String[]{"Tokyo", "Hiroshima", "Nagasaki"});
        Map<String, String[]> asianCountryToTownsMap2 = new HashMap<>();
        asianCountryToTownsMap2.put("Japan", new String[]{"Tokyo", "Nagasaki", "Hiroshima"});

        assertTrue(areEqualWithArrayValue(asianCountryToTownsMap, asianCountryToTownsMap2));
    }

    /**
     * Comparing HashMap keys
     */

    @Test
    @SuppressWarnings("SimplifiableAssertion")
    public void whenCompareTwoHashMapKeys_thenSuccess() {
        assertTrue(asianCountryToTownsMap.keySet().equals(asianCountryToTownsMap2.keySet()));
    }

    private Map<String, Boolean> areEqualKeyValues(Map<String, String> first, Map<String, String> second) {
        return first.entrySet().stream()
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                e -> e.getValue().equals(second.get(e.getKey())))
                );
    }

    /**
     * Here I used Hamcrest to assert that map contains such entries as below.
     */

    @Test
    public void whenComparingTwoHashMapsUsingEqualKeyValue_thenSuccess() {
        Map<String, Boolean> result = areEqualKeyValues(asiaCapital1, asiaCapital3);
        MatcherAssert.assertThat(result, Matchers.hasEntry("Japan", true));
        MatcherAssert.assertThat(result, Matchers.hasEntry("South Korea", false));

    }

    /**
     * Here I used Guava entriesDiffering() method
     */

    @Test
    public void givenDifferentMaps_whenGetDiffUsingGuava_thenSuccess() {
        Map<String, String> asia1 = new HashMap<String, String>();
        asia1.put("Japan", "Tokyo");
        asia1.put("South Korea", "Seoul");
        asia1.put("India", "New Delhi");

        Map<String, String> asia2 = new HashMap<String, String>();
        asia2.put("Japan", "Tokyo");
        asia2.put("China", "Beijing");
        asia2.put("India", "Delhi");
        MapDifference<String, String> difference = Maps.difference(asia1, asia2);

        // The entriesDiffering method returns a new Map that contains the set of common keys and ValueDifference objects as the set of values
        Map<String, MapDifference.ValueDifference<String>> differing = difference.entriesDiffering();

        assertFalse(difference.areEqual());
        assertEquals(1, differing.size());
        MatcherAssert.assertThat(differing, Matchers.hasKey("India"));
        assertEquals("New Delhi", differing.get("India").leftValue());
        assertEquals("Delhi", differing.get("India").rightValue());

    }

    /**
     * Here I used Guava MapDifference.entriesOnlyOnRight() and MapDifference.entriesOnlyOnLeft() methods
     */

    @Test
    public void givenDifferentMaps_whenGetEntriesOnOneSideUsingGuava_thenSuccess() {
        Map<String, String> asia1 = new HashMap<String, String>();
        asia1.put("Japan", "Tokyo");
        asia1.put("South Korea", "Seoul");
        asia1.put("India", "New Delhi");

        Map<String, String> asia2 = new HashMap<String, String>();
        asia2.put("Japan", "Tokyo");
        asia2.put("China", "Beijing");
        asia2.put("India", "Delhi");

        MapDifference<String, String> difference = Maps.difference(asia1, asia2);

        Map<String, String> onlyOnLeft = difference.entriesOnlyOnLeft();
        Map<String, String> onlyOnRight = difference.entriesOnlyOnRight();

        assertEquals(1, onlyOnLeft.size());
        assertEquals(1, onlyOnRight.size());
        MatcherAssert.assertThat(onlyOnLeft, Matchers.hasEntry("South Korea", "Seoul"));
        MatcherAssert.assertThat(onlyOnRight, Matchers.hasEntry("China", "Beijing"));
    }

    /**
     * Here I used MapDifference.entriesInCommon() method
     * Here we get common entries
     */

    @Test
    public void givenDifferentMap_whenGetCommonEntriesUsingGuava_thenSuccess() {
        MapDifference<String, String> difference = Maps.difference(asiaCapital1, asiaCapital3);
        Map<String, String> inCommon = difference.entriesInCommon();

        assertEquals(1, inCommon.size());
        MatcherAssert.assertThat(inCommon, Matchers.hasEntry("Japan", "Tokyo"));

    }

    /**
     * Here I customized Maps.difference() method behaviour
     * Since Maps.difference() use equals() and hashCode() by default to compare entries,
     * it won't work for Objects that don't implement them properly
     */

    @Test
    public void givenSimilarMapsWithArrayValue_whenCompareUsingGuava_thenFail() {
        Map<String, String[]> asianCountryToTownsMap = new HashMap<>();
        asianCountryToTownsMap.put("Japan", new String[]{"Tokyo", "Hiroshima", "Nagasaki"});
        Map<String, String[]> asianCountryToTownsMap2 = new HashMap<>();
        asianCountryToTownsMap2.put("Japan", new String[]{"Tokyo", "Nagasaki", "Hiroshima"});

        MapDifference<String, String[]> difference = Maps.difference(asianCountryToTownsMap, asianCountryToTownsMap2);
        assertFalse(difference.areEqual());

    }

    /**
     * We can customize the method used in comparison using Equivalence
     */

    @Test
    public void givenSimilarMapsWithArrayValue_whenCompareUsingGuavaEquivalence_thenSuccess() {
        Map<String, String[]> asianCountryToTownsMap = new HashMap<>();
        asianCountryToTownsMap.put("Japan", new String[]{"Tokyo", "Hiroshima", "Nagasaki"});
        Map<String, String[]> asianCountryToTownsMap2 = new HashMap<>();
        asianCountryToTownsMap2.put("Japan", new String[]{"Tokyo", "Nagasaki", "Hiroshima"});

        Equivalence<String[]> equivalence = new Equivalence<>() {
            @Override
            protected boolean doEquivalent(@NonNull String[] strings, @NonNull String[] strings2) {
                return CollectionUtils.isEqualCollection(Arrays.asList(strings), Arrays.asList(strings2));
            }

            @Override
            protected int doHash(@NonNull String[] strings) {
                return Arrays.hashCode(strings);
            }
        };

        MapDifference<String, String[]> difference = Maps.difference(asianCountryToTownsMap, asianCountryToTownsMap2, equivalence);
        assertTrue(difference.areEqual());

    }

    /**
     * Conclusion:
     * In this article, we discussed different ways to compare HashMaps in Java.
     * We learned multiple ways to check if two HashMaps are equal and how to get the detailed difference as well.
     */

    @Test
    public void conclusion_thenSuccess() {
        boolean isEnd = true;
        assertTrue(isEnd);
    }

}

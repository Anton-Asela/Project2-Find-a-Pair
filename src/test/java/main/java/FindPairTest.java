package main.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class FindPairTest {

    private FindPair pair;

    @BeforeEach
    void init() {
        pair = new FindPair();
    }

    private void testFindPair_noSolution(int target, int... values) {
        Set ret = pair.findPair(values, target);
        assertNotNull(ret);
        assertInstanceOf(Set.class,ret);
        assertTrue(ret.isEmpty());
    }

    private void testFindPair(int target, int... input) {
        Set<Integer> pair = this.pair.findPair(input, target);
        assertNotNull(pair);
        assertEquals(2, pair.size());
        assertEquals(target,pair.stream().mapToInt(Integer::intValue).sum());
        assertTrue(Arrays.stream(input).boxed().collect(Collectors.toSet()).containsAll(pair));
    }

    @Test
    void shouldReturnEmpty_whenInputIsNull() {
        testFindPair_noSolution(0, null);
    }

    @Test
    void shouldReturnEmpty_whenNoMatchingPairs() {
        testFindPair_noSolution(200, 1, 2, 5, 4);
    }

    @Test
    void shouldReturnMatchingPair_whenArraySize_Two() {
        testFindPair(3, 1, 2);
    }

    @Test
    void shouldReturnMatchingPair_whenArraySize_Three() {
        testFindPair(6, 1, 2, 5);
    }

    @Test
    void shouldReturnMatchingPair_whenArraySize_Four() {
        testFindPair(6, 0, 2, 5, 4);
    }

    @Test
    void shouldReturnOnlyOneMatchingPair_whenTwoMatchingPairsExits() {
        testFindPair(6, 1, 2, 5, 4);
    }

    @Test
    void challenge_test1() {
        testFindPair(10, 8, 7, 5, 2, 3, 1);
    }

    @Test
    void challenge_test2() {
        testFindPair_noSolution(12, 5, 2, 6, 8, 1, 9);
    }

    @Test
    void check_performance() {
        int[] input = RandomGenerator.getDefault().ints(1, 20000)
                .limit(1000000).toArray();
        input[input.length - 1] = 100_000_000;
        input[input.length - 2] = 100_000_001;
        testFindPair(200_000_001, input);
    }

}
package main.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
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

    private void testFindPair_noSolution(int[] values, int limit) {
        Set ret = pair.findPair(values, limit);
        assertNotNull(ret);
        assertInstanceOf(Set.class,ret);
        assertTrue(ret.isEmpty());
    }

    private void testFindPair(int[] input, int limit) {
        Set<Integer> pair = this.pair.findPair(input, limit);
        assertNotNull(pair);
        assertEquals(2, pair.size());
        assertEquals(limit,pair.stream().mapToInt(Integer::intValue).sum());
        assertTrue(Arrays.stream(input).boxed().collect(Collectors.toSet()).containsAll(pair));
    }

    @Test
    void shouldReturnEmpty_whenInputIsNull() {
        testFindPair_noSolution(null, 0);
    }

    @Test
    void shouldReturnEmpty_whenNoMatchingPairs() {
        testFindPair_noSolution(new int[]{1, 2, 5, 4}, 200);
    }

    @Test
    void shouldReturnMatchingPair_whenArraySize_Two() {
        testFindPair(new int[]{1, 2}, 3);
    }

    @Test
    void shouldReturnMatchingPair_whenArraySize_Three() {
        testFindPair(new int[]{1, 2, 5}, 6);
    }

    @Test
    void shouldReturnMatchingPair_whenArraySize_Four() {
        testFindPair(new int[]{0, 2, 5, 4}, 6);
    }

    @Test
    void shouldReturnOnlyOneMatchingPair_whenTwoMatchingPairsExits() {
        testFindPair(new int[]{1, 2, 5, 4}, 6);
    }

    @Test
    void challenge_test1() {
        testFindPair(new int[]{8, 7, 5, 2, 3, 1}, 10);
    }

    @Test
    void challenge_test2() {
        testFindPair_noSolution(new int[]{5, 2, 6, 8, 1, 9}, 12);
    }

    @Test
    void performace() {


        int[] input = RandomGenerator.getDefault().ints(1, 20000)
                .limit(1000000).toArray();
        input[input.length - 1] = 100_000_000;
        input[input.length - 2] = 100_000_001;
        testFindPair(input, 200_000_001);
    }

}
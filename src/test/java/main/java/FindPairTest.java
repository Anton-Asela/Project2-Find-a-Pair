package main.java;

import org.apache.commons.lang.time.StopWatch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.Timer;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class FindPairTest {

    private FindPair pair;

    @BeforeEach
    void init() {
        pair = new FindPair().useAlgo(FindPair.Algo.BRUTE);
    }

    private void testFindPair_noSolution(int target, int... values) {
        Set ret = pair.findPair(values, target);
        assertNotNull(ret);
        assertInstanceOf(Set.class,ret);
        assertTrue(ret.isEmpty());
    }


    private void testFindPair(FindPair.Algo algo, int target, int... input) {
        pair.useAlgo(algo);
        testFindPair(target,input);
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
        StopWatch stopWatch = new StopWatch();

        for(FindPair.Algo algo: FindPair.Algo.values()) {
            System.out.printf("%n %15s : ", algo);
            for (int size = 10; size < 10_000_000; size *= 10) {
                int[] input = RandomGenerator.getDefault().ints(1, 20000)
                        .limit(size).toArray();
                input[input.length - 1] = 100_000_000;
                input[input.length - 2] = 100_000_001;
                stopWatch.reset();
                stopWatch.start();
                testFindPair(algo, 200_000_001, input);
                stopWatch.stop();
                System.out.printf("(%10s,%10s) ", size, stopWatch.getTime());
            }
        }
    }

}
package main.java;

import java.util.*;

public class FindPair {

    public enum Algo { BRUTE,TWO_POINTER,HASH_SET}

    private Algo useAlgo = Algo.HASH_SET;

    public FindPair useAlgo(Algo algo) {
        this.useAlgo = algo;
        return this;
    }

    public Set<Integer> findPair(int[] values, int target) {
        switch (useAlgo) {
            case BRUTE -> {
                return bruteForceSolution(values, target);
            }
            case TWO_POINTER -> {
                return twoPointerSolution(values, target);
            }
            case HASH_SET -> {
                return hashSetSolution(values, target);
            }
            default -> throw new IllegalStateException("No Algo Defined.");
        }
    }

    private Set<Integer> hashSetSolution(int[] values, int target) {
        Set<Integer> ret = new HashSet<>();

        if (!Objects.nonNull(values) || values.length <= 0) {
            return ret;
        }

        // Time Complexity = N | Space Complexity = 2N
        Set<Integer> set = new HashSet<>();

        for (int current : values) {
            if(set.contains(current)) {
                ret.add(current);
                ret.add(target - current);
                return ret;
            } else {
                set.add(target - current);
            }
        }

        return ret;
    }


    private Set<Integer> twoPointerSolution(int[] values, int target) {
        Set<Integer> ret = new HashSet<>();

        if (!Objects.nonNull(values) || values.length <= 0) {
            return ret;
        }

        // n * log(n)
        Arrays.sort(values);

        // Time Complexity = n*log(n) | Space Complexity = N
        for (int start = 0, end = values.length -1; start < end ; ) {
            int sum = values[start] + values[end];
            if (sum == target) {
                    ret.add(values[start]);
                    ret.add(values[end]);
                    return ret;
             } else if (sum < target) start++;
             else if (sum > target) end --;
        }
        return ret;
    }


    private Set<Integer> bruteForceSolution(int[] values, int target) {
        Set<Integer> ret = new HashSet<>();

        if (!Objects.nonNull(values) || values.length <= 0) {
            return ret;
        }
        // Time Complexity = n^2 | Space Complexity = N
        for (int i = 0; i < values.length ; i++) {
            for(int j = i + 1; j < values.length; j++) {
                if (values[i] + values[j] == target) {
                    ret.add(values[i]);
                    ret.add(values[j]);
                    return ret;
                }
            }
        }
        return ret;
    }

}

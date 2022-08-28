# Project2-Find-a-Pair
Find a pair for a given sum in an array

Given an unsorted array of integers, find a pair with the sum equal to the given target.

For example,

```
Input:
nums = [8, 7, 5, 2, 3, 1]
target = 10

Output: (8, 2) and  (7, 3)


Input:
nums = [5, 2, 6, 8, 1, 9]
target = 12

Output: Pair not found

```

###[Ping Pong](https://martinfowler.com/articles/on-pair-programming.html#PingPong)

This technique embraces Test-Driven Development (TDD) and is perfect when you have a clearly defined task that can be implemented in a test-driven way.

- "Ping": Developer A writes a failing test

- "Pong": Developer B writes the implementation to make it pass.

- Developer B then starts the next "Ping", i.e. the next failing test.

- Each "Pong" can also be followed by refactoring the code together, before you move on to the next failing test. This way you follow the "Red - Green - Refactor" approach: Write a failing test (red), make it pass with the minimum necessary means (green), and then refactor.



## Transformation Priority Premise

1. ### ({} → nil) no code at all → code that employs nil
2. ### (nil → constant)
3. ### (constant → constant+) a simple constant to a more complex constant
4. ### (constant → scalar) replacing a constant with a variable or an argument
5. ### (statement → statements) adding more unconditional statements.
6. ### (unconditional → if) splitting the execution path
7. ### (scalar → array)
8. ### (array → container)
9. ### (statement → tail-recursion)
10. ###  (if → while)
11. ### (statement → non-tail-recursion)
12. ### (expression → function) replacing an expression with a function or algorithm
13. ### (variable → assignment) replacing the value of a variable.
14. ### (case) adding a case (or else) to an existing switch or if


## Performance Test Results for Three Algorithms 

```text

           BRUTE : (        10,         2) (       100,         0) (      1000,         2) (     10000,        13) (    100000,      1258) (   1000000,    107943) 
     TWO_POINTER : (        10,         0) (       100,         0) (      1000,         0) (     10000,         3) (    100000,        11) (   1000000,        74) 
        HASH_SET : (        10,         0) (       100,         0) (      1000,         0) (     10000,         2) (    100000,        12) (   1000000,        35) 

```
            


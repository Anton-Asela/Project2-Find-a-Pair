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



package com.juanpabloprado;

import java.util.HashMap;
import java.util.Map;

public class Fib {

    // memoization
    // java map, keys will be arg to fn, value will be the return value

    static int fib(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return fib(n, memo);
    }

    static int fib(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) return memo.get(n);
        if (n <= 2) return 1;
        memo.put(n, fib(n - 1, memo) + fib(n - 2, memo));
        System.out.println(memo);
        return memo.get(n);
    }

    public static void main(String[] args) {
        System.out.println(fib(6));
    }
}

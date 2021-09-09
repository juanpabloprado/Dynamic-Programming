package com.juanpabloprado;

import java.util.HashMap;
import java.util.Map;

public class GridTraveler {

    static long gridTraveler(int m, int n) {
        Map<String, Long> memo = new HashMap<>();
        return gridTraveler(m, n, memo);
    }

    private static long gridTraveler(long m, long n, Map<String, Long> memo) {
        String key = m + "," + n;
        if (memo.containsKey(key)) return memo.get(key);
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;

        memo.put(key, gridTraveler(m - 1, n, memo) + gridTraveler(m, n - 1, memo));
        return memo.get(key);
    }

    public static void main(String[] args) {
        System.out.println(gridTraveler(1, 1)); // 1
        System.out.println(gridTraveler(2, 3)); // 3
        System.out.println(gridTraveler(3, 2)); // 3
        System.out.println(gridTraveler(3, 3)); // 6
        System.out.println(gridTraveler(18, 18)); // 2333606220
    }
}

package com.juanpabloprado;

import java.util.HashMap;
import java.util.Map;

public class CanSum {

    static boolean canSum(int targetSum, int[] numbers) {
        Map<Integer, Boolean> memo = new HashMap<>();
        return canSum(targetSum, numbers, memo);
    }

    static boolean canSum(int targetSum, int[] numbers, Map<Integer, Boolean> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;

        for (int number : numbers) {
            int remainder = targetSum - number;
            if (canSum(remainder, numbers, memo)) {
                memo.put(targetSum, true);
                return true;
            }
        }

        memo.put(targetSum, false);
        return false;
    }


    public static void main(String[] args) {
        System.out.println(canSum(7, new int[]{2, 3})); // true
        System.out.println(canSum(7, new int[]{5, 3, 4, 7})); // true
        System.out.println(canSum(7, new int[]{2, 4})); // false
        System.out.println(canSum(8, new int[]{2, 3, 5})); // true
        System.out.println(canSum(300, new int[]{7, 14})); // false
    }
}

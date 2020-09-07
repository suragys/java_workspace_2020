package com.yukthi.leet;

import java.util.*;
/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 * <p>
 * Example 1:
 * <p>
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class _560SubarraySumEqualsK {

    // generate all contiguous subarray
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(-1, 0);
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumMap.put(i, sum);
        }

        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++){
                int subArraySum = sumMap.get(j) - sumMap.get(i-1);
                if(subArraySum == k) {
                    res++;
                }
            }
        }

        System.out.println(res);
    }


    /**
     *
     * @param nums
     * @param k
     * @return
     *
     * Using hash map to store the sum and frequencies of the sum that occurred and using the frequencies
     * to calculate number of contiguous sum.
     *
     * O(n), O(n) nice solution.
     */
    public static int optimalSolution(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        int sum = 0;
        m.put(0,1);
        int res = 0;

        for (int num : nums) {
            sum += num;
            if (m.containsKey(sum - k)) {
                res += m.get(sum - k);
            }

            m.put(sum, m.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}

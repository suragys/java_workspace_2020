package com.yukthi.grokking;

public class MaxSumSubArrayOfSizeK {

    /*
    { 2, 1, 5, 1, 3, 2 }
    k = 3
  */

    public static int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int end = 0;
        if (k > arr.length) {
            return -1;
        }
        int sum = 0;
        while (end < arr.length) {// 6 < 6
            sum += arr[end]; // end = 5, sum = 6
            if (end >= k - 1) { // 5 >= 2
                if (maxSum < sum) { // 8 < 6
                    maxSum = sum; // maxSum = 9
                }
                sum -= arr[end - k + 1]; // arr[4] subtract ; sum = 6-1 = 5
            }
            end++; // end = 6
        }

        return maxSum; // 9
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2}));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5}));
    }
}

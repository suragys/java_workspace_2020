package com.yukthi.leet;

import java.util.HashMap;
import java.util.Map;

public class _1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++) {
            int r = target - nums[i];
            if(m.containsKey(nums[i])){
                res[0] = m.get(nums[i]);
                res[1] = i;
                break;
            } else {
                m.put(r, i);
            }
        }
        return res;
    }
}

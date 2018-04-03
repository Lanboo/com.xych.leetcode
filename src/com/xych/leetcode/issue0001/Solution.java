package com.xych.leetcode.issue0001;

import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public int[] twoSum(int[] nums, int target)
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++)
        {
            int num = target - nums[i];
            if(map.containsKey(num))
            {
                return new int[] { map.get(num), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

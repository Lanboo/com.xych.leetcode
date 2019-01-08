package com.xych.leetcode.p0.p0.issue0007;

public class Solution
{
    public int reverse(int x)
    {
        if(x > -10 && x < 10)
            return x;
        char[] nums = Integer.toString(x).toCharArray();
        int maxIndex = nums.length - 1;
        int minIndex = -1;
        StringBuffer sb = new StringBuffer(nums.length);
        if(x < 0)
        {
            minIndex++;
            sb.append('-');
        }
        while(nums[maxIndex] == '0')
        {
            maxIndex--;
        }
        while(maxIndex > minIndex)
        {
            sb.append(nums[maxIndex]);
            maxIndex--;
        }
        //当反转后超出int范围，返回0
        long temp = Long.parseLong(sb.toString());
        return temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE ? 0 : (int) temp;
    }

    /**
     * 在LeetCode测试，最快。37ms
     * @param x
     * @return
     * @author 晓月残魂
     * @date 2018年4月3日下午12:09:43
     */
    public int reverse2(int x)
    {
        int result = 0;
        while(x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if((newResult - tail) / 10 != result)
            {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }

    public int reverse3(int x)
    {
        long result = 0;
        while(x != 0)
        {
            result = result * 10 + x % 10;
            x /= 10;
        }
        int temp;
        return result == (temp = (int) result) ? temp : 0;
    }

    public static void main(String[] args)
    {
        int num = 1534236469;
        System.out.println(new Solution().reverse2(num));
    }
}

package com.xych.leetcode.issue0008;

import java.util.HashSet;
import java.util.Set;

public class Solution
{
    private static Set<Character> set = new HashSet<Character>();
    private static Set<Character> set1 = new HashSet<Character>();
    static
    {
        set.add('0');
        set.add('1');
        set.add('2');
        set.add('3');
        set.add('4');
        set.add('5');
        set.add('6');
        set.add('7');
        set.add('8');
        set.add('9');
        set1.addAll(set);
        set1.add('-');
        set1.add('+');
    }

    public int myAtoi(String str)
    {
        if(str == null)
            return 0;
        str = str.trim();
        int len = 0;
        if((len = str.length()) == 0)
        {
            return 0;
        }
        char[] chars = str.toCharArray();
        if(!set1.contains(chars[0]))
        {
            return 0;
        }
        int i = 0;
        long result = 1;
        if(chars[0] == '-')
        {
            i++;
            result = -1;
        }
        else if(chars[0] == '+')
        {
            i++;
        }
        StringBuilder sb = new StringBuilder(11);
        boolean start = false;
        while(i < len)
        {
            if(sb.length() > 12)
            {
                break;
            }
            if(!start && chars[i] == '0')
            {
                i++;
                continue;
            }
            if(set.contains(chars[i]))
            {
                sb.append(chars[i]);
                i++;
                start = true;
                continue;
            }
            break;
        }
        String resultStr = sb.toString();
        result = result * Long.parseLong(resultStr.length() == 0 ? "0" : resultStr);
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (result < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) result);
    }

    public int myAtoi2(String str)
    {
        int len = str.length();
        if(len == 0)
        {
            return 0;
        }
        int start = 0;
        // 1. remove space
        while(str.charAt(start) == ' ')
        {
            start++;
        }
        // 2. handle the sign
        char sign = str.charAt(start);
        int flag = 1;
        if(sign == '+' || sign == '-')
        {
            start++;
            flag = sign == '+' ? 1 : -1;
        }
        // 3. extract integer
        int num = 0;
        long res = 0;
        while(start < len)
        {
            num = str.charAt(start++) - '0';
            if(res > Integer.MAX_VALUE || num > 9 || num < 0)
            {
                break;
            }
            res *= 10;
            res += num;
        }
        res *= flag;
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
        {
            return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int) res;
    }

    public static void main(String[] args)
    {
        String str = "-2147483649";
        System.out.println(new Solution().myAtoi(str));
    }
}

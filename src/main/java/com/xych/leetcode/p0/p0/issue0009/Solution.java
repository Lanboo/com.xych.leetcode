package com.xych.leetcode.p0.p0.issue0009;

public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        // 取出最高位、最低位，然后比较
        int d = 1;
        while(x / d >= 10) {
            d *= 10;
        }
        while(x > 0) {
            int p = x / d;
            int q = x % 10;
            if(p != q)
                return false;
            x = x % d / 10;
            d /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome(-1));
        System.out.println(s.isPalindrome(1));
        System.out.println(s.isPalindrome(11));
        System.out.println(s.isPalindrome(12));
        System.out.println(s.isPalindrome(121));
        System.out.println(s.isPalindrome(1221));
    }
}

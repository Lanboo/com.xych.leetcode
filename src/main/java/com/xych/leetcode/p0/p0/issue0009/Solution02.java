package com.xych.leetcode.p0.p0.issue0009;

public class Solution02 {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        if(x < 10) {
            return true;
        }
        if(x % 10 == 0) {
            return false;
        }
        int num = 0;
        while(x > num) {
            num = num * 10 + x % 10;
            x /= 10;
        }
        // System.out.println("x=" + x + ",num=" + num);
        return num == x || x == num / 10;
    }

    public static void main(String[] args) {
        Solution02 s = new Solution02();
        System.out.println(s.isPalindrome(-1));
        System.out.println(s.isPalindrome(1));
        System.out.println(s.isPalindrome(11));
        System.out.println(s.isPalindrome(12));
        System.out.println(s.isPalindrome(121));
        System.out.println(s.isPalindrome(1221));
    }
}

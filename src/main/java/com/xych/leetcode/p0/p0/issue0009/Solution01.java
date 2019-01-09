package com.xych.leetcode.p0.p0.issue0009;

public class Solution01 {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        if(x < 10) {
            return true;
        }
        char[] chars = (x + "").toCharArray();
        for(int i = 0, len = chars.length / 2; i < len; i++) {
            if(chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution01 s = new Solution01();
        System.out.println(s.isPalindrome(-1));
        System.out.println(s.isPalindrome(1));
        System.out.println(s.isPalindrome(11));
        System.out.println(s.isPalindrome(12));
        System.out.println(s.isPalindrome(121));
    }
}

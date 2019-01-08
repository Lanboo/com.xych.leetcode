package com.xych.leetcode.p0.p0.issue0002;

public class Solution
{
    //public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode p = l1, q = l2, result = new ListNode(0);
        int sum = 0;
        ListNode temp = result;
        while(p != null || q != null)
        {
            if(p != null)
            {
                sum += p.val;
                p = p.next;
            }
            if(q != null)
            {
                sum += q.val;
                q = q.next;
            }
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            sum /= 10;
        }
        if(sum > 0)
        {
            temp.next = new ListNode(sum);
        }
        return result.next;
    }

//    public static void main(String[] args)
//    {
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
//        ListNode result = addTwoNumbers(l1, l2);
//    }
}

/*

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.


*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode p1=l1;
    ListNode p2=l2;
    int carry=0; int sum=0;
    ListNode temphead=new ListNode(0);
    ListNode curr=temphead;
    
    while (p1!=null || p2!=null)
    {
        int x= p1==null? 0:p1.val;
        int y= p2==null? 0:p2.val;
        sum=carry+x+y;
        carry=(int)sum/10;
        curr.next=new ListNode(sum%10);
        curr=curr.next;
        if(p1!=null)
        {
            p1=p1.next;
        }
        if(p2!=null)
        {
            p2=p2.next;
        }
    }
    if(carry>0)
    {
        curr.next=new ListNode(carry);
    }
    
    return temphead.next;
}   
}
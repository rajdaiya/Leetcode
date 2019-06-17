/*

Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true

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
    ListNode node=null;
    
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;   
        if(node == null) node = head;   //node points at front
        
        boolean bool = isPalindrome(head.next); //send head to end
        
        if(head.val == node.val)    //compare the front and end nodes
            node = node.next;
        else
            bool = false;
        
        return bool;
    }
}
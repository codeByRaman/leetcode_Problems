/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int index){
        ListNode temp = head;
        if (index == 0){
            head = head.next;
            return head;
        }

        for (int i = 0; i < index - 1 && temp != null; i ++){
            temp = temp.next;
        }

        if(temp != null && temp.next != null){
            temp.next = temp.next.next;
        }

        return head;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode temp = head;

        while (temp != null){
            count ++;
            temp = temp.next;
        }

        int index = count - n ;
        ListNode result = deleteNode(head,index);

        return result;
        
    }
}
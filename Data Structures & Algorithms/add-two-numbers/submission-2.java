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
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        int carry = 0;
        while(list1 != null || list2 != null || carry != 0){
            int val1 = list1 == null? 0 : list1.val;
            int val2 = list2 == null? 0 : list2.val;
            int sum = val1 + val2 + carry;
            carry = sum/10;
            cur.next = new ListNode(sum%10);
            cur = cur.next;

            if(list1 != null)   list1 = list1.next;
            if(list2 != null)   list2 = list2.next;
        }

        return res.next;
    }
}

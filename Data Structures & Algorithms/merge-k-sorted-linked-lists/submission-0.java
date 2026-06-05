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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                pq.add(lists[i]);
            }
        }
        ListNode res = new ListNode();
        ListNode tmp = res;
        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            tmp.next = curr;
            if(curr.next != null){
                pq.add(curr.next);
            }
            tmp = tmp.next;
        }
        return res.next;
        
    }
}

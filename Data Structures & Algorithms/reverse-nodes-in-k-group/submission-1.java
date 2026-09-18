class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupTail = dummy;
        ListNode curr = head;

        while (curr != null) {
            // Find kth node
            ListNode kth = curr;
            for (int i = 1; i < k && kth != null; i++) {
                kth = kth.next;
            }

            if (kth == null) {
                break; // less than k nodes left
            }

            ListNode nextGroupHead = kth.next;

            // Detach group
            kth.next = null;

            // Reverse group
            ListNode newHead = reverse(curr);

            // Connect
            prevGroupTail.next = newHead;
            curr.next = nextGroupHead;

            // Move pointers
            prevGroupTail = curr;
            curr = nextGroupHead;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
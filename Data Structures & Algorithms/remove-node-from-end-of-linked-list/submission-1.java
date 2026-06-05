class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode tmp = head;

        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }

        if (n == len) {
            return head.next;
        }

        tmp = head;
        for (int i = 1; i < len - n; i++) {
            tmp = tmp.next;
        }

        tmp.next = tmp.next.next;
        return head;
    }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        // Dummy helps when left = 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // prev = node just before the reversing part
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // curr stays fixed
        ListNode curr = prev.next;

        // Move curr.next to prev.next
        for (int i = 0; i < right - left; i++) {

            // This is the node we want to move
            ListNode toMove = curr.next;

            // Remove toMove from its current position
            curr.next = toMove.next;

            // Put toMove before curr
            toMove.next = prev.next;

            // Connect prev to toMove
            prev.next = toMove;
        }

        return dummy.next;
    }
}
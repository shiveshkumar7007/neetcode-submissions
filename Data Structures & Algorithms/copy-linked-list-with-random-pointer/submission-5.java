// O(N) time and constant space

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        // stpe 1 create the copy node no random as of now
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);

            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }

        // step 2 marking the random pointer
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // step 3 seperate the original and copy
        cur = head;
        Node copyHead = cur.next;
        while (cur != null) {
            Node copy = cur.next;

            cur.next = copy.next;
            if (copy.next != null) {
                copy.next = cur.next.next;
            }
            cur = cur.next;
        }

        return copyHead;
    }
}

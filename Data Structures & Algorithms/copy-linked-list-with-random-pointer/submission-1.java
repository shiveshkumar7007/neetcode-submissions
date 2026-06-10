class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node curr = head;
        while(curr != null){
            Node temp = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = temp;
            curr = temp;
        }
        curr = head;

        while(curr != null){
            if(curr.next != null){
                curr.next.random = (curr.random != null) ? curr.random.next : null;
            }
            curr = curr.next.next;
        }

        Node org = head, copy = head.next;
        Node temp = copy;

        while(org != null){
            org.next = org.next.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            org = org.next;
            copy = copy.next;
        }

        return temp;
    }
}
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
// o(n2) time solution
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }

        Node curr = head;
        Node newHead = new Node(curr.val);
        Node newCurr = newHead;
        curr = curr.next;
        while(curr != null){
            newCurr.next = new Node(curr.val);
            newCurr = newCurr.next;
            curr = curr.next;
        }


        curr = head;
        newCurr = newHead;


        while(curr != null){
            if(curr.random != null){
                Node tmp = head;
                Node randomCopy = newHead;

                while(tmp != curr.random){
                    tmp = tmp.next;
                    randomCopy = randomCopy.next;
                }

                newCurr.random = randomCopy;
            }

            curr = curr.next;
            newCurr = newCurr.next;
        }

        return newHead;
    }
}

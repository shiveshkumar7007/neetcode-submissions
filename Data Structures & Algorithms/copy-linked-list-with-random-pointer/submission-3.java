// O(N) O(N)

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }

        Map<Node, Node> map = new HashMap<>();

        Node cur = head;
        while(cur != null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while(cur != null){
            Node copy = map.get(cur);

            copy.next = map.get(cur.next);
            copy.random = map.get(cur.random);

            cur = cur.next;
        }

        return map.get(head);


    }
}

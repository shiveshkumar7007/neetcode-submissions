class MyHashSet {
    class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
        }
    }

    Node[] buckets;

    public MyHashSet() {
        buckets = new Node[10000];
    }

    public void add(int key) {
        int index = key % buckets.length;

        Node curr = buckets[index];

        // Check if key already exists
        while (curr != null) {
            if (curr.key == key) {
                return;
            }
            curr = curr.next;
        }

        // Add new key at beginning
        Node node = new Node(key);
        node.next = buckets[index];
        buckets[index] = node;
    }

    public void remove(int key) {
        int index = key % buckets.length;

        Node curr = buckets[index];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {

                // Removing first node
                if (prev == null) {
                    buckets[index] = curr.next;
                } 
                // Removing middle/last node
                else {
                    prev.next = curr.next;
                }

                return;
            }

            prev = curr;
            curr = curr.next;
        }
    }

    public boolean contains(int key) {
        int index = key % buckets.length;
        Node curr = buckets[index];

        while (curr != null) {
            if (curr.key == key) {
                return true;
            }
            curr = curr.next;
        }

        return false;
    }
}
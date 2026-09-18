class Node{
    int key;
    int value;
    Node next;
    Node prev;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}


class LRUCache {
    Map<Integer, Node> map;
    int cap;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        insert(node);

        return node.value;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
            map.remove(key);
            
        }

        Node node = new Node(key, value);
        map.put(key, node);

        insert(node);
        if(map.size() > cap){
            Node lru = tail.prev;

            remove(lru);
            map.remove(lru.key);
        }
        
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node node){
        node.next = head.next;
        node.prev = head;

        node.next.prev = node;
        node.prev.next = node;
    }
}

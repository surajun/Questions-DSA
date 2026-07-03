import java.util.HashMap;

class LRUCache {

    // Doubly Linked List Node
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> cache;

    // Dummy nodes
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        cache = new HashMap<>();

        // Create dummy nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);

        // Connect dummy nodes
        head.next = tail;
        tail.prev = head;
    }

    // Add before tail (MRU)
    private void addNode(Node node) {

        Node previous = tail.prev;

        previous.next = node;
        node.prev = previous;

        node.next = tail;
        tail.prev = node;
    }

    // Remove node
    private void removeNode(Node node) {

        Node previous = node.prev;
        Node nextNode = node.next;

        previous.next = nextNode;
        nextNode.prev = previous;
    }

    // Move to MRU
    private void moveToTail(Node node) {

        removeNode(node);
        addNode(node);
    }

    public int get(int key) {

        // Key not found
        if (!cache.containsKey(key))
            return -1;

        Node node = cache.get(key);

        // Update recent use
        moveToTail(node);

        return node.value;
    }

    public void put(int key, int value) {

        // Key already exists
        if (cache.containsKey(key)) {

            Node node = cache.get(key);

            // Update value
            node.value = value;

            // Move to MRU
            moveToTail(node);

            return;
        }

        // Create new node
        Node newNode = new Node(key, value);

        // Add to cache
        cache.put(key, newNode);

        // Add to list
        addNode(newNode);

        // Remove LRU
        if (cache.size() > capacity) {

            Node leastRecentlyUsed = head.next;

            removeNode(leastRecentlyUsed);

            cache.remove(leastRecentlyUsed.key);
        }
    }
}


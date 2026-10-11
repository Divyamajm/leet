class MyLinkedList {
    class Node {
        int val;
        Node next;
        Node prev;
        public Node(int val) {
            this.val = val;
        }
    }

    private int size;
    private Node head; // Dummy head
    private Node tail; // Dummy tail

    public MyLinkedList() {
        size = 0;
        head = new Node(0);
        tail = new Node(0);
        // Connect the dummy head and tail to each other
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        
        // Optimize: choose the fastest path (from head or from tail)
        Node curr = head;
        if (index + 1 < size - index) {
            for (int i = 0; i <= index; i++) {
                curr = curr.next;
            }
        } else {
            curr = tail;
            for (int i = 0; i < size - index; i++) {
                curr = curr.prev;
            }
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        // If index is greater than the length, do not insert
        if (index > size) {
            return;
        }
        // If index is negative, insert at head
        if (index < 0) {
            index = 0;
        }
        
        // Find predecessor and successor of the new node
        Node pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        Node succ = pred.next;
        
        // Wire in the new node
        Node newNode = new Node(val);
        newNode.prev = pred;
        newNode.next = succ;
        
        pred.next = newNode;
        succ.prev = newNode;
        
        size++;
    }
    
    public void deleteAtIndex(int index) {
        // If index is invalid, do nothing
        if (index < 0 || index >= size) {
            return;
        }
        
        // Find predecessor of the node to be deleted
        Node pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        
        // Find successor
        Node succ = pred.next.next;
        
        // Disconnect the deleted node
        pred.next = succ;
        succ.prev = pred;
        
        size--;
    }
}
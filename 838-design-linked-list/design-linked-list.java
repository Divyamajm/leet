class MyLinkedList {
    class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private int size; // Tracking size makes edge cases much easier

    public MyLinkedList() {
        head = null;
        size = 0;
    }
    
    public int get(int index) {
        // Return -1 if index is invalid
        if (index < 0 || index >= size) {
            return -1;
        }
        
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }
        
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val);
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        // If index is greater than the length, the node will not be inserted.
        if (index > size) {
            return;
        }
        // If index is negative or 0, insert at head
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        
        Node temp = head;
        // Stop exactly one node BEFORE the insertion point
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        
        Node newNode = new Node(val);
        newNode.next = temp.next; // Connect new node to the rest of the list
        temp.next = newNode;      // Connect previous node to the new node
        size++;
    }
    
    public void deleteAtIndex(int index) {
        // If index is invalid, do nothing
        if (index < 0 || index >= size) {
            return;
        }
        
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        
        Node temp = head;
        // Stop exactly one node BEFORE the deletion point
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        
        // Skip the deleted node
        temp.next = temp.next.next;
        size--;
    }
}
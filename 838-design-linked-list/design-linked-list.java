class MyLinkedList {
    
    class Node {
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }
    
    private Node head;

    public MyLinkedList() {
        head = null;
    }
    
    public int get(int index) {
        if (index < 0) return -1; // Handle negative index
        
        Node temp = head;
        while(temp != null && index > 0){
            temp = temp.next;
            index--;
        }
        
        if (temp == null) return -1; // Handle out of bounds index
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
    }
    
    public void addAtTail(int val) {
        if (head == null) { // Handle empty list
            addAtHead(val);
            return;
        }
        
        Node node = new Node(val);
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }
    
    public void addAtIndex(int index, int val) {
        if (index <= 0) { // Handle inserting at the beginning
            addAtHead(val);
            return;
        }
        
        Node node = new Node(val);
        Node temp = head;
        while(temp != null && index > 1){
            temp = temp.next;
            index--;
        }
        
        if (temp != null) { // Only link if index is valid
            node.next = temp.next;
            temp.next = node;
        }
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || head == null) return; // Handle negative index or empty list
        
        if (index == 0) { // Handle deleting the head
            head = head.next;
            return;
        }
        
        Node temp = head;
        Node prev = null;
        while(temp != null && index > 0){
            prev = temp;
            temp = temp.next;
            index--;
        }
        
        if (temp != null && prev != null) { // Only delete if index is valid
            prev.next = temp.next;
        }
    }
}
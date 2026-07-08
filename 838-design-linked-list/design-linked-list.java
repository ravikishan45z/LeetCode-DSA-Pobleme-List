class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class MyLinkedList {

    ListNode head;
    ListNode tail;
    int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.val;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);

        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }

        size++;
    }

    public void addAtTail(int val) {
        if (tail == null) {
            addAtHead(val);
            return;
        }

        ListNode node = new ListNode(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }

        ListNode temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        ListNode node = new ListNode(val);
        node.next = temp.next;
        temp.next = node;

        size++;
    }

    public void deleteAtHead() {
        if (head == null) {
            return;
        }

        head = head.next;

        if (head == null) {
            tail = null;
        }

        size--;
    }

    public void deleteAtTail() {
        if (tail == null) {
            return;
        }

        if (head == tail) {
            head = tail = null;
            size--;
            return;
        }

        ListNode temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }

        temp.next = null;
        tail = temp;

        size--;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        if (index == 0) {
            deleteAtHead();
            return;
        }

        if (index == size - 1) {
            deleteAtTail();
            return;
        }

        ListNode temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
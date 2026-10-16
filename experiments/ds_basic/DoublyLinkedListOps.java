import java.util.NoSuchElementException;

class ListNode {
    int value;
    ListNode prev, next;

    ListNode(int value) {
        this.value = value;
        this.prev = this.next = null;
    }
}

class DoublyLinkedList {
    ListNode head, tail;

    DoublyLinkedList() {
        this.head = this.tail = null;
    }

    void addFirst(int value) {
        ListNode node = new ListNode(value);

        if (head == null) {
            // Empty list: the new node is both the first and last node.
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    void addLast(int value) {
        ListNode node = new ListNode(value);

        if (tail == null) {
            head = tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
    }

    int removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }

        ListNode removed = head;
        head = removed.next;

        if (head == null) {
            // The list had only one node and is now empty.
            tail = null;
        } else {
            head.prev = null;
        }

        removed.next = null;
        return removed.value;
    }

    int removeLast() {
        if (tail == null) {
            throw new NoSuchElementException("List is empty");
        }

        ListNode removed = tail;
        tail = removed.prev;

        if (tail == null) {
            // The list had only one node and is now empty.
            head = null;
        } else {
            tail.next = null;
        }

        removed.prev = null;
        return removed.value;
    }

    void printForward() {
        for (ListNode current = head; current != null; current = current.next) {
            System.out.print(current.value + " ");
        }
        System.out.println();
    }

    void printBackward() {
        for (ListNode current = tail; current != null; current = current.prev) {
            System.out.print(current.value + " ");
        }
        System.out.println();
    }
}

public class DoublyLinkedListOps {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.addLast(20);
        list.addFirst(10);
        list.addLast(30);

        list.printForward();   // 10 20 30
        list.printBackward();  // 30 20 10

        System.out.println(list.removeFirst()); // 10
        System.out.println(list.removeLast());  // 30

        list.printForward();   // 20
    }
}

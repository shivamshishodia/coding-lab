class ListNode<T> {
    T value;
    ListNode<T> next;

    ListNode(T value) {
        this.value = value;
        this.next = null;
    }
}

public class LinkedListOps {

    public static <T> void traverse(ListNode<T> head) {
        ListNode<T> current = head;

        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(10);
        head.next = new ListNode<>(20);
        head.next.next = new ListNode<>(30);

        traverse(head);
    }
}

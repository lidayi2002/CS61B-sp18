public class LinkedListDeque<T> {
    private class Node {
        private Node prev;
        private T item;
        private Node next;

        private Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private int size;
    private Node sentinel = new Node(null, null, null);


    public LinkedListDeque(T x) {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        sentinel.next = new Node(sentinel, x, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    public LinkedListDeque() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;

    }

    public void addFirst(T item) {
        Node a = new Node(sentinel, item, sentinel.next);
        sentinel.next.prev = a;
        sentinel.next = a;

        size += 1;
    }

    public void addLast(T item) {
        Node a = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.next = a;
        sentinel.prev = a;
        size += 1;

    }

    public boolean isEmpty() {
        return sentinel.next.item == null;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentinel;
        while (p.next != sentinel) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }

    }

    public T removeFirst() {

        T value = sentinel.next.item;
        if (value == null) {
            return null;
        }
        sentinel.next = sentinel.next.next;
        sentinel.next.next.prev = sentinel;
        size -= 1;
        return value;
    }

    public T removeLast() {
        T value = sentinel.prev.item;
        if (value == null) {
            return null;
        }
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.prev.next = sentinel;
        size -= 1;
        return value;
    }

    public T get(int index) {
        Node p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
            if (p.equals(sentinel)) {
                break;
            }
        }
        return p.item;

    }
    private T getHelper(Node n, int count) {
        if (count == 0) {
            return n.item;
        } else if (n.next.item == null) {
            return null;
        } else {
            return getHelper(n.next, count - 1);
        }

    }
    public T getRecursive(int index) {
        return getHelper(sentinel.next, index);
    }

}

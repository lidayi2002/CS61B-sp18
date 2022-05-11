public class LinkedListDeque<Type> {
    private class Node {
        private Node prev;
        private Type item;
        private Node next;

        private Node(Node p, Type i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private int size;
    private Node sentinel = new Node(null, null, null);


    public LinkedListDeque(Type x) {
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

    public void addFirst(Type item) {

        sentinel.next = new Node(sentinel, item, sentinel.next);

        size += 1;
    }

    public void addLast(Type item) {
        sentinel.prev = new Node(sentinel.prev, item, sentinel);
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

    public Type removeFirst() {

        Type value = sentinel.next.item;
        if (sentinel.next.item == null) {
            return null;
        }
        sentinel.next = sentinel.next.next;
        sentinel.next.next.prev = sentinel;
        size -= 1;
        return value;
    }

    public Type removeLast() {
        Type value = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.prev.next = sentinel;
        size -= 1;
        return value;
    }

    public Type get(int index) {
        Node p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
            if (p.equals(sentinel)) {
                break;
            }
        }
        return p.item;

    }
    private Type getHelper(Node n, int count) {
        if (count == 0) {
            return n.item;
        } else if (n.next.item == null) {
            return null;
        } else {
            return getHelper(n.next, count - 1);
        }

    }
    public Type getRecursive(int index) {
        return getHelper(sentinel.next, index);
    }

}

public class ArrayDeque<T> {
    private int nextFirst;
    private int nextLast;
    private T[] items;

    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 3;
        nextLast = 4;
        size = 0;

    }
    /** in order to save time I decided to start my Array in the middle.
     *  hope it works.
     *  it seems the rate of usage 0.25 was prepared for this means.
     *  it's wrong. the implement will not use above means*/


    public void addFirst(T item) {
        if (size == items.length) {
            T[] a = (T[]) new Object[items.length * 2];

            System.arraycopy(items, nextFirst + 1, a, 0, items.length - nextFirst - 1);
            System.arraycopy(items, 0, a, items.length - nextFirst - 1, nextFirst + 1);
            items = a;
            items[items.length - 1] = item;
            nextFirst = items.length - 2;
            nextLast = items.length / 2;
        } else if (nextFirst == 0) {
            items[nextFirst] = item;
            nextFirst = items.length - 1;
        } else {
            items[nextFirst] = item;
            nextFirst -= 1;
        }
        size += 1;

    }


    public void addLast(T item) {
        if (size == items.length) {
            T[] a = (T[]) new Object[items.length * 2];

            System.arraycopy(items, nextFirst + 1, a, 0, items.length - nextFirst - 1);
            System.arraycopy(items, 0, a, items.length - nextFirst - 1, nextFirst + 1);
            items = a;
            items[items.length / 2] = item;
            nextFirst = items.length - 1;
            nextLast = items.length / 2 + 1;
        } else if (nextLast == items.length - 1) {
            items[nextLast] = item;
            nextLast = 0;
        } else {
            items[nextLast] = item;
            nextLast += 1;
        }
        size += 1;

    }

    public boolean isEmpty() {
        return size == 0;

    }

    public int size() {
        return size;

    }

    public void printDeque() {
        if (nextFirst < nextLast) {
            for (int i = nextFirst + 1; i < nextLast; i++) {
                System.out.print(items[i] + " ");
            }
        } else {
            for (int i = nextFirst + 1; i < items.length; i++) {
                System.out.print(items[items.length - nextFirst + i] + " ");
            }
            for (int i = 0; i < nextLast; i++) {
                System.out.print(items[i] + " ");
            }
        }
    }
    /** check if array needs to be resized. if true do it. */
    private void resize() {
        if (size < items.length / 4.0 && items.length >= 16) {
            T[] a = (T[]) new Object[items.length / 2];
            if (size > items.length - nextFirst - 1) {
                System.arraycopy(items, nextFirst + 1, a, 0, items.length - nextFirst - 1);
                System.arraycopy(items, 0, a, items.length - nextFirst - 1,
                        size - items.length + 1 + nextFirst);

            } else {
                System.arraycopy(items, nextFirst + 1, a, 0, size);

            }
            items = a;
            nextFirst = items.length - 1;
            nextLast = size;
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            T value;
            if (nextFirst == items.length - 1) {
                value = items[0];
                nextFirst = 0;
            } else {
                value = items[nextFirst + 1];
                nextFirst += 1;
            }
            size -= 1;
            resize();

            return value;
        }

    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            T value;
            if (nextLast == 0) {
                value = items[items.length - 1];
                nextLast = items.length - 1;
            } else {
                value = items[nextLast - 1];
                nextLast = nextLast - 1;
            }
            size -= 1;
            resize();

            return value;
        }

    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        if (nextFirst == items.length - 1) {
            return items[index];
        } else if (nextFirst + 1 + index > items.length - 1) {
            return items[index - (items.length - nextFirst - 1)];

        }
        return items[nextFirst + 1 + index];

    }

}

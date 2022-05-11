
public class ArrayDeque<T> {
    private int frontSize;
    private int backSize;
    private T[] items;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        frontSize = 0;
        backSize = 0;
    }
    /** in order to save time I decided to start my Array in the middle.
     *  hope it works.
     *  it seems the rate of usage 0.25 was prepared for this means. */

    public void addFirst(T item) {
        if (items.length / 2 == frontSize) {
            T[] a = (T[]) new Object[items.length * 2];
            System.arraycopy(items, 0, a, frontSize, frontSize + backSize);
            items = a;

        }
        frontSize += 1;
        items[items.length / 2 - frontSize] = item;

    }


    public void addLast(T item) {
        if (backSize == items.length / 2) {
            T[] a = (T[]) new Object[items.length * 2];
            System.arraycopy(items, items.length / 2 - frontSize, a,
                    items.length - frontSize, frontSize + backSize);
            items = a;

        }

        items[backSize + items.length / 2] = item;
        backSize += 1;

    }

    public boolean isEmpty() {
        return frontSize + backSize == 0;

    }

    public int size() {
        return frontSize + backSize;

    }

    public void printDeque() {
        for (int i = 0; i < (frontSize + backSize); i++) {
            System.out.print(items[items.length - frontSize + i] + " ");
        }

    }
    /** check if array needs to be resized. if true do it. */
    public void resize() {
        if ((frontSize + backSize) < items.length / 4.0) {
            T[] a = (T[]) new Object[items.length / 2];
            System.arraycopy(items, items.length / 4, a, 0, items.length / 2);
            items = a;
        }
    }

    public T removeFirst() {
        T value = items[items.length / 2 - frontSize];
        frontSize -= 1;
        resize();
        return value;

    }

    public T removeLast() {
        T value = items[items.length + backSize];
        backSize -= 1;
        resize();
        return value;

    }

    public T get(int index) {
        return items[items.length / 2 - frontSize + index];

    }

}

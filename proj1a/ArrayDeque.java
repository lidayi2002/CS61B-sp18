import org.w3c.dom.Node;

public class ArrayDeque<Type> {
    private int frontSize;
    private int backSize;
    private Type[] items;

    public ArrayDeque() {
        items = (Type[]) new Object[8];
        frontSize = 0;
        backSize = 0;
    }
    /** in order to save time I decided to start my Array in the middle.
     *  hope it works.
     *  it seems the rate of usage 0.25 was prepared for this means. */

    public void addFirst(Type item) {
        if (items.length / 2 == frontSize) {
            Type[] a = (Type[]) new Object[items.length * 2];
            System.arraycopy(items, 0, a, frontSize, frontSize + backSize);
            items = a;

        }
        frontSize += 1;
        items[items.length / 2 - frontSize] = item;

    }


    public void addLast(Type item) {
        if (backSize == items.length / 2) {
            Type[] a = (Type[]) new Object[items.length * 2];
            System.arraycopy(items, items.length / 2 - frontSize, a, items.length - frontSize, frontSize + backSize);
            items = a;

        }

        items[backSize + items.length] = item;
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
            Type[] a = (Type[]) new Object[items.length / 2];
            System.arraycopy(items, items.length / 4, a, 0, items.length / 2);
            items = a;
        }
    }

    public Type removeFirst() {
        Type value = items[items.length / 2 - frontSize];
        frontSize -= 1;
        resize();
        return value;

    }

    public Type removeLast() {
        Type value = items[items.length + backSize];
        backSize -= 1;
        resize();
        return value;

    }

    public Type get(int index) {
        return items[items.length / 2 - frontSize + index];

    }

}

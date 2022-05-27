package synthesizer;

import org.junit.Test;

public class TestBufferIterator {
    @Test
    public void test1() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        for (int i = 0; i < 10; i++) {
            arb.enqueue(i);
        }
        for (int i : arb) {
            System.out.println(i);
        }
    }
}

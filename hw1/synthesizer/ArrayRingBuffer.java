package synthesizer;
import java.util.Iterator;
public class ArrayRingBuffer <T> extends AbstractBoundedQueue<T>{
     private int first;
     private int last;
     private T[] a;

     public ArrayRingBuffer(int capacity){
         a = (T[]) new Object[capacity];
         this.capacity = capacity;
         first = last = fillCount = 0;
     }

    @Override
    public void enqueue(T x) {
        if(isFull()){
            throw new RuntimeException("Ring buffer overflow");
        }
        a[last++] = x;
        if (last == capacity) {
            last = 0;
        }
        fillCount++;
    }

    @Override
    public T dequeue() {
        if(isEmpty()){
            throw new RuntimeException("Ring buffer underflow");
        }
        T res = a[first++];
        if (first == capacity) {
            first = 0;
        }
        fillCount--;
        return res;

    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        return a[first];
    }

    @Override
    public Iterator<T> iterator() {
        return new BufferIterator();
    }

    private class BufferIterator implements Iterator<T> {
        private int pos;
        private int num;

        BufferIterator() {
            pos = first;
            num = 0;
        }

        @Override
        public boolean hasNext() {
            return num < fillCount;
        }

        @Override
        public T next() {
            T returnItem = a[pos];
            pos++;
            if (pos == capacity) {
                pos = 0;
            }
            num++;
            return returnItem;
        }

    }
}

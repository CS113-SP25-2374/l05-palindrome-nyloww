import java.util.*;

public class CircularArrayQueue<E> implements Queue<E> {
    private final E[] data;
    private int front;
    private int rear;
    private int size;
    private final int capacity;

    @SuppressWarnings("unchecked")
    public CircularArrayQueue(int capacity) {
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    @Override
    public boolean add(E e) {
        if (size == capacity) {
            throw new IllegalStateException("Queue is full");
        }
        return offer(e);
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(E e) {
        if (size == capacity) {
            return false;
        }
        data[rear] = e;
        rear = (rear + 1) % capacity;
        size++;
        return true;
    }

    @Override
    public E peek() {
        if (size == 0) {
            return null;
        }
        return data[front];
    }

    @Override
    public E element() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return data[front];
    }

    @Override
    public E poll() {
        if (size == 0) {
            return null;
        }
        E result =  data[front];
        front = (front + 1) % capacity;
        size--;
        return result;
    }

    @Override
    public E remove() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        return poll();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


}

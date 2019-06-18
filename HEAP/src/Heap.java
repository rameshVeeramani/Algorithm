import java.lang.reflect.Array;

public abstract class Heap<T extends Comparable> {

    private static int MAX_SIZE = 400;
    private T[] array;

    public Heap(Class<T> clazz) {

        this(clazz, MAX_SIZE);
    }

    public Heap(Class<T> clazz, int size) {
        array = (T[]) Array.newInstance(clazz, size);
    }

    public int getLeftChildIndex(int parentIndex) {
        int leftChildIndex = 2 * parentIndex + 1;
        if (leftChildIndex >= array.length)
            return -1;
        return leftChildIndex;
    }

    public int getRighChildIndex(int parentIndex) {
        int rightChildIndex = 2 * parentIndex + 2;
        if (rightChildIndex >= array.length)
            return -1;

        return rightChildIndex;
    }

    public int getParentIndex(int childIndex) {

        if (childIndex < 0 || childIndex >= array.length)
            return -1;

        int parentIndex = (childIndex - 1) / 2;
        if (parentIndex <= 0)
            return -1;
        return parentIndex;
    }

    public boolean isEmpty() {
        return getCount() == 0;
    }

    public boolean isFull() {
        return getCount() >= MAX_SIZE;

    }

    public int getCount() {
        return array.length;
    }

    public void swap(int index1, int index2) {

        T temp = array[index1];
        array[index1] = array[index2];
        array[index1] = temp;
    }

    public T getElementAtIndex(int index) {
        if (index <= 0 || index >= array.length)
            return null;
        return array[index];
    }
}


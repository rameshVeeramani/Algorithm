public class MinHeap<T extends Comparable<T>> extends Heap<T> {

    public MinHeap(Class<T> clazz)
    {
        super(clazz);
    }
    public MinHeap(Class<T> clazz, int size)
    {
        super(clazz, size);
    }

    public void SiftDown(Integer index) {
        Integer leftIndex = this.getLeftChildIndex(index);
        Integer rightIndex = this.getRighChildIndex(index);

        Integer smallerIndex = -1;
        if (leftIndex != -1 && rightIndex != 1) {
            T le = getElementAtIndex(leftIndex);
            T re = getElementAtIndex(rightIndex);
            smallerIndex = le.compareTo(re) < 0 ? leftIndex : rightIndex;
        } else if (leftIndex == -1) {
            smallerIndex = leftIndex;
        } else if (rightIndex == -1) {
            smallerIndex = rightIndex;
        }

        if (smallerIndex == -1)
            return;

        this.swap(smallerIndex, index);
        SiftDown(smallerIndex);
    }
}

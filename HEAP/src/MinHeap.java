public class MinHeap<T extends Comparable<T>> extends Heap<T> {

    public MinHeap(Class<T> clazz) {
        super(clazz);
    }

    public MinHeap(Class<T> clazz, int size) {
        super(clazz, size);
    }

    public void SiftDown(Integer index) {
        Integer leftIndex = this.getLeftChildIndex(index);
        Integer rightIndex = this.getRighChildIndex(index);
        Integer smallerIndex = -1;
        //base condition
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
    //Sift up is easy because you compare with only the parent not left and right as in sift down
    public void Siftup(int index) {
        Integer parentIndex = getParentIndex(index);
        //base condition
        if (parentIndex == -1)
            return;
        if (getElementAtIndex(parentIndex).compareTo(getElementAtIndex(index)) < 0) {
            this.swap(parentIndex, index);
        }
        Siftup(parentIndex);
    }
    public void Insert(T value ){
        // check for heap size
       this.array[count] = value;
       Siftup(count);
       count++;
    }


    /* Remove the highest priority that is the zeroth element in the heap
    as its the minimum eleement is the zeroth element
    We copy the last element to the zeroth element of the array  ...
    Then sift down the last sift down.
    * */

    public T Remove(){
        T element = this.array[0];
        this.array[0] = this.array[count-1];
        count--;
        Siftup(0);
        return element;
    }

    public T RetrieveHighestPriortyWithoutRemoving() throws Exception {
        if (count == 0) {
            throw new Exception("No more record ");
        }
        return array[0];
    }

}

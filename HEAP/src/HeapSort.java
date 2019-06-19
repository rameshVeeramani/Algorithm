public class HeapSort <T extends Comparable> extends Heap<T>
{
    public HeapSort(Class clazz) {
        super(clazz);
    }
    public HeapSort(Class clazz, int size) {
        super(clazz, size);
    }
    public  int getLeftChildIndex(int index, int endIndex){
        int ret = 2 * index + 1;
        if (ret > endIndex)
            return -1;
        return  ret;
    }
    public  int getRightChildIndex(int index, int endIndex){
        int ret = 2 * index + 2;
        if (ret > endIndex)
            return -1;
        return  ret;
    }
    public int getParentIndex(int index, int endIndex) {
        int ret = (index - 1) / 2;
        if (ret < 0 || index > endIndex)
            return -1;
        return ret;
    }
    public void swapAtIndices(int fromIndex, int toIndex){
        T tempValue = array[fromIndex];
        array[fromIndex] = array[toIndex];
        array[toIndex]= tempValue;
    }
    public void swiftDown(int nodeIndex,int endIndex) {

        int leftIndex = getLeftChildIndex(nodeIndex, endIndex);
        int righIndex = getRightChildIndex(nodeIndex, endIndex);

        if (leftIndex != -1 && array[leftIndex].compareTo(array[nodeIndex]) > 0) {
            swapAtIndices(nodeIndex, leftIndex);
            swiftDown(leftIndex, endIndex);
        }
        if (righIndex != -1 && array[righIndex].compareTo(array[nodeIndex]) > 0) {
            swapAtIndices(nodeIndex, righIndex);
            swiftDown(righIndex, endIndex);
        }
    }
    public void Heapify(int endIndex){
        int index = getParentIndex(endIndex,endIndex);
        if (index >=0 ){
            swiftDown(index,endIndex);
            index--;
        }
    }

    public void HeapSort() {
        Heapify(array.length - 1);
        int endIndex = array.length - 1;

        while (endIndex > 0) {
            swapAtIndices(0, endIndex);
            endIndex--;
            swiftDown(0, endIndex);
        }
    }


}

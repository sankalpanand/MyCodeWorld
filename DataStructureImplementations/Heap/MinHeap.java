package DataStructureImplementations.Heap;

public class MinHeap {
    private int[] heapArray;
    private int currentSize;
    private int maxsize;

    private MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.currentSize = 0;
        heapArray = new int[this.maxsize];
        // heapArray[0] = Integer.MIN_VALUE;
    }

    private int getParent(int pos) {
        return (pos - 1) / 2;
    }

    private int getLeftChild(int pos) {
        return (2 * pos + 1);
    }

    private int getRightChild(int pos) {
        return (2 * pos) + 2;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = heapArray[fpos];
        heapArray[fpos] = heapArray[spos];
        heapArray[spos] = tmp;
    }

    private void insertKey(int k) {

        // Check overflow
        if (currentSize == maxsize) {
            System.out.println("Overflow: Could not insertKey");
            return;
        }

        // First insert the new key at the end. Increase the size to find the last getCellIndex.
        currentSize++;
        int i = currentSize - 1;

        // Then store the element at the new getCellIndex
        heapArray[i] = k;

        // Fix the min heap property if it is violated
        while (i != 0 && heapArray[getParent(i)] > heapArray[i]) {
            swap(i, getParent(i));

            // Child and parent have been swapped. Now go to the parent.
            i = getParent(i);
        }
    }

    // Decreases value of key at getCellIndex 'i' to new_val.  It is assumed that
    // new_val is smaller than harr[i].
    private void decreaseKey(int i, int new_val) {
        heapArray[i] = new_val;
        while (i != 0 && heapArray[getParent(i)] > heapArray[i]) {
            swap(i, getParent(i));
            i = getParent(i);
        }
    }

    private int extractMin() {
        if (currentSize <= 0)
            return Integer.MAX_VALUE;


        if (currentSize == 1) {
            currentSize--;
            return heapArray[0];
        }

        // Store the minimum value
        int root = heapArray[0];

        // Step 1: Swap the element to be deleted with the last element.
        heapArray[0] = heapArray[currentSize - 1];

        // Step 2: You delete the element at the last getCellIndex.
        currentSize--;

        // Step 3: Now, you check if the element to be deleted becomes smaller than its children?
        // If no, you're good. If yes, then you need to swap this parent with the larger of the two children.
        heapify(0);

        return root;
    }

    // This function deletes key at getCellIndex i.
    // It first reduced value to minus infinite, then calls extractMin()
    public void deleteKey(int i) {
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    // A recursive method to heapify a subtree with the root at given getCellIndex
    // This method assumes that the subtrees are already heapified
    private void heapify(int i) {
        int leftChildIndex = getLeftChild(i);
        int rightChildIndex = getRightChild(i);
        int smallest = i;

        // Check if the left child is smaller than the parent, if yes, record the smallest
        if (leftChildIndex < currentSize && heapArray[leftChildIndex] < heapArray[i])
            smallest = leftChildIndex;

        // Check if the right child is smaller than the (parent || the smallest), if yes, record the smallest
        if (rightChildIndex < currentSize && heapArray[rightChildIndex] < heapArray[smallest])
            smallest = rightChildIndex;

        // If smallest getCellIndex isn't the parent itself, swap the parent and smallest getCellIndex.
        if (smallest != i) {
            swap(i, smallest);

            // Root level is done but this swap might have voilated the heap property for the sub trees.
            // So, apply heapify() at the smallest node now
            heapify(smallest);
        }
    }

    public void print() {
        for (int i = 0; i < currentSize / 2; i++) {
            System.out.print(" PARENT : " + heapArray[i] + " LEFT CHILD : " + heapArray[2 * i + 1]
                    + " RIGHT CHILD :" + heapArray[2 * i + 2]);
            System.out.println();
        }
    }

    public static void main(String[] arg) {

        MinHeap minHeap = new MinHeap(15);


        minHeap.insertKey(5);
        minHeap.print();

        minHeap.insertKey(3);
        minHeap.print();

        minHeap.insertKey(17);
        minHeap.print();

        minHeap.insertKey(10);
        minHeap.print();

        minHeap.insertKey(84);
        minHeap.print();

        minHeap.insertKey(19);
        minHeap.print();

        minHeap.insertKey(6);
        minHeap.print();

        minHeap.insertKey(22);
        minHeap.print();

        minHeap.insertKey(9);
        minHeap.print();

        System.out.println("The Min val is " + minHeap.extractMin());
    }
}
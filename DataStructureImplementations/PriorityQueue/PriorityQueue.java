package DataStructureImplementations.PriorityQueue;

public class PriorityQueue {
    private Item[] heapArray;
    private int heapSize, capacity;

    protected PriorityQueue(int capacity) {
        this.capacity = capacity + 1;
        heapArray = new Item[this.capacity];
        heapSize = 0;
    }

    private void clear() {
        heapArray = new Item[capacity];
        heapSize = 0;
    }


    public boolean isEmpty() {
        return heapSize == 0;
    }


    private boolean isFull() {
        return heapSize == capacity - 1;
    }


    public int size() {
        return heapSize;
    }


    public void insert(String item, int priority) {

        // Increase the size to find the last getCellIndex.
        Item newItem = new Item(item, priority);
        int endIndex = heapSize++;

        // Then store the element at the new getCellIndex
        heapArray[endIndex] = newItem;

        // Fix the max heap property if it is violated.
        // If the priority of new item is higher that the priority of its parent, it gotta move up.
        while (endIndex != 1 && newItem.priority > heapArray[endIndex / 2].priority) {
            heapArray[endIndex] = heapArray[endIndex / 2];
            endIndex /= 2;
        }

        heapArray[endIndex] = newItem;
    }

    public Item remove() {
        int parent, child;
        Item item, temp;
        if (isEmpty()) {
            System.out.println("Heap is empty");
            return null;
        }

        item = heapArray[1];
        temp = heapArray[heapSize--];

        parent = 1;
        child = 2;
        while (child <= heapSize) {
            if (child < heapSize && heapArray[child].priority < heapArray[child + 1].priority)
                child++;
            if (temp.priority >= heapArray[child].priority)
                break;

            heapArray[parent] = heapArray[child];
            parent = child;
            child *= 2;
        }
        heapArray[parent] = temp;

        return item;
    }
}

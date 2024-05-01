package DataStructureImplementations.PriorityQueue;

public class PriorityQueueTest
{
    public static void main(String[] args)
    {
        System.out.println("Priority Queue Test\n");
        int size = 10;

        System.out.println("Enter size of priority queue ");
        PriorityQueue pq = new PriorityQueue(size);

        pq.insert("1", 1);
        pq.insert("2", 1);
        pq.insert("3", 1);
        pq.insert("4", 1);
        pq.insert("5", 1);
        pq.insert("6", 1);
        System.out.println("Item removed: "+ pq.remove().item);

        pq.insert("9", 2);
        System.out.println("Item removed: "+ pq.remove().item);
        System.out.println("Item removed: "+ pq.remove().item);


        System.out.println("Size = "+ pq.size() );

    }
}

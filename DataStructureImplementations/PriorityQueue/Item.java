package DataStructureImplementations.PriorityQueue;

class Item
{
    String item;
    int priority;

    /** Constructor **/
    protected Item(String item, int priority)
    {
        this.item = item;
        this.priority = priority;
    }
    /** toString() **/
    public String toString()
    {
        return "item Name : "+ item +"\nPriority : "+ priority;
    }
}

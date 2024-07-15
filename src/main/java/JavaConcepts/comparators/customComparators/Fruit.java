package JavaConcepts.comparators.customComparators;

public class Fruit implements Comparable<Fruit>
{
    private String fruitName;
    private String fruitDesc;
    private int quantity;

    public Fruit(String fruitName, String fruitDesc, int quantity)
    {
        super();
        this.fruitName = fruitName;
        this.fruitDesc = fruitDesc;
        this.quantity = quantity;
    }

    public String getFruitName() {
        return fruitName;
    }
    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }
    public String getFruitDesc() {
        return fruitDesc;
    }
    public void setFruitDesc(String fruitDesc) {
        this.fruitDesc = fruitDesc;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int compareTo(Fruit compareFruit) {

        int compareQuantity = compareFruit.getQuantity();

        // ascending order
        // return this.quantity - compareQuantity;

        // descending order
        // return compareQuantity - this.quantity;

        // Ascending name
        // return this.fruitName.compareTo(((Fruit) compareFruit).getFruitName());

        // Descending name
//        return compareFruit.getFruitName().compareTo(this.fruitName);

        if(compareFruit.getFruitName().compareTo(this.fruitName) != 0) {
            return compareFruit.getFruitName().compareTo(this.fruitName);
        } else {
            return compareFruit.getQuantity().compareTo(this.getQuantity());
        }
    }

    @Override
    public String toString() {
        return fruitName + " - " + quantity;
    }
}

package JavaConcepts.comparators.customComparators;
import java.util.Arrays;

public class ExampleArraySort {

	public static void main(String[] args) {
		Fruit[] fruits = new Fruit[4];

		Fruit pineappale = new Fruit("Pineapple", "Pineapple description",70); 
		Fruit apple = new Fruit("Apple", "Apple description",100); 
		Fruit orange = new Fruit("Orange", "Orange description",80); 
		Fruit banana = new Fruit("Banana", "Banana description",90); 

		fruits[0]=pineappale;
		fruits[1]=apple;
		fruits[2]=orange;
		fruits[3]=banana;

		// Option 1 - Pass a comparator
//		Comparator<Fruit> comparator = new Comparator<>() {
//			@Override
//			public int compare(Fruit s1, Fruit s2) {
//
//				return s1.getFruitName().compareTo(s2.getFruitName());
//			}
//		};
//
//		Arrays.sort(fruits, comparator);

		// Option 2 - Make the class implement Comparable
		Arrays.sort(fruits);

//		int i=0;
//		for(Fruit temp: fruits){
//			System.out.println("fruits " + ++i + " : " + temp.getFruitName() +
//					", Quantity : " + temp.getQuantity());
//		}

        ExampleArraySort obj = new ExampleArraySort();

	}
}


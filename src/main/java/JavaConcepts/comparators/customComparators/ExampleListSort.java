package JavaConcepts.comparators.customComparators;
import java.util.*;

public class ExampleListSort {

	public static void main(String[] args) {
		List<Fruit> list = new ArrayList<>();

		list.add(new Fruit("Pineapple", "Pineapple description",70));
		list.add(new Fruit("Orange", "Orange description",80));
		list.add(new Fruit("Banana", "Banana description",90));
		list.add(new Fruit("Banana", "Banana description",92));
		list.add(new Fruit("Apple", "Apple description",100));

		// Option 1 - Pass a comparator
//		Comparator<Fruit> comparator = new Comparator<>() {
//			@Override
//			public int compare(Fruit s1, Fruit s2) {
//
//				return s1.getFruitName().compareTo(s2.getFruitName());
//			}
//		};

		// Two level sorting
//		Comparator<Fruit> comparator = new Comparator<>() {
//			@Override
//			public int compare(Fruit s1, Fruit s2) {
//
//				if(s1.getFruitName().compareTo(s2.getFruitName()) != 0) {
//					return s1.getFruitName().compareTo(s2.getFruitName());
//				} else {
//					return s1.getQuantity().compareTo(s2.getQuantity());
//				}
//			}
//		};
//
//		Arrays.sort(fruits, comparator);

		// Option 2 - Make the class implement Comparable
		Collections.sort(list);

//		int i=0;
//		for(Fruit temp: fruits){
//			System.out.println("fruits " + ++i + " : " + temp.getFruitName() +
//					", Quantity : " + temp.getQuantity());
//		}

		System.out.println();
	}
}


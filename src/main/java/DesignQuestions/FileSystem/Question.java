package FileSystem;

public class Question {

	public static void main(String[] args) 
	{
		// Step 1 - Create a root directory
		Directory root = new Directory("Food", null);
		
		// Step 2- Create two files to put on root
		File taco = new File("Taco", root, 4);
		File hamburger = new File("Hamburger", root, 9);
		
		// Step 3- Add these two files to root
		root.addEntry(taco);
		root.addEntry(hamburger);

		// Step 4- Create a new directory under root
		Directory healthy = new Directory("Healthy", root);

		// Step 5- Create a new directory under above directory
		Directory fruits = new Directory("Fruits", healthy);
		
		// Step 6- Create two files to above directory
		File apple = new File("Apple", fruits, 5);
		File banana = new File("Banana", fruits, 6);
		
		// Step 7- Add these two files to above directory
		fruits.addEntry(apple);
		fruits.addEntry(banana);

		// Step 8- Fruits directory to healthy directory
		healthy.addEntry(fruits);

		// Step 9- Do the same thing with Vegetables
		Directory veggies = new Directory("Veggies", healthy);
		File carrot = new File("Carrot", veggies, 6);
		File lettuce = new File("Lettuce", veggies, 7);
		File peas = new File("Peas", veggies, 4);
		veggies.addEntry(carrot);
		veggies.addEntry(lettuce);
		veggies.addEntry(peas);

		healthy.addEntry(veggies);

		root.addEntry(healthy);

		System.out.println(root.numberOfFiles());
		System.out.println(veggies.getFullPath());
	}

}

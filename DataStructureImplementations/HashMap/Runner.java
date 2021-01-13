package HashMap;

public class Runner {
	public static void main(String[] args) {
		/* Create Objects */
		Person bob = new Person("Bob", 20);
		Person jim = new Person("Jim", 25);
		Person alex = new Person("Alex", 30);
		Person tim = new Person("Tim", 35);
		Person maxwell = new Person("Maxwell", 40);
		Person john = new Person("John", 45);
		Person julie = new Person("Julie", 50);
		Person christy = new Person("Christy", 55);
		Person tim2 = new Person("Tim", 100); // This should replace the first
												// "tim"

		Person[] dummies = { bob, jim, alex, tim, maxwell, john, julie, christy, tim2 };

		/* Insert them into hash. This will do hashing as well as insert them */
		MyHashMap<String, Person> map = new MyHashMap<String, Person>(3);
		for (Person d : dummies) 
		{
			map.put(d.getName(), d);
		}

		map.printTable();

		// /* Test: Recall */
		// for (Person d : dummies)
		// {
		// String name = d.getName();
		// Person Person = hash.get(name);
		// System.out.println("Person named " + name + ": " +
		// Person.toString());
		// }
	}
}

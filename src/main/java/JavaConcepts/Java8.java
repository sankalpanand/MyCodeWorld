package JavaConcepts;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8 {

	public static void main(String[] args) 
	{
		list = Arrays.asList(5, 9, -1, 60, 10, 2, 9);
		// streams();
		// parallelProcessing();
        findAny();
		
	}
	
	static List<Integer> list;

	// 1- Lambda
	public static void sortByLambda()
	{
		list.sort((a, b) -> a - b);
		list.forEach(i -> System.out.print(i + "   "));
	}
	
	public static void findCommonByLambda()
	{
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> list2 = Arrays.asList(1, 3, 5, 7, 9);
		List<Integer> common = list1.stream().filter(list2::contains).collect(Collectors.toList());
	}

	// 2- Default implementation for methods in interfaces
	interface Mixin 
	{
		public default void util1() 
		{
			System.out.println("I'm Util1 Default");
		}

		public void util2();
	}

	// 3- Streams
	public static void streams()
	{
		list.stream().distinct()
		.sorted  ((a, b) -> b - a)
		.filter  (i -> i > 0)
		.map     (multiplyBy2) // multiplyBy2 is a pointer to function, see its definition below
		.forEach (System.out::println); // note the :: operator to access static methods
		
	}
	
	private static Function<Integer, Integer> multiplyBy2 = (x) -> x * 2;
	
	// 4- Parallel processing
	public static void parallelProcessing()
	{
		long t2 = System.currentTimeMillis();
		
		list.parallelStream().forEach(i -> {
		  try   { Thread.sleep(1000); }
		  catch (InterruptedException e){}
		});

		System.out.println("Parallel Time: " + (System.currentTimeMillis() - t2)); 
	}

	public static void findAny() {
        // Creating a Stream of Strings
        Stream<String> stream = Stream.of("Geeks", "for", "GeEKSQUIZ", "GeeksforGeeks");

        // Check if Character at 1st index is
        // UpperCase in any string or not using
        // Stream anyMatch(Predicate predicate)
        boolean answer = stream.anyMatch(str -> Character.isUpperCase(str.charAt(1)));

        // Displaying the result
        System.out.println(answer);
    }

}

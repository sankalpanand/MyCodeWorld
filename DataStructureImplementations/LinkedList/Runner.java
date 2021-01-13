package LinkedList;

public class Runner {

	public static void main(String[] args) {

		Operations<Integer, Integer> obj = new Operations<>();
		Node<Integer, Integer> head = obj.randomLinkedList(10, 1, 100);
		System.out.println(head.printForward());
		
	}

}

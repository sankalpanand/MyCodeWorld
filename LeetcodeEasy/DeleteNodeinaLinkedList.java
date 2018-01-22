package LeetcodeEasy;



public class DeleteNodeinaLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void deleteNode(ListNode node) {

		node.val = node.next.val;
		node.next = node.next.next;

		/*while(node.next.next != null)
		{
			node.val = node.next.val;
			node = node.next;
		}

		node.val = node.next.val;
		node.next = null;*/

	}

}

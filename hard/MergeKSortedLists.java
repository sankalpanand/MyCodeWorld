package hard;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Time Complexity : nk log(n) beacuse Each insertion take logn. There are kn elements. 
	// So totally the complexity should be nlogn + kn*logn = knlogn
	//	Space Complexity o(k)
	public ListNode mergeKLists(ListNode[] lists) {
		
		
        if(lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(
        		lists.length,
            new Comparator<ListNode>()
            {
        		@Override
                public int compare(ListNode node1, ListNode node2)
                {
                    if(node1.val < node2.val) return -1;
                    else if(node1.val > node2.val) return 1;
                    else return 0;
                }
            }
            
            );
            
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        for(ListNode head : lists)
        {
            if(head != null) 
                queue.add(head);
        }
        
        while(!queue.isEmpty())
        {
            tail.next = queue.poll();
            tail = tail.next;
            
            if(tail.next != null)
                queue.add(tail.next);
            
        }
        
        return dummy.next;
    }
	
	// Second approach by pairwise merging
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head=null;
        ListNode former=null;
        while (l1!=null&&l2!=null) {
            if (l1.val>l2.val) {
                if (former==null) former=l2; else former.next=l2;
                if (head==null) head=former; else former=former.next;
                l2=l2.next;
            } else {
                if (former==null) former=l1; else former.next=l1;
                if (head==null) head=former; else former=former.next;
                l1=l1.next;
            }
        }
        if (l2!=null) l1=l2;
        former.next=l1;
        return head;

    }

    public ListNode mergeKLists(List<ListNode> lists) 
    {
        if (lists.size()==0) return null;
        if (lists.size()==1) return lists.get(0);
        if (lists.size()==2) return mergeTwoLists(lists.get(0), lists.get(1));
        
        return mergeTwoLists(
        		mergeKLists(lists.subList(0, lists.size()/2)), // to is index exclusive
        		mergeKLists(lists.subList(lists.size()/2, lists.size()))
        		);
    }
	
	

}

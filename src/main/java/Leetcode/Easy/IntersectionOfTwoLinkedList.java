package Leetcode.Easy;

import Leetcode.Templates.ListNode;

import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	
	public Map<ListNode, Boolean> visited = new HashMap<ListNode, Boolean>();
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while(headA != null)
        {
        	visited.put(headA, true);
            headA = headA.next;
        }
        
        while(headB != null)
        {
            Boolean isPresent = visited.put(headB, true);
            if(isPresent != null) return headB;
            headB = headB.next;
        }
        
        return null;
    }
    
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if( null==headA || null==headB )
            return null;

        ListNode curA = headA, curB = headB;
        while( curA!=curB){
            curA = curA==null?headB:curA.next;
            curB = curB==null?headA:curB.next;
        }
        return curA;
    }
    
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        ListNode tempA = headA;
        ListNode tempB = headB;
        
        int lenA = 0, lenB = 0;
        
        while(tempA != null)
        {
            lenA++;
            tempA = tempA.next;
        }
        
        while(tempB != null)
        {
            lenB++;
            tempB = tempB.next;
        }
        
        int lenDiff = Math.abs(lenA - lenB);
        
        tempA = headA;
        tempB = headB;
        
        if(lenA > lenB)
        {
            for(int i = 0; i< lenDiff; i++)
            {
                tempA = tempA.next;
            }
        }
        else if(lenB > lenA)
        {
            for(int i = 0; i< lenDiff; i++)
            {
                tempB = tempB.next;
            }
        }
        
        
        while(tempA != tempB)
        {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        
        return tempA;
        
        
    }

}

package Leetcode.Medium;

import java.util.Iterator;

public class PeekingIterator  implements Iterator<Integer> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	private Integer next = null;
	private Iterator<Integer> iter;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		iter = iterator;
		if(iter.hasNext())
			next = iter.next();

	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer nextElem = next;

		if(iter.hasNext())
			next = iter.next();
		else
			next = null;

		return nextElem;
	}

	@Override
	public boolean hasNext() {
		if(iter.hasNext())
			return true;
		else
			return false;
	}
}



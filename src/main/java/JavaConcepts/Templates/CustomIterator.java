package Templates;
import java.util.Iterator;

// http://tutorials.jenkov.com/java-generics/implementing-iterable.html


public class CustomIterator<E> implements Iterable<E> 
{
	private E[] list;
	private int currentSize;

	public CustomIterator(E[] newArray) 
	{
		this.list = newArray;
		this.currentSize = newArray.length;
	}

	@Override
	public Iterator<E> iterator() 
	{
		Iterator<E> it = new Iterator<E>() 
		{
			private int currentIndex = 0;

			@Override
			public boolean hasNext() 
			{
				return currentIndex < currentSize && list[currentIndex] != null;
			}

			@Override
			public E next() 
			{
				return list[currentIndex++];
			}

			@Override
			public void remove() 
			{
				throw new UnsupportedOperationException();
			}
		};
		return it;
	}
	
	public static void main(String[] args) {
		String[] arr = {"Salmaan","Shahrukh","Aamir"};
		CustomIterator<String> range = new CustomIterator<String>(arr);

		// First way
		Iterator<String> it = range.iterator();
        while(it.hasNext()) 
        {
            String cur = it.next();
            System.out.println(cur);
        }

        // Second way
        for(String cur : (String[]) range.list) 
        {
            System.out.println(cur);
        }
    }
}

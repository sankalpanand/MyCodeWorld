
public class Output4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {1};
		Output4 t = new Output4();
		t.increment(a);
		System.out.println(a[a.length-1]);

	}
	
	public void increment(int[] i)
	{
		i[i.length - 1]++;
	}
	
	

}

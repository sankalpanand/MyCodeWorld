
public class FlipNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		int ones = (Integer.highestOneBit(n) << 1) - 1;
	    int res =  n ^ ones;
	    System.out.println(res);

	}

}

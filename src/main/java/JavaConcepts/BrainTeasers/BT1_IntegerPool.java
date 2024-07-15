package JavaConcepts.BrainTeasers;

public class BT1_IntegerPool {

	// Notes
	// Java maintains Integer pool from -128 to 127
	// Integer i1 = 127;
	// is equivalent to
	// Integer i1 = Integer.valueOf(127);

	public static void main(String[] args) {

		Integer a = 100, b = 100;
		System.out.println(a==b);

		Integer c = 127, d=127;
		System.out.println(c==d);

		// Integer i1 = 127;<---Integer.valueOf(127);
		// Integer i2 = 127;<---Integer.valueOf(127); <---Same reference as first

		Integer e = 128, f=128;
		System.out.println(e==f);

		Integer g = 100, h = 100;
		System.out.println(g==h);

		Integer i = new Integer(100), j = new Integer(100);
		System.out.println(i==j);

	}

}

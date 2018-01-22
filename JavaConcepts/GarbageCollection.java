
public class GarbageCollection {
	GarbageCollection t;
	static int i = 1;

	public static void main(String args[]) {
		GarbageCollection t1 = new GarbageCollection();
		GarbageCollection t2 = new GarbageCollection();
		GarbageCollection t3 = new GarbageCollection();

		// No Object Is Eligible for GC

		t1.t = t2; // No Object Is Eligible for GC
		t2.t = t3; // No Object Is Eligible for GC
		t3.t = t1; // No Object Is Eligible for GC

		t1 = null;
		// No Object Is Eligible for GC (t3.t still has a reference to t1)

		t2 = null;
		// No Object Is Eligible for GC (t3.t.t still has a reference to t2)

		t3 = null;
		// All the 3 Object Is Eligible for GC (None of them have a reference.
		// only the variable t of the objects are referring each other in a
		// rounded fashion forming the Island of objects with out any external
		// reference)
	}

	@Override
	protected void finalize() {
		System.out.println("Garbage collected from object" + i);
		i++;
	}
}

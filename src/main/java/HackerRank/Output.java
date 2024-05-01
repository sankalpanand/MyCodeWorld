
public class Output {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Output();

	}
	
	private boolean flag = true;
	
	public void sample()
	{
		System.out.println("Sample");
	}
	
	public Output() {
		(new Inner()).test();
	}
	
	class Inner
	{
		void test()
		{
			if(Output.this.flag);
			{
				sample();
			}
		}
	}

}

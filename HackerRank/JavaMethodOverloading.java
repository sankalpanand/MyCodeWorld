package HackerRank;

public class JavaMethodOverloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Adder X=new Adder();
		System.out.println("My superclass is: "+X.getClass().getSuperclass().getName());	
		System.out.print(X.add(10,32)+" "+X.add(10,3)+" "+X.add(10,10)+"\n");

	}

	public void method1(String a, int b) {

    }

    public void method1(int b, String a) {

    }


}

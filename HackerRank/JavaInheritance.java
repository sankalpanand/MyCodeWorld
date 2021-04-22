package HackerRank;

public class JavaInheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Adder X=new Adder();
		System.out.println("My superclass is: "+X.getClass().getSuperclass().getName());	
		System.out.print(X.add(10,32)+" "+X.add(10,3)+" "+X.add(10,10)+"\n");

	}

}

class GrandParent {

}

class Parent {

    public void method1(String a, int b) {
        System.out.println("method 1 in Parent called");
    }

}

class Child extends Parent {
    public void method1(String a, int b) {
        System.out.println("method 1 in Parent called");
    }
}


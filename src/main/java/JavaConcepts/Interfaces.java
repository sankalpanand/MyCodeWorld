package JavaConcepts;

interface IGrandfather
{
	String name = "Grandpa";
	public void GFMethod();
}

interface IFather extends IGrandfather
{
	String name = "Dad";
	public void FMethod();
}

public class Interfaces implements IFather {

	public static void main(String[] args) {
        Child c = new Child();
        c.myOwnMethod();
	}
	
	public void FMethod()
	{
		
	}

	public void GFMethod() {
		// TODO Auto-generated method stub
		
	}
}

// Trivia 1 - If the Reference of Interface is pointing towards object of Child, it can't call child's own method- myOwnMethod()
class Child implements IGrandfather {
    public void GFMethod() {
        System.out.println("From child.GFMethod()");

    }

    public void myOwnMethod() {
        System.out.println("From child.myOwnMethod()");
    }
}
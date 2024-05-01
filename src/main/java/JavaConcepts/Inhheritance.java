class Grandfather 
{
    public static void show() {
       System.out.println("Grandfather::show() called");
    }
}
  
class Father extends Grandfather {
    public static void show() {
       System.out.println("Father::show() called");
    }
}

class GrandfatherNonStatic {
    public void show() {
       System.out.println("GrandfatherNonStatic::show() called");
    }
}
  
class FatherNonStatic extends GrandfatherNonStatic {
    public void show() {
       System.out.println("FatherNonStatic::show() called");
    }
    
    public void show2() {
        System.out.println("FatherNonStatic::show2() called");
     }
}

public class Inhheritance {

	public static void main(String[] args) {
		Question1();
		Question2();
	}

	// when a function is static, runtime polymorphism doesn't happen.
	public static void Question1()
	{
		Grandfather b = new Father();
        b.show();
        
	}

	// Dynamic polymorphism in normal function
	public static void Question2()
	{
		GrandfatherNonStatic b = new FatherNonStatic();;
        b.show();
        
        // Can't call show2() as it is undefined for the father
        // b.show2();
	}

}

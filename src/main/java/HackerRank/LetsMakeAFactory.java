
public class LetsMakeAFactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		foodFactory myFoods = new foodFactory();
		Food food1 = myFoods.getFood("Fastfood");
		Food food2 = myFoods.getFood("Fruits");	
		System.out.println("My name is: " + food1.getClass().getName());
		System.out.println("My name is: " + food2.getClass().getName());
		System.out.println("Our superclass is: " + food1.getClass().getSuperclass().getName());
		food1.serveFood();
		food2.serveFood();

	}



}


//Write your code here
class foodFactory extends Solution{
	
	public Food getFood(String str)
	{
		if(str == "Fastfood")
			return new Fastfood();
		else if (str == "Fruits")
			return new Fruits();
		else
			return null;
		
	}

}

class Food extends Solution{
	
	String name;
	
	public Food(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	public Food() 
	{
		// TODO Auto-generated constructor stub
		
	}

	public void serveFood()
	{
		System.out.println("I'm serving " + name);
	}
}

class Fastfood extends Food
{
	public void serveFood()
	{
		System.out.println("I'm serving " + this.getClass().getName());
	}
}

class Fruits  extends Food
{
	public void serveFood()
	{
		System.out.println("I'm serving " + this.getClass().getName());
	}
}
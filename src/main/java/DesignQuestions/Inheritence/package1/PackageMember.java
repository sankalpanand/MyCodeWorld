package DesignQuestions.Inheritence.package1;

public class PackageMember {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child obj = new Child();
		obj.print();

	}
	
	public void print()
	{
		Parent obj = new Parent();
		obj.protectedPrint();
		obj.publicPrint();
		obj.defaultPrint();
	}

}

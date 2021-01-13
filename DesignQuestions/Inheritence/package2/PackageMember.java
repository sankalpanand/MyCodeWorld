package DesignQuestions.Inheritence.package2;


import DesignQuestions.Inheritence.package1.Parent;

public class PackageMember extends Parent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent obj = new Parent();
		obj.publicPrint();
		
		PackageMember obj2 = new PackageMember();
		obj2.protectedPrint();
		obj2.publicPrint();
	}
	
	

}

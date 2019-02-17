package by.bntu.fitr.povt.compilercrusaders.javalabs.lab10.inittest;

public class SuperInstance {

	static {
		System.out.println("SUPERCLASS STATIC INIT BLOCK\n");
	}
	
	{
		System.out.println("SUPERCLASS DYNAMIC INIT BLOCK\n");
	}
	
	public SuperInstance() {
		System.out.println("SUPERCLASS CONSTRUCTOR\n");
	}
	
}

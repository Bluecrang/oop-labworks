package by.bntu.fitr.povt.compilercrusaders.javalabs.lab10.inittest;

public class SubInstance extends SuperInstance {
	
	static {
		System.out.println("SUBCLASS STATIC INIT BLOCK\n");
	}
	
	{
		System.out.println("SUBCLASS DYNAMIC INIT BLOCK\n");
	}
	
	SubInstance() {
		System.out.println("SUBCLASS CONSTRUCTOR\n");
	}
}

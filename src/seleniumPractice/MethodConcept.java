package seleniumPractice;

public class MethodConcept {

	
	public static void main(String[] args) {
	
	MethodConcept mc=new MethodConcept();
	mc.method();
	mc.method(30);
		

	}
	
	public void method(){
	int variable=10;
	System.out.println(variable);
	
	}
	
	public void method(int variable){
	variable =20;
		System.out.println(variable);
	}

}

package java05;

class Parent16{
	private int a ;
	 	int b;
	 	protected int c;
	 	public int d;
	 	public Parent16(int a , int b ,int c , int d) {
	 		this.a =a ;
	 		this.b = b;
	 		this.c = c;
	 		this.d = d;
	 	}
	 	public Parent16(int a) {
	 		this.a =a;
	 		System.out.println(a);
	 	}
		
	 	
	 
	 	
}
class Child16 extends Parent16{


	public Child16(int a ,int b , int c, int d) {
		super(a);
		this.b =b;
		this.c =c;
		this.d =d;
	}
	public void pr() {
		System.out.println(b+"\n"+c+"\n"+d);
	}
	
}
public class ExtendEx05 {

	public static void main(String[] args) {
		Child16 ch =new Child16(1,2,3,4);
		ch.pr();
	}

}

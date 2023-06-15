package java05;
class A2 {
	public String toString ( ) { 
		return "4";
	}
}
class B2 extends A2{

	@Override
	public String toString() {
		
		return super.toString()+"3";
	}
	
}
public class ExtendEx11 {

	public static void main(String[] args) {
		System.out.println(new B2());
	}

}

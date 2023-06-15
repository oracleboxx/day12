package java05;

class Base{
	Base(){
		System.out.println("Base");
	}
}
class Alpha extends Base{
	Alpha(){
		super();
	}
}
public class ExtendEx09 {

	public static void main(String[] args) {
		 new Alpha();
		
		
	}

}

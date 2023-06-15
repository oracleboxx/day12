package java05;

class Animal{
	protected String kind;
	protected int leg;
	public Animal(String kind , int leg){
		this.kind = kind;
		this.leg  =leg ;
	}
	public void  getkind() {
		if(kind.equals("사람")) {
			System.out.println("소녀는" + +"이다");
		}
		else {
			System.out.println("강아지는"+kind+"이다");
		}
	}
	public void  walk() {
		
	}
}
class Dog extends Animal{
	public Dog(String kind , int leg) {
		super(kind,leg);
	}
}
class Human extends Dog{
	public Human(String kind , int leg) {
		super(kind,leg);
	}
}
public class protice7 {

	public static void main(String[] args) {
		Dog d = new Dog("동물",4);
		Human h = new Human("사람", 2);
		d.getkind();
	}

}

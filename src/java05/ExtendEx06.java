package java05;

class Animal{
	protected String kind;
	protected int leg;
	
	public Animal() {
		
	}
	public Animal(String kind , int leg) {
		this.kind =kind;
		this.leg = leg;
	}
	public void getkind(){
		if(kind.equals("강아지")) {
			System.out.println(kind+"동물이다");
		}
		else {
			System.out.println(kind+"사람이다");
		}
	}
	public void walk() {
	if(leg == 4) {
		System.out.println("강아지는 "+leg+" 발로 걷는다");
	}
	else {
		System.out.println("사람은 "+leg+"발로 걷는다");
	}
	}
}
class Dog extends Animal{
	 
	public Dog() {
		
	}
	public Dog(String kind , int leg) {
		super(kind,leg);
	}

	
	public void pr() {
		System.out.println("종류:"+kind);
		System.out.println("다리:"+leg);
		System.out.println();
	}

	
}
class Human extends Animal{
	
	public Human() {
		
	}
	public Human(String kind , int leg) {
		super(kind,leg);
	}
	
}

public class ExtendEx06 {

	public static void main(String[] args) {
		Dog dog = new Dog("강아지",4);
		Human human =new Human("사람",2);
		
		dog.getkind();
		dog.walk();
		human.getkind();
		human.walk();
	}

}

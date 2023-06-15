package java05;


class Student{
	private String name ;
	private int number;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void pr() {
		System.out.println("이름"+name+"학번"+number);
	}
}
public class Protice2 {

	public static void main(String[] args) {
		Student st = new Student();
		st.setName("le");
		st.setNumber(12);
		System.out.println(st.getName()+":"+st.getNumber());
		
	}

}

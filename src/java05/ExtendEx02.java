package java05;


class ParentPoint04{
	protected int x =10;
	protected int y =20;
	
	public ParentPoint04(){
		super();
	}
	public ParentPoint04(int x , int y){
		this.x = x;
		this.y = y;
	}
}
class ChildPoint04 extends ParentPoint04{
	protected int z = 30;
	public ChildPoint04() {
		super(50,60);
	}

	public ChildPoint04(int x , int y , int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public void pr() {
		System.out.println(x+":"+y+":"+z);
	}
}
public class ExtendEx02 {

	public static void main(String[] args) {
			ChildPoint04 ch = new ChildPoint04();
			ChildPoint04 ch1 = new ChildPoint04(100,200,300);
			
			ch.pr();
			ch1.pr();
	}

}

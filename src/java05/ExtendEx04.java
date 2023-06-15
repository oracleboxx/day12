package java05;


class Point17{
	int x ;
	int y ;
	
	public Point17(int x , int y) {
		this.x =x;
		this.y =y;
	}
}
class ChildPoint17 extends Point17{
	int z;

	public ChildPoint17(int x, int y, int z) {
		super(x,y);
		this.z = z;
	}
	public void pr() {
		System.out.println(x+":"+y+":"+z);
	}

}
public class ExtendEx04 {
	public static void main(String[] args) {
		ChildPoint17 ch =new ChildPoint17(10,20,30);
		ch.pr();
	}

}

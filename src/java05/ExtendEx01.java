package java05;
// 부모 클래스 생성자가 오버로딩이 된 경우 기본 생성자를 묵서적 제공하지 않는다.
// 이런 경우에 자손클래스에서 부모의 기본생성자를 호출 
/* 부모 클래스 생성자가 오버로딩이 되어서 자손에서 부모클래스 기본생성자를 호출할 때
 * 에러가 나는 부분을 방지하는 법
 * 1. 부모클래스 기본생성자를 명시적으로 정의한다
 * 2. 자손클래스에서 부모의 오버로딩 된 생성자를 호출할려고 인위적 경로를 변경한다.
 * 
 */
class ParentPoint01{
	protected int a = 1;
	protected int b = 2;
	ParentPoint01(){	
	}
	ParentPoint01(int a , int b){
		this.a = a;
		this.b = b;
		
	}
}
	class ChildPoint03 extends ParentPoint01{
		protected int c = 3;
		
	
	ChildPoint03(){
		
	}
	ChildPoint03(int a , int b , int c){
		super(4,5);
		this.c = c;
	}
	public void pr(){
		System.out.println(super.a+":"+b+":"+c);
	}
	
	
}

public class ExtendEx01 {

	public static void main(String[] args) {
		ChildPoint03 ch = new ChildPoint03();
		ch.pr();
	}
}

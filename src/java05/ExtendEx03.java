package java05;

class Member16{
	private String member_id;
	private String member_pwd;
	private String member_name;
	
	public Member16() {
		super();
	}
	public Member16(String member_id,String member_pwd,String member_name) {
		this.member_id =member_id;
		this.member_pwd =member_pwd;
		this.member_name = member_name;
	}
	public void prMember(String member_id,String member_pwd,String member_name) {
		System.out.println("아이디"+member_id);
		System.out.println("비번"+member_pwd);
		System.out.println("이름"+member_name);
		
	}
}
class ChildMember16 extends Member16{
	
	private String member_addr;
	public ChildMember16(String member_id , String member_pwd, String member_name, String member_addr) {
		
		
		super.prMember(member_id,member_pwd,member_name);
		this.member_addr = member_addr;
		
	}
	
	}


public class ExtendEx03 {

	public static void main(String[] args) {
		
	}

}

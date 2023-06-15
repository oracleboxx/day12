package java05;


class Hakwon{
	private String room ;
	private String room2 ;
	private String room3 ;

	public Hakwon(String room , String room2 , String room3) {
		this.room = room;
		this.room2 = room2;
		this.room3 = room3;
	}
	class HakwonRoom extends Hakwon{
		private String room4 = "404";
		public HakwonRoom(String room , String room2 , String room3) {
			super("101","202","303");
			this.room4 = room4;
		}
		public void pr() {
			System.out.println(room+":"+room2+":"+room3+":"+room4);
		}
	}
}
public class Protice {

	public static void main(String[] args) {
		HakwonRoom hr = new HakwonRoom();
	}

}

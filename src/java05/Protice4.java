package java05;

class Circle {
	private double radius;
	private static double PI= 3.141592;
	public Circle() {
		this.radius = radius;
		
	}
	public double getRadius() {
		return radius*radius*PI;
	}
	public double getArea() {
		
		return 0;
	}
	
	
}
class Cylinder{
	private double height;
	 Circle cir;
	
	public Cylinder() {
		this.height =height;
		this.cir =cir;
	}
	public double volum() {
		return cir.getRadius()*height;
	}
}



	public class Protice4 {

		public static void main(String[] args) {
			// 반지름이 2.8 , 높이가 5.6의 원통의 부피를 출력
			Circle cp = new Circle(); // 반지름 2.8
			 Cylinder cd = new Cylinder();
			 // Circle 생성자의 2.8, Cylinder 5.6 
			double height = 5.6; // radius 2.8 height 5.6
			
			// 부피 구하는 법 : 원의 면적 * 높이 . >> 면적은 반지름+반지름+파이 파이먹고싶다
			System.out.println("부피 : "+(cp.getArea()*height));
			System.out.println(cd.volum()); // 동일한 결과
		}

	}


public class Point {

	double x, y, z;
	
	public Point(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
		this.z = 0;
	}
	
	public String toString() {
		return "����x=" + this.x + " ����y=" + this.y + " ����z=" + this.z;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double x) {
		this.y = x;
	}
	
	public void setZ(double x) {
		this.y = x;
	}

	public static double countDistance(Point a, Point b) {
		return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2) + Math.pow(a.z - b.z, 2));
	}
	
	public static double distance(Point a) {
		return Math.sqrt(Math.pow(a.x, 2) + Math.pow(a.y, 2) + Math.pow(a.z, 2));
	}
	
	public static void main(String[] args) {
		
		String s = null;
		s = "sdsd";
		System.out.println(s);
	}

}

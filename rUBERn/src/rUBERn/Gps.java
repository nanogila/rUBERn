package rUBERn;

public class Gps {
private long coordinateX, coordinateY;
public Gps(){
	new Gps(0, 0);
	}
	public Gps(long x, long y) {
		coordinateX = x;
		coordinateY = y;
	}
	public long[] getLocation() {
		long[] location = {coordinateX, coordinateY};
		return location;
	}
	public String toString() {
		return "["+coordinateX+", "+coordinateY+"]";
	}
	public void updateLocation(long x, long y) {
		coordinateX = x;
		coordinateY = y;
	}
	public double getDistance(long[] pointB) {
		double distance = Math.sqrt(Math.pow(coordinateX-pointB[0], 2)+Math.pow(coordinateY-pointB[1], 2));
		return distance;
		
	}
}

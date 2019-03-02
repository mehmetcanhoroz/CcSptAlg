import java.util.ArrayList;

public class Cargo extends Helpers {
	public Cargo(int id, double lat, double lng, int min, int max, ArrayList<Order> orders) {
		super();
		this.lat = lat;
		this.lng = lng;
		this.id = id;
		this.min = min;
		this.max = max;
	}
	
	public Cargo(int id, double lat, double lng, int min, int max) {
		super();
		this.lat = lat;
		this.lng = lng;
		this.id = id;
		this.min = min;
		this.max = max;
	}

	public double lat;
	public double lng;
	public int id;

	public int min;
	public int max;
	
	public ArrayList<Order> orders;
	
	public double distance(Order o) {
		return super.distance(this.lat, this.lng, o.lat, o.lng);
	}
	
	public double distance(Cargo c) {
		return super.distance(this.lat, this.lng, c.lat, c.lng);
	}
}

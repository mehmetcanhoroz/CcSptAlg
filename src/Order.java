import java.util.ArrayList;

public class Order extends Helpers {

	public Order(double lat, double lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}

	public Order(int id, double lat, double lng) {
		super();
		this.id = id;
		this.lat = lat;
		this.lng = lng;
	}

	public Order(int id, double lat, double lng, ArrayList<Cargo> c) {
		super();
		this.id = id;
		this.lat = lat;
		this.lng = lng;
		this.cargos = c;

		this.calculateAllCargoDistance();
	}

	public double lat;
	public double lng;
	public int id;

	public ArrayList<Cargo> cargos;
	public ArrayList<CargoDistance> cargoDistances = new ArrayList<>();
	
	public double distance(Cargo c) {
		return super.distance(this.lat, this.lng, c.lat, c.lng);
	}
	
	public double distance(Order o) {
		return super.distance(this.lat, this.lng, o.lat, o.lng);
	}

	public void calculateAllCargoDistance()
	{
		this.cargos.forEach((c) -> {
			this.cargoDistances.add(new CargoDistance(c, this.distance(c)));
		});
	}

	@Override
	public String toString() {
		String s = "Order ID : " + this.id + "\r\n";
		return s;
	}
}

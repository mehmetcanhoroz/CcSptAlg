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

    public void calculateAllCargoDistance() {
        this.cargos.forEach((c) -> {
            this.cargoDistances.add(new CargoDistance(c, this.distance(c)));
        });
    }

    public Cargo closestCargo() {
        int cargoIndex = 0;

        for (int y = 0; y < this.cargos.size(); y++) {

            if (this.cargos.get(cargoIndex).distance(this) >= this.cargos.get(y).distance(this)) {
                cargoIndex = y;
            }
        }

        return this.cargoDistances.get(cargoIndex).cargo;

    }

    @Override
    public String toString() {
        String s = "\r\n" + "Order ID : " + this.id + "\r\n";
        s += "GEO : " + this.lat + "," + this.lng + "\r\n";
        return s;
    }

    public String generateMap() {
        String s = "";
        s += this.lat + "," + this.lng + " {" + "OrderID=" + this.id + "}";
        return s;

    }
}

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

    public ArrayList<Order> orders = new ArrayList<>();

    public double distance(Order o) {
        return super.distance(this.lat, this.lng, o.lat, o.lng);
    }

    public double distance(Cargo c) {
        return super.distance(this.lat, this.lng, c.lat, c.lng);
    }

    @Override
    public String toString() {
        String s = "Cargo ID : " + this.id + " - Order Count: " + this.orders.size() + "\r\n\r\n";

        s += this.showOrders();
        return s;
    }

    public String showOrders() {
        String s = "";

        for(int i = 0; i < this.orders.size(); i++) {
            s += (this.orders.get(i) + "\r");
            s += ("-------------------------");
        }
        return s;
    }
}

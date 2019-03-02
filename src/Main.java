import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	static ArrayList<Order> orders = new ArrayList<>();
	static ArrayList<Cargo> cargos = new ArrayList<>();

	public static void main(String[] args) {
		feedCargoList();
		feedOrderList();
	}

	private static void feedOrderList() {
		try (BufferedReader br = new BufferedReader(new FileReader("src/orders.txt"))) {
			String line = br.readLine();

			do {
				if (line.trim().isEmpty())
					continue;

				String[] parts = line.split("\t", 3);

				Order o = new Order(Integer.parseInt(parts[0]), Double.parseDouble(parts[1]),
						Double.parseDouble(parts[2]));
				o.cargos = cargos;
				o.calculateAllCargoDistance();
				orders.add(o);

				line = br.readLine();
			} while (line != null);
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void feedCargoList() {
		// Red - 1
		// Green - 2
		// Blue - 3
		try (BufferedReader br = new BufferedReader(new FileReader("src/cargos.txt"))) {
			String line = br.readLine();

			do {
				if (line.trim().isEmpty())
					continue;

				String[] parts = line.split("\t", 5);

				Cargo c = new Cargo
						(
								Integer.parseInt(parts[0]),
								Double.parseDouble(parts[1]),
								Double.parseDouble(parts[2]),
								Integer.parseInt(parts[3]),
								Integer.parseInt(parts[4])
						);
				cargos.add(c);

				line = br.readLine();
			} while (line != null);
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

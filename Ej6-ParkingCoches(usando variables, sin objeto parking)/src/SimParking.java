
public class SimParking {

	public static void main(String[] args) {

		int plazas = Integer.parseInt(args[0]);
		int coches = Integer.parseInt(args[1]);
		Parking parking = new Parking(plazas, coches);

		for (int i = 0; i < coches; i++) {
			new Coche(i, parking).start();
		}
	}
}

class Parking {
	int plazas;
	int coches;
	int numPlazasOcupadas;

	public Parking(int numPlazas, int numCoches) {
		this.plazas = numPlazas;
		this.coches = numCoches;
		this.numPlazasOcupadas = 0;
	}

	boolean hayPlazaLibre() {
		return plazas == numPlazasOcupadas;
	}

	public synchronized void entrarParking() {
		while (hayPlazaLibre()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		numPlazasOcupadas++;
	}

	public synchronized void salirParking() {
		numPlazasOcupadas--;
		notify();
	}
}

class Coche extends Thread {

	Parking parking;
	int numCoche;

	public Coche(Integer numCoche, Parking parking){
		this.numCoche = numCoche;
		this.parking = parking;
	}

	public void entrarParking() {
		System.out.println("El coche "+numCoche+ " quiere entrar al parking");
		parking.entrarParking();
	}

	public void esperarParking() {
		try {
			System.out.println("El coche "+numCoche+ " esta aparcado");
			sleep((long)Math.random());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void salirParking() {
		System.out.println("El coche "+numCoche+ " esta saliendo del parking");
		parking.salirParking();
	}
	
	public void esperar()
	{
		try {
		sleep((long)Math.random()*1000);
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
	}

	@Override
	public void run() {
	
			while (true) {
				esperar();
				entrarParking();
				esperar();
				esperarParking();
				esperar();
				salirParking();
			}
		}
}



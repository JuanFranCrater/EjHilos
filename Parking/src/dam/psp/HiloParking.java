package dam.psp;

public class HiloParking {

	public static void main(String[] args) {
		Thread hilo;
		int plazas =10;
		int numCoches = 20;
		Parking park = new Parking(plazas,numCoches);
		for(int i = 0; i<numCoches; i++)
		{
			hilo=new Thread(new Coche(park));

			hilo.start();
		}
	}

}

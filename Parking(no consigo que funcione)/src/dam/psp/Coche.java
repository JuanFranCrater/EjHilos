package dam.psp;

public class Coche implements Runnable {
	
	Parking parking;
	int posParking;
	
	public Coche(Parking parking)
	{
		this.parking=parking;
	}
	@Override
	public void run() {
		
		while(true) {
			esperar();
			aparcar();
			esperar();
			salir();
			esperar();
		}
		
		
	}
	private void salir() {
		
		try {
			Thread.sleep((long)Math.random()*10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		parking.getPlaza(0).soltar();		
		
	}
	private void aparcar() {
		
		try {
			Thread.sleep((long)Math.random()*10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		parking.getPlaza(parking.isFree()).coger();
		
	}
	private void esperar() {
		try {
			Thread.sleep((long)Math.random()*10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
}

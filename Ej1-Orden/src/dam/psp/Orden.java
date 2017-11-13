package dam.psp;



public class Orden {
	public boolean hilo2Acabado=false;
	final static Llave key= new Llave() ;
	public static void main(String[] args) {
		
		Hilo hil1 = new Hilo(1,key);
		
		Hilo2 hil2 = new Hilo2(2,key);
		
	
		hil1.start();
		hil2.start();
		
		try {
			hil1.join();
			hil2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
package dam.psp;

public class Check {

	static Bufer b = new Bufer();
	
	public static void main(String[] args) {
		System.out.println("Inicio del hilo");
	HiloEscritor hilE = new HiloEscritor(b,0);
	HiloLector hilL = new HiloLector(b, 0);
	hilE.start();
	hilL.start();
	
	try {
		hilL.join();
		hilE.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}

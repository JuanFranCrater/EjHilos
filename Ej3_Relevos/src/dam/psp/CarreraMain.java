package dam.psp;

public class CarreraMain {
	static Carrera c = new Carrera();
public static void main(String[] args) {
	Runner r1 = new Runner(c,1);
	Runner r2 = new Runner(c,2);
	Runner r3 = new Runner(c,3);
	Runner r4 = new Runner(c,4);
	
	r1.start();
	r2.start();
	r3.start();
	r4.start();
	
	try {
		r1.join();
		r2.join();
		r3.join();
		r4.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(c.contadorCorredores==4)
		System.out.println("Todos los corredores han corrido");
	System.out.println("Fin de carrera");
}
}

class Runner extends Thread{
	int dorsal;
	Carrera carrera;
	public Runner(Carrera c, int dorsal) {
		this.dorsal=dorsal;
		this.carrera=c;
	}
	@Override
	public void run() {
		carrera.Correr(dorsal);
	}
}
class Carrera{
	boolean corriendo;
	public int contadorCorredores;
	public Carrera() {
		this.corriendo=false;
		contadorCorredores=0;
	}
	public synchronized void Correr(int dorsal) {
		while(corriendo)
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		contadorCorredores++;
			corriendo = true;
			System.out.println("El Corredor "+dorsal+" termina de correr");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("El Corredor "+dorsal+"  pasa el testigo");
			corriendo = false;
			notify();
		
	}
}

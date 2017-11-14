package dam.psp;

public class Plazas {
	int numero;
	boolean ocupada;
	Plazas(int numero){
		this.numero = numero;
		ocupada = false;
	}
	public synchronized boolean GetOcupada() {
		return ocupada;
	} 
	
public synchronized void coger(){
		while(ocupada)
		{
			try {
				this.wait();
				System.out.println("Plaza "+numero+" en uso, espera...");
				System.out.println();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ocupada=true;
		System.out.println("Plaza "+numero+" tomada por "+Thread.currentThread().getName());	
		System.out.println();
}
	public synchronized void soltar(){
		ocupada=false;
		System.out.println("Plaza "+numero+" soltada por "+Thread.currentThread().getName());
		System.out.println();
		notify();
	}
}

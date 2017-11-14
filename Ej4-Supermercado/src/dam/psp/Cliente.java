package dam.psp;

import java.util.concurrent.Semaphore;

public class Cliente implements Runnable {

	Cajas caja;
	boolean pagado = false;
	private Semaphore sem;
	Cliente(Cajas caja, Semaphore sem){
		this.sem = sem;
		Thread t = new Thread(this);
		 t.start();
		 this.caja=caja;
		
	}
	@Override
	public void run() {
		comprar();
		do {
			try {
				sem.acquire();
				String hiloComprador = Thread.currentThread().getName();
				System.out.println(hiloComprador+" va a pagar...");
				caja.pagar((int)(Math.random()*10));
				sem.release();
				pagado= true;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}while(!pagado);
		
	}
	private void comprar() {
		String hiloComprador = Thread.currentThread().getName();
		System.out.println(hiloComprador+" esta comprando...");
		try {
			if(((Math.random()*10)%2==0)) {
			Thread.sleep((long) Math.random()*1000);
			}
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}

package dam.psp;

public class Cliente implements Runnable {

	Cajas caja;
	Cliente(Cajas caja){
		Thread t = new Thread(this);
		 t.start();
		 this.caja=caja;
		
	}
	@Override
	public void run() {
		comprar();
		caja.pagar((int)((Math.random()*caja.cajas.length)),(int)(Math.random()*10));
	}
	private void comprar() {
		String hiloComprador = Thread.currentThread().getName();
		System.out.println(hiloComprador+" esta comprando...");
		try {
			Thread.sleep((long) Math.random()*1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}

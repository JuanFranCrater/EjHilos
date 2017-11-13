package dam.psp;

public class Hilo2 extends Thread {
	private int _ID;
	private Llave access;
	
	Hilo2(int id,Llave access)
	{
		this._ID=id;
		this.access=access;
	}
	@Override
	public void run() {
		mensajeSend();
		access.Acceso();
	}
	private void mensajeSend()
	{
		System.out.println("Hola, soy el hilo número "+_ID);
	}


}

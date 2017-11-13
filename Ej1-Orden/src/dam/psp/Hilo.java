package dam.psp;


public class Hilo extends Thread{
	private int _ID;
	private Llave access;
	Hilo(int id,Llave access)
	{
		this._ID=id;
		this.access=access;
	}
	@Override
	public void run() {
		while(access.acceso)
		{

		}
			mensajeSend();
		
				
	}
	private void mensajeSend()
	{
		System.out.println("Hola, soy el hilo número "+_ID);
	}


	
}

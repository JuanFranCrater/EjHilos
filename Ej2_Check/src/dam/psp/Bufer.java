package dam.psp;
/*
añadir variable lectura++, monitor mejorar. 
Implementar metodo leerposicion
debe leer el buffer en varias iteracciones, añadiendo +1 en cada iteracion, solucion no valida
*/
public class Bufer {
	private int[] buf = new int[10000];
	private int posE = 0;
	private int posL = 0;
	
	public void cambiar(int pos, int valor)
	{
		while(posL>posE)
		{
			try {
			this.wait();
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			}
		buf[pos]=valor;
		posE++;
	}
	public boolean comprobar(int valor, int pos)
	{
		while(posE<pos)
		{
			try {
			this.wait();
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		if(buf[pos]==valor)
		{
			return true;
		}
		else {
			return false;
		}
}
}

class HiloEscritor extends Thread{

	private Bufer b;
	private int num;

	public HiloEscritor(Bufer b,int num)

	{
		this.b= b;
		this.num=num;
	}

	@Override

	public void run()

	{
		for (int i = 0; i < 10000; i++) {
			b.cambiar(i,num);
			num++;
			try {
				Thread.sleep((long) Math.random());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
	}
	
	class HiloLector extends Thread{

		private Bufer b;
		private int num;
		

		public HiloLector(Bufer b,int num)

		{
			this.b= b;
			this.num=num;
		}

		@Override

		public void run()

		{
			for (int i = 0; i < 10000; i++) 
			{
				try {
					Thread.sleep((long) Math.random());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(b.comprobar(num,i))
				{
					System.out.println("Valor correcto");
				}
				else {
					System.out.println("Valor incorrecto");
				}
				num++;
			}
			
		}

}


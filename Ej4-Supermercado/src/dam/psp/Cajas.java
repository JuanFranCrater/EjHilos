package dam.psp;

public class Cajas  {
	int Resultados;
	boolean cajas[];
	Cajas(int numCajas)
	{
		Resultados=0;
		cajas = new boolean[numCajas];
		for(int i = 0; i<numCajas; i++)
		{
			cajas[i]=false;	
		}
	}
	public synchronized void pagar(int aPagar) {
		String hiloComprador = Thread.currentThread().getName();
		int caja;
		do
		{
			caja=(int)(Math.random()*cajas.length);
		}while(cajas[caja]);
		
		cajas[caja] = true;
		
		System.out.println(hiloComprador+" ha pagado en la caja "+caja+". Ha gastado "+aPagar);
		Resultados+=aPagar;
		try {
			Thread.sleep((long) Math.random()*10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		cajas[caja]=false;
	}
}

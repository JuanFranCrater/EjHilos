package dam.psp;

public class Cajas  {
	int Resultados;
	int cajas[];
	Cajas(int numCajas)
	{
		Resultados=0;
		cajas = new int[numCajas];
		for(int i = 0; i<numCajas; i++)
		{
			cajas[i]=0;	
		}
		
	}
	public void pagar(int caja,int aPagar) {
		String hiloComprador = Thread.currentThread().getName();
		while(cajas[caja]>0)
		{
			System.out.println(hiloComprador+"trata de pagar en la caja "+caja);
			System.out.println("Cliente pagando. "+hiloComprador+" debe esperar");
			System.out.println();
			cajas[caja]++;
		}
		
		cajas[caja]++;
		
		System.out.println(hiloComprador+"ha pagado en la caja "+caja+". Ha gastado "+aPagar);
		Resultados+=aPagar;
		try {
			Thread.sleep((long) Math.random()*10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		cajas[caja]--;
		notify();

	}
}

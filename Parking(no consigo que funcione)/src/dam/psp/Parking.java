package dam.psp;

public class Parking extends Thread {
	int numPlazas;
	int numCoches;
	Plazas[] plazas;
	
	
	@Override
	public void run() {
		
		while(true) {
			
		}
	}
	
	public Parking(int numplazas, int numcoches){
		this.numPlazas=numplazas;
		this.numCoches=numcoches;
		this.plazas = new Plazas[numplazas];
		for(int i = 0; i<numplazas;i++) {
			plazas[i] = new Plazas(i); 
		}
	}
	public synchronized Plazas getPlaza(int numPlaza){
		
		return plazas[numPlaza];

	}
	public synchronized int isFree() {
		for(int i = 0; i<plazas.length;i++)
		{
			if(!plazas[i].GetOcupada())
			{
				return i;
			}
		}
		return -1;
	}
	}

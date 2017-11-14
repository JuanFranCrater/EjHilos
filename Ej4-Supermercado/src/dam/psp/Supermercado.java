package dam.psp;

import java.util.concurrent.Semaphore;

public class Supermercado {

	public static void main(String[] args) {
		try {
		int numClientes = Integer.parseInt(args[0]);//^Primer valor de entrada: Numero de Clientes
		int numCajas = Integer.parseInt(args[1]);//^Segundo valor de entrada: Numero de Cajas
		Semaphore sem = new Semaphore(Integer.parseInt(args[1]));
		Cajas cajas = new Cajas(numCajas);
		
		for (int i = 0; i < numClientes; i++) {
			
			new Cliente(cajas,sem); 
		}		
		
		}catch(Exception e)
		{
			System.out.println("ERROR");
		}
	}

}


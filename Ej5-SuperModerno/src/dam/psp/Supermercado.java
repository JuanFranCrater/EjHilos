package dam.psp;

public class Supermercado {

	public static void main(String[] args) {
		int numClientes = Integer.parseInt(args[0]);//^Primer valor de entrada: Numero de Clientes
		int numCajas = Integer.parseInt(args[1]);//^Segundo valor de entrada: Numero de Cajas
		Cajas cajas = new Cajas(numCajas);
		
		for (int i = 0; i < numClientes; i++) {
			
			new Cliente(cajas); 
		}		
		
		
	}

}


/*b. Dados 3 números y un orden (ascendente o decreciente) que ordene los
mismos y los retorne en un vector de 3*/

package Clase3;

import java.util.Scanner;

public class Clase3Ejercicio1b {

	public static void main(String[] args) {
		
		int numeros[] = new int[3];
		int nuevo[] = new int[3];
		
		Scanner entrada=new Scanner(System.in);
		System.out.println("Ingrese el primer numero ");
		int primero=entrada.nextInt();
		System.out.println("Ingrese el segundo numero ");
		int segundo=entrada.nextInt();
		System.out.println("Ingrese el tercer numero ");
		int tercer=entrada.nextInt();
		
		numeros[0]=primero;
		numeros[1]=segundo;
		numeros[2]=tercer;
		
		for (int i : numeros) {
			System.out.print(i+ " ");
		}
		
	
		
		for (int i=0 ; i<numeros.length ; i++) {            //Esta es la forma ascendente 
			for (int j = 0; j < numeros.length; j++) {      // para forma desendente invertir el signo if (numeros[i] > numeros[j])
			if (numeros[i] < numeros[j]) {
				int temp = numeros[i];
				numeros[i] = numeros[j];
				numeros[j] = temp;		
				
			}
			
			}
			
		}
		
		
		System.out.print("El nuevo array es");
		
		for (int i=0 ; i<numeros.length ; i++) {
		    nuevo[i]=numeros[i];
		}
		
		
		for (int i : nuevo) {
			System.out.print(i+ " ");
		}
		
	}
	
}

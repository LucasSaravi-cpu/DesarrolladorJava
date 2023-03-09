package Clase4;
import java.util.Scanner;

public class Clase4Ejercicio1 {
	
	
	

	

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
			System.out.println("Ingrese si como quiere ordenarlo ");
			String palabra=entrada.next().toLowerCase();
			
			numeros[0]=primero;
			numeros[1]=segundo;
			numeros[2]=tercer;
			
			System.out.println("El array original es ");
			for (int i : numeros) {
				System.out.print(i+ " ");
			}
			
		   switch(palabra){
			
			   case "asendente" :
				   
			for (int i=0 ; i<numeros.length ; i++) {            //Esta es la forma ascendente 
				for (int j = 0; j < numeros.length; j++) {      // para forma desendente invertir el signo if (numeros[i] > numeros[j])
				if (numeros[i] < numeros[j]) {
					int temp = numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = temp;		
					
				}
				
				}
				
			}
			
           System.out.println("El nuevo array es");
			
			for (int i=0 ; i<numeros.length ; i++) {
			    nuevo[i]=numeros[i];
			}
			
			
			for (int i : nuevo) {
				System.out.print(i+ " ");
			}
			
			break;
			
			   case "desendente" :
				   
				   for (int i=0 ; i<numeros.length ; i++) {            //Esta es la forma ascendente 
						for (int j = 0; j < numeros.length; j++) {      // para forma desendente invertir el signo if (numeros[i] > numeros[j])
						if (numeros[i] > numeros[j]) {
							int temp = numeros[i];
							numeros[i] = numeros[j];
							numeros[j] = temp;		
							
						}
						
						}
						
					}
				   
				   
				   System.out.println("El nuevo array es");
					
					for (int i=0 ; i<numeros.length ; i++) {
					    nuevo[i]=numeros[i];
					}
					
					
					for (int i : nuevo) {
						System.out.print(i+ " ");
					}
			 break;
			 
			 default : System.out.println("La palabra ingresada es incorrecta");
		   }
				   
				   
			
			
		}
		
	}



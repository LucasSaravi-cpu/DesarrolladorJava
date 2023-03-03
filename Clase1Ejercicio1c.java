
import java.util.Scanner;

public class Clase1Ejercicio1c {
	
	public static void main(String[] args) {
		
		
		Scanner entrada=new Scanner(System.in);
		System.out.println("Ingrese si quiere organizar los numeros de forma par o impar ");
		String palabra=entrada.nextLine().toLowerCase();
		


		switch (palabra) {
		
		case "par":
			
			for(int  numeroInicio=14 ; numeroInicio>=5 ;numeroInicio--) {  	
				if ((numeroInicio % 2) == 0) {
					
				System.out.println(numeroInicio);
				}
			}
			break;
			
		case "impar":
			
			for(int  numeroInicio=14 ; numeroInicio>=5 ;numeroInicio--) {  
				if ((numeroInicio % 2) != 0) {
		
		    System.out.println( numeroInicio);		
			
				}
			}
			break;
			
		default:
			System.out.println("La palabra ingresada es incorrecta");
		}
		
	    
			}
					
			
	}



		
	      

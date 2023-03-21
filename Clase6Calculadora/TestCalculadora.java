package Clase6Calculadora;

import Clase6Testing.StringUtil;

public class TestCalculadora {

	
	 public static void main(String[] args) {
	
		
		double resultado1 =Calculadora.multiplicar(80, 3);
		
	    double resul =Calculadora.sumar(180, 150);
		double resultado2=Calculadora.dividir(resul, 3);
		
		double resul2=Calculadora.restar(80, 50);
		double resultado3=Calculadora.multiplicar(resul2, 15);
		
		double resul3=Calculadora.sumar(70, 40);
		double resultado4=Calculadora.multiplicar(resul3, 25);
		
		
		
		
		
		
		
	/*	 if (resultado1==240){
	            System.out.println("ERROR" + " Resultado 1");
	        }
	        
	        if (resultado2==110){
	            System.out.println("ERROR" + " Resultado 2");
	        }
	         
	        if (resultado3==605){
	            System.out.println("ERROR"+" Resultado 3");
	        }
	        
	        if (resultado4==2700){
	            System.out.println("ERROR"+" Resultado 4");
	        }*/
		
		
		//Me tira el error exactamente en la linea 
		
		//assertEquals(resultado1, 240);
		
		//assertEquals(resultado2, 110);
		
		//assertEquals(resultado3, 605);
		
		//assertEquals(resultado4, 2700);
		
		
		
		
	 }	 
	 
	 
	 private static void assertEquals(double actual, double expected) {
	        //acá quiero comprobar si el resultado actual es igual al esperado
	        //y si no es así lanzo un mensaje más claro
	        if (actual!=expected){
	            throw new RuntimeException(actual + " no es igual a "+expected);
	        }
	 
	 
	 
		 
}
	 
}


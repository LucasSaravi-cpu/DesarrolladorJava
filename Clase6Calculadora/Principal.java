package Clase6Calculadora;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		
		
		
		//Creo el objeto
		Calculadora micalculadora = new Calculadora();
		
		//Se aplica los metodos
		
		Scanner entrada=new Scanner(System.in);
		System.out.println("Ingrese el primer numero ");
		double unNumero=entrada.nextInt();
		
		System.out.println("Ingrese el segundo numero ");
		double Otronumero=entrada.nextInt();
		
		
		double suma=micalculadora.sumar(unNumero,Otronumero);
		
		System.out.println("la suma da " + suma);
		
		double restar=micalculadora.restar(unNumero,Otronumero);
		
		System.out.println("la resta da " + restar);
		
		double multiplicar=micalculadora.multiplicar(unNumero,Otronumero);
		
		System.out.println("la multiplicacion da " + multiplicar);
		
		
		if (Otronumero>0) {
		double dividir=micalculadora.dividir(unNumero,Otronumero);
		System.out.println("la dividision da " + dividir);
		}
		else { 
			System.out.println("No se puede dividir");
		}
		

	}

}

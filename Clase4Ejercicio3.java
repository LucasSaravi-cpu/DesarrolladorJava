package Clase4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Clase4Ejercicio3 {
	
	public static void main(String[] args) throws IOException {

		int pos;
		

		String cadena1="";
		String direccion="C:\\Users\\Principal\\Desktop\\Curso Desarrollador de java\\Clase 4\\palabra.txt";
		String cadena2="abcdefghijklmnñopqrstuvwxyz";
	 
	    FileWriter Solucion = new FileWriter("C:\\Users\\Principal\\Desktop\\Curso Desarrollador de java\\Clase 4\\solucion.txt");
	    BufferedWriter bw = new BufferedWriter(Solucion);

		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(direccion));
			
			String temp="";
			String bfRead;
			
			while ((bfRead = bf.readLine()) != null){
				
				temp= temp+bfRead;
				
			}
			
			cadena1=temp;
			
		}catch(Exception e) {
			
			System.err.print("No se encotro archivo");
		}
		
		
		
		Scanner entrada=new Scanner(System.in);		
		System.out.println("Ingrese si quiere codificar o descodificar ");
		String palabra=entrada.nextLine().toLowerCase();		
		System.out.println("Ingrese el numero de desplazamiento 1 o 2");
		int des=entrada.nextInt();
		
	
		
	
		
		switch(palabra) {
			
			case "codificar" :
				
		for (int i = 0; i < cadena1.length(); i++) {
			
			 char actual=cadena1.toLowerCase().charAt(i);
			 
	  	   	pos=cadena2.indexOf(actual);
	 	   
		   	
		   	char actual2=cadena2.toLowerCase().charAt(pos+des);  	   	
		   
		   	Solucion.write(actual2);
		   	
		   	 
		}
		
		System.out.println("Se codifico correctamente");
		 
		break;
		
			case "descodificar" :
		
				for (int i = 0; i < cadena1.length(); i++) {
					
					 char actual=cadena1.toLowerCase().charAt(i);
					 
				   	pos=cadena2.indexOf(actual);
				   
				   	if (pos>0) {
				  
				   	char actual2=cadena2.toLowerCase().charAt(pos-des);  
				   	
				
		            Solucion.write(actual2);
				   	
				   	}
				   	else {
				   	
				   		Solucion.write(" ");
				   	}
				   	
				   	 
				}
				
			System.out.println("Se descodifico correctamente");
				
		break;
		
		}
		bw.close();
		
	}

	}	

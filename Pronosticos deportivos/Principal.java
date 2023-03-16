import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Principal {
	
	public static void main(String[] args) throws FileNotFoundException {
		

 
   
		 try {
	            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Principal\\Downloads\\partidos.txt"));
	            BufferedReader reader2 = new BufferedReader(new FileReader("C:\\Users\\Principal\\Downloads\\pronosticos.txt"));
	            
	               
	            // primer txt
	            String line = reader.readLine();
	            String line2 = reader2.readLine();
	            int puntaje=0;
	            while ((line = reader.readLine()) != null) {
	            	
  	           String[] parts = line.split(",");
	            
	            String equipo1 = parts[0];
	   	        int goles1 = Integer.parseInt(parts[1]);
	   	        int goles2 = Integer.parseInt(parts[2]);
	   	        String equipo2 = parts[3];
	        	Equipo miequipo1= new Equipo(equipo1, "El mejor equipo");
	      		Equipo miequipo2= new Equipo(equipo2, "el peor equipo de todos");
			    Partido partido= new Partido(miequipo1, miequipo2, goles1, goles2);
	            
			   
			    //Segundo txt
			   
			    line2 = reader2.readLine()	;		    	
			    String[] parts2 = line2.split(",");		   
			    String linea1 = parts2[1];
			    String linea2 = parts2[2];
			    String linea3 = parts2[3];   
		    
			   if (linea1.equalsIgnoreCase("x")){
				   
				   Pronostico pronostico = new Pronostico(partido,miequipo1,ResultadoEnum.GANADOR);
				   
				   puntaje=puntaje+pronostico.puntos();
				 
			
			   }
			   else {
				   if (linea2.equalsIgnoreCase("x") ) {
					   
					  
					   Pronostico pronostico = new Pronostico(partido,miequipo1,ResultadoEnum.EMPATE); 
					   puntaje=puntaje+pronostico.puntos();}
				   
					   
					   
				   else {
				   
					  if(linea3.equalsIgnoreCase("x")) {
					   Pronostico pronostico = new Pronostico(partido,miequipo2,ResultadoEnum.GANADOR); 
					   puntaje=puntaje+pronostico.puntos();
					
					  
				   }
					 
				   }}
			  
	            }
			 
		  
	            System.out.println("Con su pronostico usted gano "+ puntaje + " puntos");
	            reader.close();
	            reader2.close();
	        } catch (IOException e) {
	            System.out.println("Error al leer el archivo");
	        }
       
    }
	
	
	
	
	}




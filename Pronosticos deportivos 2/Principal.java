import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		

		 
		   
				 try {
			            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Principal\\Downloads\\partidos.txt"));
			            BufferedReader reader2 = new BufferedReader(new FileReader("C:\\Users\\Principal\\Downloads\\pronosticos.txt"));
			            
			           
			          
			            String line = reader.readLine();
			            
			            String line2 = reader2.readLine();
			            
			          ArrayList<Ronda> Rondas = new ArrayList<Ronda>();
                       ArrayList<Pronostico> PronosticoMariana= new ArrayList<Pronostico>();
                       ArrayList<Pronostico> PronosticoPedro= new ArrayList<Pronostico>();
                       
                       int numero=0;
			            
			            
			           Ronda RondaActiva = new Ronda("1");
			            Ronda RondaActiva2 = new Ronda("2"); 
			            Rondas.add(RondaActiva);
			           Rondas.add(RondaActiva2);
			            
			            //Crear otro bojeto ronda y agregarlo a una lista nueva en caso que quiera crear otra ronda en el txt
			    	    
		              	
			            while (((line = reader.readLine()) != null)) {
			         
			            	 
			            	String[] parts = line.split(","); 	
				            String numeroRonda = parts[0];  
	
			            		
						      
				            
				            String equipo1 = parts[1];
						    int goles1 = Integer.parseInt(parts[2]);
						   	int goles2 = Integer.parseInt(parts[3]);
						   	String equipo2 = parts[4];
			                Equipo miequipo1= new Equipo(equipo1);
			                Equipo miequipo2= new Equipo(equipo2);
			               
			              
			                
			                int Num = Integer.parseInt(numeroRonda);	
			                
			               
			               
			                
			                
			                
			                		 
			               switch(Num) {
			                
			                
			                case 1 :  
			                        
			                	
                                    RondaActiva.agregarPartido(new Partido(miequipo1, miequipo2, goles1, goles2));
			                
			                       
			                	
			                 break;
			                 
			                case 2 : 
			                

	                              
                            RondaActiva2.agregarPartido(new Partido(miequipo1, miequipo2, goles1, goles2));
                          
                            
			                	
			                   break;
			                   
			               
			          //Agregar un case si quiero agregarle mas rondas en el txt
			   
			                }
			                	
			                		
			                	
			                		
				            	    
				            	    
			             
			            }
			            
			            
			            
			            
			           
			          

			            
			            
			            
			            while ((line2 = reader2.readLine()) != null) {
			        	 
			             
						         
					    String[] parts2 = line2.split(",");		 
					    
					    
					    String linea0 = parts2[0];
					    String linea1 = parts2[1];
					    String linea2 = parts2[2];
					    String linea3 = parts2[3];
					    String linea4 = parts2[4]; 
					    String linea5 = parts2[5]; 
					    
					    
					   
					    if (linea0.equalsIgnoreCase("Mariana")) {
					    	
					    	
					    	numero=1;
					    	
					    }
					    
					    if (linea0.equalsIgnoreCase("Pedro") )
					    {
					    	numero=2;
					    }
					    
					    
					    
					    
					    
					    
					    
					    switch(numero) {
		                
		                
		                case 1 : 
		                	
		              	
		                	if (linea2.equalsIgnoreCase("x")){
						    	Equipo equipo1= new Equipo(linea1);
								   Pronostico pronostico = new Pronostico(linea0,equipo1,ResultadoEnum.GANADOR);
								   PronosticoMariana.add(pronostico);
								 
						
							   }
							   else {
								   if (linea3.equalsIgnoreCase("x") ) {
									   
									   Equipo equipo1= new Equipo(linea1);
									   Pronostico pronostico = new Pronostico(linea0,equipo1,ResultadoEnum.EMPATE); 
									   PronosticoMariana.add(pronostico);
									   }
								   
									   
									   
								   else {
									   Equipo equipo2= new Equipo(linea5);
									  if(linea4.equalsIgnoreCase("x")) {
									   Pronostico pronostico = new Pronostico(linea0,equipo2,ResultadoEnum.GANADOR); 
									   PronosticoMariana.add(pronostico);		  
								   }
								   }
				            }
		                	
				         
		                	
		                	break;
					   
		                	
		                	
		                case 2:
		                	
		                	
		                	if (linea2.equalsIgnoreCase("x")){
						    	Equipo equipo1= new Equipo(linea1);
								   Pronostico pronostico2 = new Pronostico(linea0,equipo1,ResultadoEnum.GANADOR);
								   PronosticoPedro.add(pronostico2);
								 
						
							   }
							   else {
								   if (linea3.equalsIgnoreCase("x") ) {
									   
									   Equipo equipo1= new Equipo(linea1);
									   Pronostico pronostico2 = new Pronostico(linea0,equipo1,ResultadoEnum.EMPATE); 
									   PronosticoPedro.add(pronostico2);
									   }
								   
									   
									   
								   else {
									   Equipo equipo2= new Equipo(linea5);
									  if(linea4.equalsIgnoreCase("x")) {
									   Pronostico pronostico2 = new Pronostico(linea0,equipo2,ResultadoEnum.GANADOR); 
									   PronosticoPedro.add(pronostico2);		  
								   }
								   }
				            }
		                	
		                	
					            
		                	
		                	
		                	
		                	break;
					    }
					    
					    
					    
			            } 
			            
			            
			            
			            
			           
			            int indiceactual =0;
			             int puntaje1=0;
			        
			            
			            while( (indiceactual< PronosticoMariana.size()) ) {
			            	   
			            	  for (Ronda ronda : Rondas) {
					   //             System.out.println("Ronda " + ronda.getNro() + ":");
					                
					                for (Partido partido : ronda.getPartidos()) {
					     //               System.out.println(partido.getGolesequipo1()+ " vs " + partido.getGolesequipo2());
					                    
			                   Pronostico pronosticoActual = PronosticoMariana.get(indiceactual)	;	
			                   
			               //    System.out.println(pronosticoActual.toString());
			                 //  System.out.println(partido.toString());
			                   
			                   puntaje1=puntaje1+pronosticoActual.puntos(partido,pronosticoActual.getEquipo());
			                  
			                	
			                   indiceactual++;
			                   
			            	}
			                
			            	  }
			            }
			            
			            
			            System.out.println("El puntaje de mariana es " + puntaje1);
			            
			            
			            
			            int indiceactual2 =0; 
			            int puntaje2=0;
                       
			            
			            while( (indiceactual2< PronosticoPedro.size()) ) {
			            	   
			            	  for (Ronda ronda : Rondas) {
					    //            System.out.println("Ronda " + ronda.getNro() + ":");
					                
					                for (Partido partido : ronda.getPartidos()) {
					      //              System.out.println(partido.getGolesequipo1()+ " vs " + partido.getGolesequipo2());
					                    
			                   Pronostico pronosticoActual = PronosticoPedro.get(indiceactual2)	;	
			                   
			                //   System.out.println(pronosticoActual.toString());
			                   //System.out.println(partido.toString());
			                   puntaje2=puntaje2+pronosticoActual.puntos(partido,pronosticoActual.getEquipo());
			                   
			                	
			                   indiceactual2++;
			                   
			            	}
			                
			            	  }
			            }
			            System.out.println("El puntaje de pedro es  "+puntaje2);   
			            
			            
			                
				 
			            

			          
			            
			            
				 
				 
			            
			            reader.close();
			            reader2.close();
			        } catch (IOException e) {
			            System.out.println("Error al leer el archivo");
			        }
		       
		    
			
			
			
				 
				 
			
		}
	
	
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	
	public static void main(String[] args) {
		

		 Connection connection = null;
	        try {
	            // Paso 1: cargar la clase de controlador de JDBC de SQLite
	            Class.forName("org.sqlite.JDBC");

	            // Paso 2: crear una conexión a la base de datos
	            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Principal\\Desktop\\Tablas.db");

	            // Paso 3: crear una sentencia SQL y ejecutarla
	            Statement statementMariana = connection.createStatement(); //Crea las conexiones de mariana 
	            Statement statementPedro = connection.createStatement(); //Crea las conexiones de Pedro
	            Statement statement2Partidos1 = connection.createStatement(); // crea las conexiones de resultados(partidos)
	       
	            ResultSet resultSet2 = statement2Partidos1.executeQuery("SELECT * FROM Resultados"); // carga los resultados de la tabla partidos/resultados
	            
	            
	            statementMariana.execute("CREATE TABLE IF NOT EXISTS Pronostico_Mariana AS SELECT * FROM Pronostico WHERE participante = 'Mariana'"); //Extrae los pronosticos de mariana y crea una nueva tabla 
	            statementPedro.execute("CREATE TABLE IF NOT EXISTS Pronostico_Pedro AS SELECT * FROM Pronostico WHERE participante = 'Pedro'");// Extrae los pronosticos de pedro y crea una tabla nueva 
	            
	            ResultSet resultSetMariana = statementMariana.executeQuery("SELECT * FROM Pronostico_Mariana"); //carga los datos de la tabla mariana 
	            ResultSet resultSetPedro = statementPedro.executeQuery("SELECT * FROM Pronostico_Pedro"); // carga los datos de la tabla pedro
              
	            
	            int MarianaAcertoRonda1=0;
	            int Ronda1Mariana=0;
	            int  MarianaAcertoRonda2=0;
	           int Ronda2Mariana=0;
	          int TotalPuntajeMariana=0;
	            
	            // Paso 4: Consulto la tabla de Mariana y la de partidos 
	            while (resultSetMariana.next() && resultSet2.next()) {
	            
	           // int fase = resultSet2.getInt("fase");
	            int rondas = resultSet2.getInt("ronda");
	            int goles1 =resultSet2.getInt("goles1");
	            int goles2=resultSet2.getInt("goles2");
	            
	            String nombre1 = resultSet2.getString("equipo1");
	            String nombre2 = resultSet2.getString("equipo2");
	            Equipo equipo1 = new Equipo(nombre1);
	            Equipo equipo2 = new Equipo(nombre2);
	            
	            Partido partido = new Partido(equipo1,equipo2,goles1,goles2);
	            
	            Ronda ronda = new Ronda(rondas);
	  
	            String nombre = resultSetMariana.getString("Participante");
	            int gana1 = resultSetMariana.getInt("gana1");	
	            int gana2 = resultSetMariana.getInt("gana2");	
	            int empate = resultSetMariana.getInt("empate");	
	          
	     
	         int puntajeMariana=0;
	            if (gana1==1){
					   
					   Pronostico pronostico = new Pronostico(nombre,partido,equipo1,ResultadoEnum.GANADOR);
					   
					   puntajeMariana=puntajeMariana+pronostico.puntos();

				   }
				   else {
					   if (empate==1 ) {
						   
						  
						   Pronostico pronostico = new Pronostico(nombre,partido,equipo1,ResultadoEnum.EMPATE); 
						   puntajeMariana=puntajeMariana+pronostico.puntos();}
  
					   else {
					   
						  if(gana2==1) {
						   Pronostico pronostico = new Pronostico(nombre,partido,equipo2,ResultadoEnum.GANADOR); 
						   puntajeMariana=puntajeMariana+pronostico.puntos();					  
					   }		  
						  
	            }
					   
				   } 
	           
	            
	           switch(ronda.getNro()) {
	           
	           case 1:  Ronda1Mariana=Ronda1Mariana+1;
	        	   if (puntajeMariana==1) {
	        	    MarianaAcertoRonda1=MarianaAcertoRonda1+1;}    
	           
	        	   
	        	   break;
	        	   
	           case 2:Ronda2Mariana=Ronda2Mariana+1;
	           if (puntajeMariana==1) {
	        	    MarianaAcertoRonda2=MarianaAcertoRonda2+1;} 
	        	   break;
	        	   
	           }  
          	          		   
	            }
	            
	            
	            TotalPuntajeMariana=MarianaAcertoRonda2+MarianaAcertoRonda1;
	            
	            if( MarianaAcertoRonda1==Ronda1Mariana) {
	            TotalPuntajeMariana=TotalPuntajeMariana+2;
	            }
	            
	            if( MarianaAcertoRonda2==Ronda2Mariana) {
		            TotalPuntajeMariana=TotalPuntajeMariana+2;
		            }
	            
	            
	            if(( MarianaAcertoRonda1==Ronda1Mariana) && (MarianaAcertoRonda2==Ronda2Mariana))  { // indica que gano 1 fase completa !! 
	            	
	            	 TotalPuntajeMariana=TotalPuntajeMariana+5;
	            }
	            
	            
	            System.out.println("El participante Mariana gano  " + TotalPuntajeMariana );
	       
	                
	           
	            Statement statement2Partidos2 = connection.createStatement(); // crea las conexiones de resultados(partidos)
	 	       
	            ResultSet resultSet3 = statement2Partidos2.executeQuery("SELECT * FROM Resultados"); // carga los resultados de la tabla partidos/resultad
	            
	            
	            int PedroAcertoRonda1=0;
	            int Ronda1Pedro=0;
	            int  PedroAcertoRonda2=0;
	           int Ronda2Pedro=0;
	          int TotalPuntajePedro=0;
	            
	            // Paso 4: Consulto la tabla de Mariana y la de partidos 
	            while (resultSetPedro.next() && resultSet3.next()) {
	            
	           // int fase = resultSet2.getInt("fase");
	            int rondas = resultSet3.getInt("ronda");
	            int goles1 =resultSet3.getInt("goles1");
	            int goles2=resultSet3.getInt("goles2");
	            
	            String nombre1 = resultSet3.getString("equipo1");
	            String nombre2 = resultSet3.getString("equipo2");
	            Equipo equipo1 = new Equipo(nombre1);
	            Equipo equipo2 = new Equipo(nombre2);
	            
	            Partido partido = new Partido(equipo1,equipo2,goles1,goles2);
	            
	            Ronda ronda = new Ronda(rondas);
	          
	            String nombre = resultSetPedro.getString("Participante");
	            int gana1 = resultSetPedro.getInt("gana1");	
	            int gana2 = resultSetPedro.getInt("gana2");	
	            int empate = resultSetPedro.getInt("empate");	


	         int puntajePedro=0;
	            if (gana1==1){
					   
					   Pronostico pronostico = new Pronostico(nombre,partido,equipo1,ResultadoEnum.GANADOR);
					   
					   puntajePedro=puntajePedro+pronostico.puntos();

				   }
				   else {
					   if (empate==1 ) {
						   
						  
						   Pronostico pronostico = new Pronostico(nombre,partido,equipo1,ResultadoEnum.EMPATE); 
						   puntajePedro=puntajePedro+pronostico.puntos();}
						   
					   else {
					   
						  if(gana2==1) {
						   Pronostico pronostico = new Pronostico(nombre,partido,equipo2,ResultadoEnum.GANADOR); 
						   puntajePedro=puntajePedro+pronostico.puntos();					  
					   }		  
						  
	            }
				  
				   } 
	                  
	           switch(ronda.getNro()) {
	           
	           case 1:  Ronda1Pedro=Ronda1Pedro+1;
	        	   if (puntajePedro==1) {
	        	    PedroAcertoRonda1=PedroAcertoRonda1+1;}    
	           
	        	   
	        	   break;
	        	   
	           case 2:Ronda2Pedro=Ronda2Pedro+1;
	           if (puntajePedro==1) {
	        	    PedroAcertoRonda2=PedroAcertoRonda2+1;} 
	        	   break;
	        	   
	           }  
           		   
	            }
	                     
	            TotalPuntajePedro=PedroAcertoRonda2+PedroAcertoRonda1;
	           
	            
	            if( PedroAcertoRonda1==Ronda1Pedro) {
	            TotalPuntajePedro=TotalPuntajePedro+2;
	            }
	            
	            if( PedroAcertoRonda2==Ronda2Pedro) {
		            TotalPuntajePedro=TotalPuntajePedro+2;
		            }
	            
	            
	            if(( PedroAcertoRonda1==Ronda1Pedro) && (PedroAcertoRonda2==Ronda2Pedro))  { // indica que gano 1 fase completa !! 
	            	
	            	 TotalPuntajePedro=TotalPuntajePedro+5;
	            }
	            
	            
	            System.out.println("El participante Pedro gano  " + TotalPuntajePedro );
            
	            
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                // Paso 5: cerrar la conexión
	                if (connection != null) {
	                    connection.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        
	        
	        
	        
	    }
			
			
	        
	}	 
				 
	        

	


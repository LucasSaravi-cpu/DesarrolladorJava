
public class Pronostico {
	private String nombre;
	private Partido partido;
	private Equipo equipo;
	private ResultadoEnum resultado;
	
	
	
	
	
	
	public Pronostico(String nombre,Partido partido,Equipo equipo, ResultadoEnum resultado) {
		this.nombre = nombre;
		
		
		
		this.equipo = equipo;
		this.partido=partido;
	
		this.resultado  = resultado;
		
	}
	
	
	public Partido getPartido() {
		return partido;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public ResultadoEnum getResultado() {
		return resultado;
	}
	
	
  public String getNombre() {
		return nombre;
	}

  
  
  

@Override
public String toString() {
	return  nombre + " " + equipo +"  "+ resultado;
}


public int puntos( ) {
	  
	
	 
	  	 if (partido.Resultado(this.equipo)==this.resultado){
	  		 
	  		
	  		 
		 return 1;
		 
	 } 
		return 0;
	 

          
  }
}
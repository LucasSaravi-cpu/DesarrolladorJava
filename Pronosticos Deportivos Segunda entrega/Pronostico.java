
public class Pronostico {
	private String nombre;
	private Partido partido;
	private Equipo equipo;
	private ResultadoEnum resultado;
	
	
	
	
	
	
	public Pronostico(String nombre,Equipo equipo, ResultadoEnum resultado) {
		this.nombre = nombre;
		this.partido = partido;
		this.equipo = equipo;
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


public int puntos() {
	  
	     
	  	 if (partido.Resultado(equipo)==this.resultado){
	  		 
     
	  		 
		 return 1;
		 
	 } 
		return 0;
	 

          
  }
}

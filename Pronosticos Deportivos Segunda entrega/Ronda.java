import java.util.ArrayList;
import java.util.List;

public class Ronda {
	
	private String nro;
	private List<Partido> partidos;
	
	
	

	

	public Ronda(String nro) {
		
		this.nro=nro;
		partidos= new ArrayList<>();
	}






	public String getNro() {
		return nro;
	}



	public void setNro(String nro) {
		this.nro = nro;
	}






	public void agregarPartido(Partido partido) {
        partidos.add(partido);
    }






	public List<Partido> getPartidos() {
		return partidos;
	}






	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}
	
	

	}
	

	
	
	
	
	/* 
	  
	  Este metodo se usara en la tercer entrega para agregar puntos extras. 
	  public int puntos() {}
*/


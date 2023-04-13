import java.util.ArrayList;
import java.util.List;

public class Ronda {
	
	private int nro;
	private List<Partido> partidos;
	
	
	

	

	public Ronda(int nro) {
		
		this.nro=nro;
		this.partidos= new ArrayList<>();
	}






	public int getNro() {
		return nro;
	}



	public void setNro(int nro) {
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

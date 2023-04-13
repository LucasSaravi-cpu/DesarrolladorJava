
public class Partido {
	
	private Equipo equipo1;
	private Equipo equipo2;
	private int golesequipo1;
	private int golesequipo2;
	
  public Partido(Equipo equipo1 , Equipo equipo2 , int golesequipo1 , int golesequipo2)
   {
	   
	   this.equipo1=equipo1;
	   this.equipo2=equipo2;
	   this.golesequipo1=golesequipo1;
	   this.golesequipo2=golesequipo2;
	   
   }
   


 
   
   
public Equipo getEquipo1() {
	return equipo1;
}

public void setEquipo1(Equipo equipo1) {
	this.equipo1 = equipo1;
}

public Equipo getEquipo2() {
	return equipo2;
}

public void setEquipo2(Equipo equipo2) {
	this.equipo2 = equipo2;
}

public int getGolesequipo1() {
	return golesequipo1;
}

public void setGolesequipo1(int golesequipo1) {
	this.golesequipo1 = golesequipo1;
}

public int getGolesequipo2() {
	return golesequipo2;
}

public void setGolesequipo2(int golesequipo2) {
	this.golesequipo2 = golesequipo2;
}





@Override
public String toString() {
	return  equipo1 + "  " + equipo2 + "  " + golesequipo1 + "  "
			+ golesequipo2 ;
}






public  ResultadoEnum Resultado(Equipo equipo ) {
	  
	

	if (equipo==this.equipo1) {		
	
		if (this.golesequipo1>this.golesequipo2) {
	
		 return ResultadoEnum.GANADOR;	}
	
	else {
		if (this.golesequipo1==this.golesequipo2) {

			return ResultadoEnum.EMPATE;}
		
		else {
			if (this.golesequipo1<this.golesequipo2)  {
		 return  ResultadoEnum.PERDEDOR;}

		}
	}
	}
	
	if (equipo==this.equipo2) {		
		
		if (this.golesequipo2>this.golesequipo1) {
	
		 return ResultadoEnum.GANADOR;	}
	
	else {
		if (this.golesequipo1==this.golesequipo2) {

			return ResultadoEnum.EMPATE;}
		
		else {
			if (this.golesequipo2<this.golesequipo1)  {
		 return  ResultadoEnum.PERDEDOR;}

		}
	}
	}
	
	
	
	return null;
	
	
	
}
	
}

   

	

//ESTA CLASE EXISTE PARA GUARDAR LOS TIPOS DE DIFICULTAD QUE EXISTEN
//DETERMINAN LA DIMENSIÓN DEL TABLERO

package ar.edu.ub.tps.memotest.datos;

public class Dificultad {
	private String nivel;
	private int dimensionTablero;
	private String [] descripcion = new String[3];
	
	//SEPARO LOS METODOS PUBLICOS DE PRIVADOS
	
	//METODOS PUBLICOS 
	//-------------------------------------------------------
	public void indicarNivel(String nivelIndicado) {
		this.setNivel(nivelIndicado);
	}
	
	public String obtenerNivel() {
		return this.getNivel();
	}
	
	public int obtenerDimensionTablero() {
		return this.getDimensionTablero();
	}
	
	public String obtenerDescripcionDificultad(int nivel) {
		return this.descripcion[nivel];
	}
	
	//METODOS PRIVADOS
	//-------------------------------------------------------
	
	public Dificultad() {
		this.inicializarDescripcion();
	}
	
	private void setNivel(String nivel) {
		this.nivel = nivel;
		
		switch(nivel) {
		case "1":
			this.setDimensionTablero(4);
			break;
		case "2":
			this.setDimensionTablero(6);
			break;
		case "3":
			this.setDimensionTablero(8);
			break;
		default:
			this.setDimensionTablero(0);
		}
		
	}
	
	private void inicializarDescripcion() {
		this.descripcion[0] = "Facil   - Tablero(4x4)";
		this.descripcion[1] = "Medio   - Tablero(6x6)";
		this.descripcion[2] = "Dificil - Tablero(8x8)";
	}
	
	public String getNivel() {
		return nivel;
	}
	
	private int getDimensionTablero() {
		return dimensionTablero;
	}
	
	private void setDimensionTablero(int dimensionTablero) {
		this.dimensionTablero = dimensionTablero;
	}

	public String [] getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String [] descripcion) {
		this.descripcion = descripcion;
	}


}

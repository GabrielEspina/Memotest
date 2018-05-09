//ESTA CLASE EXISTE YA SIRVE PARA GUARDAR LA FILA Y LA COLUMNA QUE EL USUARIO INGRESA
//PARA UBICAR LA TARJETA DENTRO DEL TABLERO

package ar.edu.ub.tps.memotest.datos;

public class Coordenadas {
	private int fila;
	private int columna;
	
	
	//SEPARO LOS METODOS PUBLICOS DE PRIVADOS
	//METODOS PUBLICOS 
	//-------------------------------------------------------	
	public void indicarFila(int fila) {
		this.setFila(fila);
	}
	
	public void indicarColumna(int columna) {
		this.setColumna(columna);
	}
	
	public int obtenerFila() {
		return this.getFila();
	}
	
	public int obtenerColuma() {
		return this.getColumna();
	}
	
	//METODOS PRIVADOS
	//-------------------------------------------------------	
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public int getColumna() {
		return columna;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
}

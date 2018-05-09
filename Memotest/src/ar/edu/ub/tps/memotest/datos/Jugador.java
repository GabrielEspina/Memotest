//ESTA CLASE EXISTE PARA GUARDAR EL NOMBRE Y LOS PUNTOS DEL JUGADOR
//DE ESTA MANERA PODEMOS SABER DE QUIEN ES EL TURNO, Y QUIEN GANA EL JUEGO

package ar.edu.ub.tps.memotest.datos;
public class Jugador {

	private String nombre;
	private int puntos;
	
	//SEPARO LOS METODOS PUBLICOS DE PRIVADOS
	
	//METODOS PUBLICOS 
	//-------------------------------------------------------
	
	public void cargarJugador(String nombreIngresado) {
		this.setNombre(nombreIngresado);
		this.reiniciarPuntos();
	}
	
	public String obtenerNombre() {
		return this.getNombre();
	}
	
	public int obtenerPuntos() {
		return this.getPuntos();
	}
	
	public void reiniciarPuntos() {
		this.setPuntos(0);
	}
	
	public void sumarPuntos(int puntos) {
		this.setPuntos(this.getPuntos()+puntos);
	}
	
	//METODOS PRIVADOS
	//-------------------------------------------------------
	private String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private int getPuntos() {
		return puntos;
	}

	private void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	

}

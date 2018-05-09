//ESTA CLASE EXISTE YA QUE REPRESENTA LAS TARJETAS CON LAS QUE SE VAN A JUGAR.
//SE DEFINE UN VALOR PARA INDICAR EL CONTENIDO DE LA TARJETA
//SE DEFINE UN BOOLEANO PARA INDICAR SI LA TARJETA SE ENCUNETRA EN EL TABLERO O NO

package ar.edu.ub.tps.memotest.datos;

public class Tarjeta {
	private int valor;
	private boolean enTablero;
	
	//SEPARO LOS METODOS PUBLICOS DE PRIVADOS
	
	//METODOS PUBLICOS 
	//-------------------------------------------------------	
	
	public int obtenerValor() {
		return this.getValor();
	}
	
	public void indicarValor(int i) {
		this.setValor(i);
	}
	
	public void ponerEnTablero() {
		this.setEnTablero(true);
	}
	
	public void sacarDelTablero() {
		this.setEnTablero(false);
	}
	
	public boolean estaEnTablero() {
		return this.isEnTablero();
	}
	
	
	//METODOS PRIVADOS
	//-------------------------------------------------------	
	private int getValor() {
		return valor;
	}
	private void setValor(int valor) {
		this.valor = valor;
	}

	private boolean isEnTablero() {
		return enTablero;
	}

	private void setEnTablero(boolean enTablero) {
		this.enTablero = enTablero;
	}

	
	
}

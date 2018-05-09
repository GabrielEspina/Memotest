//ESTA CLASE EXISTE PARA UBICAR LAS CARTAS EN UN TABLERO
//SE DEFINE EL VALOR DE SU UBICACION
//UN BOOLEANO PARA INDICAR SI LA TARJETA ESTA VOLTEADA O NO
//Y UNA BANDERA, PARA SABER SI ESA TARJETA SE VOLTEA POR PRIMERA VEZ.

package ar.edu.ub.tps.memotest.datos;

public class Tablero {
	private int valor;
	private boolean tarjetaVolteada;
	private int bandera;
	//SEPARO LOS METODOS PUBLICOS DE PRIVADOS
	
	//METODOS PUBLICOS 
	//-------------------------------------------------------	
	
	public int obtenerValor() {
		return this.getValor();
	}
	
	public void indicarValor(int i) {
		this.setValor(i);
	}
	
	public boolean esTarjetaVolteada() {
		return this.isTarjetaVolteada();
	}
	
	public void volterTarjeta() {
		this.setCartaVolteada(true);
	}
	
	public void ocultarTarjeta() {
		this.setCartaVolteada(false);
	}
	public boolean volteaPorPrimerVez() {
		return this.getBandera()==1;
	}
	public void  tarjetaVolteada() {
		this.setBandera(this.getBandera()+1);
	}
	
	public void tarjetaNuncaVolteada() {
		this.setBandera(0);
	}
	
	//METODOS PRIVADOS
	//-------------------------------------------------------	
	private int getValor() {
		return valor;
	}
	private void setValor(int valor) {
		this.valor = valor;
	}
	private boolean isTarjetaVolteada() {
		return tarjetaVolteada;
	}
	private void setCartaVolteada(boolean tarjetaVolteada) {
		this.tarjetaVolteada = tarjetaVolteada;
	}

	private int getBandera() {
		return bandera;
	}

	private void setBandera(int bandera) {
		this.bandera = bandera;
	}
	
	
}

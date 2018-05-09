//ESTA CLASE CONTIENE TODOS LOS DATOS DEL JUEGO
//ACTUA COMO INTERMEDIARIO ENTRE EL DESARROLLO Y LOS DATOS PRINCIPALES
//EN JUEGO SE INICIALIZAN TODOS LOS DATOS PARA PODER JUGAR

package ar.edu.ub.tps.memotest.desarrollo;

import ar.edu.ub.tps.memotest.datos.*;

public class Juego {
	
	 public   Tarjeta     tarjet[] = new Tarjeta[64];	//CREO LAS TARJETAS DEL JUEGO
	 public   Reglas      rules    = new Reglas();	//CREO LAS REGLAS DEL JUEGO
	 public   Jugador     player[] = new Jugador[4];	//CREO LOS JUGADORES
	 public	  Tablero     board[][] = new Tablero[8][8];	//CREO EL TABLERO
	 public   Dificultad  dificulty = new Dificultad();		//CREO LOS MODOS DE DIFICULTAD
	 public	  Coordenadas cordinates[] = new Coordenadas[2];	//CREO LAS COORDENADAS INGRESADAS POR EL USUARIO
	 
	 protected static int     numberOfPlayers;
	 public Juego() {
		this.generarTarjetas();	//GENERO LAS TARJETAS
		this.generarTablero();	//GENERO EL TABLERO
		this.generarCoordenadas();	//GENERO LAS COORDENADAS
		this.generarJugadores();	//GENERO LOS JUGADORES
	}
	//SEPARO LOS METODOS PUBLICOS DE PRIVADOS
	
	//METODOS PUBLICOS 
	//-------------------------------------------------------
	public void definirCantidadJugadores(int cantidadJugadores) {
		this.setNumberOfPlayers(cantidadJugadores);
	}
	
	public int obtenerCantidadJugadores() {
		return this.getNumberOfPlayers();
	}
	

	public void sumarPuntos(int i) {//SUMO LOS PUNTOS CORRESPONDIENTES
		//SI AMBAS TARJETAS FUERON VOLTEADA POR PRIMERA VEZ ASIGNO 3 PUNTOS SI NO 1
		if(this.board[this.cordinates[0].getFila()][this.cordinates[0].getColumna()].volteaPorPrimerVez() 
				&& 	this.board[this.cordinates[1].getFila()][this.cordinates[1].getColumna()].volteaPorPrimerVez()) {
			this.player[i].sumarPuntos(3);
		}else {
			this.player[i].sumarPuntos(1);
		}
			
	
	}
	
	//LOS METODOS PUBLIC UTILIZADOS DESDE ESTE PUNTO,
	//PROTEJEN LOS METODOS DE LOS OBJETOS FUERA DEL OBJETO JUEGO.
	
	public void voltearTarjeta(Integer fila, Integer columna) {
		this.board[fila][columna].volterTarjeta();
	}
	
	public void ocultarTarjeta(Integer fila, Integer columna) {
		this.board[fila][columna].ocultarTarjeta();
		this.board[fila][columna].tarjetaNuncaVolteada();
	}
	
	public boolean esTarjetaVolteada(Integer fila, Integer columna) {
		return this.board[fila][columna].esTarjetaVolteada();
	}
	public int obtenerValorTarjeta(int fila,int columna) {
		return this.board[fila][columna].obtenerValor();
	}
	
	public boolean existeTarjeta(Integer fila, Integer columna) {
		return this.board[fila][columna]!=null;
	}
	
	public int obtenerDimensionTablero() {
		return this.dificulty.obtenerDimensionTablero();
	}
	
	public void indicarNivel(String nivel) {
		this.dificulty.indicarNivel(nivel);
	}
	
	public String obtenerDescripcionDificultad(int nivel) {
		return this.dificulty.obtenerDescripcionDificultad(nivel);
	}
	
	public String obtenerReglas() {
		return this.rules.obtenerReglas();
	}
	
	public void tarjetaIndicarValor(Integer fila, Integer columna, int valor) {
		board[fila][columna].indicarValor(valor);
	}
	
	public boolean tarjetaEstaEnTablero(int numeroTarjeta) {
		return tarjet[numeroTarjeta].estaEnTablero();
	}
	
	public void tarjetaPonerEnTablero(int numeroTarjeta) {
		tarjet[numeroTarjeta].ponerEnTablero();
	}
	
	public int tarjetaObtenerValor(int numeroTarjeta) {
		return tarjet[numeroTarjeta].obtenerValor();
	}
	
	public void coordenadasIndicarFila(int coordenada, int fila) {
		this.cordinates[coordenada].indicarFila(fila);
	}
	
	public void coordenadasIndicarColumna(int coordenada, int columna) {
		this.cordinates[coordenada].indicarColumna(columna);
	}
	
	public int coordenadasObtenerFila(int coordenada) {
		return this.cordinates[coordenada].obtenerFila();
	}
	
	public int coordenadasObtenerColumna(int coordenada) {
		return this.cordinates[coordenada].obtenerColuma();
	}
	
	//METODOS PRIVADOS
	//-------------------------------------------------------	
	private  int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	private void setNumberOfPlayers(int numberOfPlayers) {
		Juego.numberOfPlayers = numberOfPlayers;
	}
	
	private void generarTarjetas() {
		int valor = 1;
		int i;
		for ( i=0;i<64;i++) {
			tarjet[i] = new Tarjeta();
			tarjet[i].sacarDelTablero();
		}
		
		for ( i=0;i<64;i+=2) {
			tarjet[i].indicarValor(valor);
			tarjet[i+1].indicarValor(valor);
			valor++;
		}
	}
	
	private void generarTablero() {
		for(int fila=0; fila < 8; fila++) {
			for (int columna=0; columna <8;columna++) {
				board[fila][columna]= new Tablero();
			}
		}
	}
	
	private void generarCoordenadas() {
		for(int i=0;i<2;i++) {
			cordinates[i] = new Coordenadas();
		}
	}
	
	private void generarJugadores() {
		for(int i=0;i<4;i++) {
			player[i] = new Jugador();
		}
	}

}

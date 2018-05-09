//ESTA CLASE EXISTE PARA INTERACTUAR CON LA CONSOLA DE ECLIPSE
//CADA METODO CONTIENE UN PEDIDO AL USUARIO O EL MUESTREO DE DIVERSAS TABLAS / RESULTADOS / ETC.
//TAMBIEN CONTIENE MENSAJES DE ERROR, VALIDACIONES OPCIONES DE MENU

package ar.edu.ub.tps.memotest.desarrollo;

import java.util.Scanner;

public class Consola {
	protected static Scanner read= new Scanner(System.in); //OBJETO SCANNER PARA LEER LOS DATOS POR CONSOLA
	public void presentacion() {
		System.out.println("\nJUEGO MEMOTEST\n");	//MUESTRO QUE JUEGO SE VA A JUGAR
	}
	public void mostrarTablero(Juego memoTest) {
		int fila = 0;
		int columna = 0;
		int dimensionTablero = memoTest.dificulty.obtenerDimensionTablero();
		//MUESTRO EL TABLERO 
		for (int i = 0;i<dimensionTablero;i++) {//MUESTRO LA PRIMER LINEA DEL TABLERO
			System.out.print("---------");
		}
		System.out.println("");
		System.out.print("|   |");
		for (int i = 0;i<dimensionTablero;i++) {//MUESTRO LOS NUMEROS DE COLUMNAS
			System.out.print("\t" + (i+1));
		}
		
		System.out.println("  |");
		
		for (int i = 0;i<dimensionTablero;i++) {//MUESTRO LA SEGUNDA LINEA DEL TABLERO
			System.out.print("---------");
		}
		
		System.out.println("");
		
		
		for (fila=0;fila<dimensionTablero;fila++) {//MUESTRO LAS TARJETAS
			System.out.print("| "+(fila+1) + " | ");//MUESTRO LAS FILAS
			for(columna=0;columna<dimensionTablero;columna++) {
				if(memoTest.board[fila][columna].esTarjetaVolteada()) {
					System.out.print("\t" + memoTest.board[fila][columna].obtenerValor());
				}else {
					System.out.print("\tX");
				}
			}
			
			System.out.println("  |");
			if(!(fila-1 == dimensionTablero))
				System.out.println("|   |");
		}
		for (int i = 0;i<dimensionTablero;i++) {//MUESTRO LA ULTIMA LINEA DEL TABLERO
			System.out.print("---------");
		}
	}
	
	public void mostrarTurnoJugador(Juego memoTest,int numJugador) {//MUESTRO A QUE JUGADOR LE TOCA JUGAR
		System.out.println("\nTurno > " + memoTest.player[numJugador].obtenerNombre());
	}
	
	public int pedirCoordenada(String coordenada, int dimension) {//LE PIDO LA FILA Y LA COLUMNA AL USUARIO PARA UBICAR LA TARJETA
		boolean entradaOK = false; 
		String teclado;
		
		do {
			System.out.print(coordenada);
			teclado = read.next();
			try {
				;
				entradaOK = (Integer.parseInt(teclado)<(dimension+1) && Integer.parseInt(teclado)>0);
			}catch (NumberFormatException e) {
	            entradaOK = false;
	            
	        }
			if(!entradaOK)
				System.out.println("\t---Error de ingreso---");
		}while(!entradaOK);
		
		return (Integer.parseInt(teclado)-1);
	}
	
	public void mostrarTablaDeResultados(Juego memoTest) {//MUESTRO LA TABLA DE LOS RESULTADOS DE LOS JUGADORES
		
		this.separadorDeMenu();
		System.out.println("| Jugador\t| Puntos\t|");
		this.separadorDeMenu();
		for(int i =0;i<memoTest.obtenerCantidadJugadores();i++) {
			System.out.println("| " + memoTest.player[i].obtenerNombre() + "\t| "+memoTest.player[i].obtenerPuntos()+"\t\t|");
		}
		this.separadorDeMenu();
	}
	
	public void cartasCoinciden() {//MUESTRO SI LAS CARTAS COINCIDEN 
		System.out.println("\n||\tLAS CARTAS COINCIDEN\t  ||");
	}
	
	public void cartasNoCoinciden() {//MUESTRO SI LAS CARTAS NO COINCIDEN
		System.out.println("\n||\tLAS CARTAS NO COINCIDEN\t  ||");
		this.separadorDeMenu();
		System.out.println("\n");
	}
	
	public void cerrarLectura() {//CIERRO LA LACTURA DEL OBJETO SCANNER
		read.close();
	}
	
	public void abrirLectura() {//MUESTRO UN CARACTER PARA INDICARLE AL USUARIO QUE INGRESE UN DATO
		System.out.print(" > ");
	}
	
	public void separadorDeMenu() {//MUESTRO UN SEPARADOR DE MENU
		System.out.println("-----------------------------------");
	}
	
	public void pedirTarjeta(String carta) {//MUESTRO LA TARJETA QUE LE QUIERO PEDIR
		System.out.println(carta);
	}
	
	public void errorTarjeta() {//MUESTRO ERROR DE INGRESO DE TARJETA 
		System.out.println("----\n Tarjeta Incorrecta\n----");
	}
	
	public void errorOpcion() {//MUESTRO ERROR DE INGRESO DE OPCION
		System.out.println("\n--\nOpcion Incorrecta\n---\n");
	}
	
	public void errorNumero() {//MUESTRO ERROR DE INGRESO DE NUMERO
		System.out.println("----Numero Incorrecto----");
	}
	
	public void errorNombre() {//MUESTRO ERROR DE INGRESO DE NOMBRE
		System.out.println("----Nombre Incorrecto----");
	}
	
	public String pedirNivel(Juego memoTest) {//LE PIDO AL USUARIO QUE INGRESE EL NIVEL A JUGAR
		this.limpiarPantalla();
		this.separadorDeMenu();
		System.out.println("NIVEL:\n");
		System.out.print(  "1 - " + memoTest.obtenerDescripcionDificultad(0)+ "\n"+
				           "2 - " + memoTest.obtenerDescripcionDificultad(1)+ "\n"+
				           "3 - " + memoTest.obtenerDescripcionDificultad(2)+ "\n\n >");
		return  read.next();
	}
	
	public String menuInicio() {//MUESTRO EL MENUD DE INICIO
		
		this.separadorDeMenu();
		System.out.println("1 - Nuevo Juego\n"
				 + "2 - Reglas\n"
				 + "3 - Salir\n");
		
		this.abrirLectura();
		
		return read.next();
		
	}
	
	public void finDeJuego() {//MUESTRO EL FINAL DEL JUEGO - LE INDICO AL USUARIO QUE FINALIZO EL JUEGO
		System.out.println(" \n----\nGRACIAS, VUELVA PRONTO :D \n----\n");
	}
	
	public boolean jugarDeNuevo() {//PREGUNTO SI VA JUGAR DE NUEVO
		boolean entradaOK = false;
		String teclado;
		
		do {
			this.separadorDeMenu();
			System.out.println("JUGAR DE NUEVO : (mismos jugadores) \n");
			System.out.println("1 - Jugar de nuevo");
			System.out.println("0 - Menu principal");
			this.abrirLectura();
			teclado = read.next();
			
			try {
				if(Integer.parseInt(teclado)==0 || Integer.parseInt(teclado)==1  ) {
					entradaOK=true;
				}else {
					this.errorNumero();
				}
			}catch (NumberFormatException e) {
	            entradaOK = false;
	            System.out.println("---Error de ingreso---");
	        }
			
		}while(!entradaOK);
		
		return Integer.parseInt(teclado)==1;
	}
	
	public void mostrarReglas(Juego memoTest) {//MUESTRO LAS REGLAS DEL JUEGO
		System.out.println(memoTest.obtenerReglas());
	}
	
	public int pedirCantidadJugadores() {//LE PIDO LA CANTIDAD DE JUGADORES QUE VAN A JUGAR
		boolean entradaOK = false;
		String teclado;
		
		this.limpiarPantalla();
		do {
			
			this.separadorDeMenu();
			System.out.print("CANTIDAD JUGADORES (MAX 4): ");
			teclado = read.next();
			try {
				if(Integer.parseInt(teclado)<=4 && Integer.parseInt(teclado)>1 ) {
					entradaOK=true;
				}else {
					this.errorNumero();
				}
			}catch (NumberFormatException e) {
	            entradaOK = false;
	            System.out.println("---Error de ingreso---");
	        }
			
		}while(!entradaOK);
		
		return Integer.parseInt(teclado);
	}
	
	public String pedirNombreJugador(int numJugador) {//LE PIDO EL NOMBRE DEL JUGADOR AL USUARIO
		System.out.print("\tNombre Jugador " +(numJugador+1)+ " (PRIMERAS 6 LETRAS): ");			//PIDO LOS NOMBRES DE LOS JUGADORES		
		this.abrirLectura();
		String nombreJugador = read.next().toUpperCase();
		if(nombreJugador.length()<6) {
			this.errorNombre();
			return pedirNombreJugador(numJugador);
		}
		return nombreJugador.substring(0, 6);
	}
	
	public void limpiarPantalla() {//LIMPIO LA PANTALLA DE LA CONSOLA
		for(int i=0;i<100;i++) {
			System.out.println("");
		}
	}
	
	public void esperar(int seg) {//REALIZA UNA PAUSA DE TANTOS SEGUNDOS INDICADOS EN LA CONSOLA
		try{
			System.out.println("Termina su turno....");
			Thread.sleep(seg*1000);
		}catch(Exception e){
			seg=0;
		}
		
	}
}

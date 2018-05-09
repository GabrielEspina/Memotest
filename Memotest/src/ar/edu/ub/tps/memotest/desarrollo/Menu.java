//ESTA CLASE REALIZA EL MENU
//SE DEFINE EL OBJETO CONSOLA PARA PODER INTERACTUAR CON EL USUARIO

package ar.edu.ub.tps.memotest.desarrollo;

public class Menu {
	Consola console = new Consola();
	
	//SEPARO LOS METODOS PUBLICOS DE PRIVADOS
	//METODOS PUBLICOS 
	//-------------------------------------------------------	
	public void menuInicio(Juego memoTest) {
		boolean sigaJugando;	//VARIABLE PARA DEFINIR SI EL USUARIO SIGUE JUGANDO
		String opcionMenuInicio;	//VARIABLE QUE RECIBE UNA OPCION DESDE EL OBJETO CONSOLA
		Desarrollo	desarrolloJuego = new Desarrollo();		//OBJETO DESARROLLO DONDE SE EJECUTARA EL JUEGO
		console.limpiarPantalla();	//LIMPIO LA PANTALLA ANTES DE MOSTRAR EL MENU
		do {
			
			sigaJugando = true;		
			console.presentacion(); //MUESTRA QUE JUEGO SE VA A JUGAR
			
			opcionMenuInicio = console.menuInicio();	//MUESTRA EL MENU Y DEVUELVE LA RESPUESTA DADA POR EL USUARIO
	
			switch(opcionMenuInicio) {	//DEPENDIENDO QUE OPCION DEVUELVE EL USUARIO SE LLEVA A CABO DISTINTAS FUNCIONES
				case "1":
					this.NuevoJuego(memoTest);	//SE LLEVA A CABO LA INICIALIZACION DEL JUEGO
					desarrolloJuego.iniciar(memoTest); //SE LLEVA A CABO EL JUEGO
					break;
				case "2":
					console.limpiarPantalla();	//SE LIMPIA LA PANTALLA POR CONSOLA
					console.mostrarReglas(memoTest); //SE MUESTRAN LAS REGLAS
					break;	
				case "3":
					console.finDeJuego();	//TERMINA EL JUEGO - MUESTRA AL USUARIO QUE TERMINO EL JUEGO
					sigaJugando = false;
					break;
				default: 
					console.errorOpcion(); 	//MUESTRA UN ERROR POR CONSOLA
			}
			
		}while(sigaJugando);	//EL MENU SE REPITE MIENTRAS EL USUARIO NO SALGA O QUIERA SEGUIR JUGANDO
	}
	
	//METODOS PRIVADOS
	//-------------------------------------------------------		
	private void NuevoJuego(Juego memoTest) {
		this.menuElegirNivel(memoTest);		//SE ELIGE EL NIVEL DEL JUEGO
		this.menuCrearJugador(memoTest);	//SE CREAN LOS JUGADORES
		
	}
	
	private void menuCrearJugador(Juego memoTest) {
		int cantidadJugadores = console.pedirCantidadJugadores();	//SE PIDEN EL NUMERO DE JUGADORES
		memoTest.definirCantidadJugadores(cantidadJugadores);		//SE INDICA EN EL OBJETO CUANTOS JUGADORES SON
		
		for(int i=0;i<memoTest.obtenerCantidadJugadores();i++) {	//ESTRUCTURA QUE VA DESDE 0 HASTA LA CANTIDAD DE JUGADORES
			memoTest.player[i].cargarJugador(console.pedirNombreJugador(i)); //SE CARGA EL NOMBRE DEL JUGADOR PEDIDO POR CONSOLA
		}
	console.limpiarPantalla(); // SE LIMPIA LA PANTALLA DE LA CONSOLA 
	}
	
	private void menuElegirNivel(Juego memoTest) {
		boolean opcionIncorrecta;	//BOOLEANO PARA DETERMINAR SI LA OPCION INGRESARA ES CORRECTA
		String opcionNivel;			//ME DEFINE LA OPCION OTORGADA POR EL OBJETO CONSOLA
		do {
			opcionIncorrecta = false;
			
			opcionNivel = console.pedirNivel(memoTest);		//PIDO POR CONSOLE QUE INGRESE EL NIVEL A JUGAR
			console.separadorDeMenu();	//REALIZA UNA LINEA PARA SEPARAR EL MENU
			
			switch(opcionNivel) {	//DEPENDIENDO LA OPCION SE DEFINE EL NIVEL DEL JUEGO
				case "1" :
					memoTest.indicarNivel(opcionNivel);
					break;
				case "2":
					memoTest.indicarNivel(opcionNivel);
					break;
				case "3":
					memoTest.indicarNivel(opcionNivel);
					break;
				default:
					console.errorOpcion();
					opcionIncorrecta = true;
			}
		}while(opcionIncorrecta);	//LA ESTRUCTURA SIGUE HASTA QUE LA OPCION SEA CORRECTA
		
	}
	
}

//EN ESTA CLASE SE LLEVA A CABO EL DESARROLLO DEL JUEGO INTERACTUANDO CON LA CLASE CONSOLA
//PARA JUGAR CON EL USUARIO, Y CON LA CLASE JUEGO PARA OBTENER LOS DATOS DEL JUEGO
//SE DEFINE UN ALEATORIO PARA PODER MEZCLAR LAS TARJETAS EN EL TABLERO
//Y SE DEFINE LA CLASE CONSOLA PARA INTERACTUAR

package ar.edu.ub.tps.memotest.desarrollo;
import java.util.Random;
public class Desarrollo {
	
	private Random aleatorio = new Random(System.currentTimeMillis());
	Consola console = new Consola();
	
	//SEPARO LOS METODOS PUBLICOS DE PRIVADOS
	//METODOS PUBLICOS 
	//-------------------------------------------------------	
	
	public void iniciar(Juego memoTest) {	//INICIA EL JUEGO MEMOTEST
		this.agarrarTarjetas(memoTest);		//SACA LAS CARTAS DEL TABLERO
		this.mezclarCartas(memoTest);		//MEZCLA LAS CARTAS Y LAS REPARTE EN EL TABLERO ALEATORIAMENTE
		this.comenzarPartida(memoTest);		//DA COMIENZO A LA PARTIDA DEL JUEGO MEMOTEST
		if(console.jugarDeNuevo()) 			//PREGUNTA SI SE VA JUGAR DE NUEVO
			iniciar(memoTest);				//EN CASO DE JUGAR SE INICIA EL JUEGO OTRA VEZ
	}
	
	
	//METODOS PRIVADOS
	//-------------------------------------------------------	
	
	public void comenzarPartida(Juego memoTest) {	//DA COMIENZO A LA PARTIDA
		while(this.existenCartasOcultas(memoTest)) {	//PREGUNTA SI EXISTEN CARTAS OCULTAS
			this.jugarPartidas(memoTest);					//EN CASO DE EXISTIR DA COMIENZO A LA PARTIDA
		}
		console.mostrarTablaDeResultados(memoTest);		//MUESTRA LOS RESULTADOS FINALES
	}
	

	public void agarrarTarjetas(Juego memoTest) {	
		for(int i=0;i<(memoTest.obtenerDimensionTablero()*memoTest.obtenerDimensionTablero());i++) {
			memoTest.tarjet[i].sacarDelTablero();	//SACA LAS CARTAS DEL TABLERO
		}
				
		for(int i=0;i<memoTest.obtenerCantidadJugadores();i++) {
			memoTest.player[i].reiniciarPuntos();	//REINCIIA LOS PUNTOS DE LOS JUGADORES
		}
	}
	
	private void jugarPartidas(Juego memoTest) {	//COMIENZA LA PARTIDA CON LOS JUGADORES
		
		for(int i=0;i<memoTest.obtenerCantidadJugadores();i++) { //ESTRUCTURA QUE RECORRE LOS TURNOS
			console.limpiarPantalla();	//LIMPIA LA PANTALLA DE LA CONSOLA
			if( existenCartasOcultas(memoTest)) {	//PREGUNTA SI EXISTEN CARTAS OCULTAS
				console.mostrarTablaDeResultados(memoTest);	//MUESTRA EL TABLERO DE JUGADORES
				console.mostrarTurnoJugador(memoTest, i);	//MUESTRA DE QUIEN ES EL TURNO
				console.mostrarTablero(memoTest);	//MUESTRA EL TABLERO DE TARJETAS 
				
				this.pedirTarjetas(memoTest); //PIDE DOS TARJETAS DEL TABLERO

				if(this.sonTarjetasIguales(memoTest)) { //SI LAS TARJETAS SON IGUALES
					console.cartasCoinciden();	//MUESTRO QUE LAS CARTAS COINCIDEN
					memoTest.sumarPuntos(i); //ASIGNA LOS PUNTOS CORRESPONDIENTES
					memoTest.voltearTarjeta(memoTest.coordenadasObtenerFila(0), memoTest.coordenadasObtenerColumna(0));//VOLTEA LA TARJETA
					memoTest.voltearTarjeta(memoTest.coordenadasObtenerFila(1), memoTest.coordenadasObtenerColumna(1));//VOLTEA LA TARJETA
				}else {	//SI LAS CARTAS NO SON IGUALES
					console.cartasNoCoinciden();//MUESTRA QUE NO COINCIDEN LAS TARJETAS
					memoTest.ocultarTarjeta(memoTest.coordenadasObtenerFila(0), memoTest.coordenadasObtenerColumna(0));//OCULTA LA TARJETA
					memoTest.ocultarTarjeta(memoTest.coordenadasObtenerFila(1), memoTest.coordenadasObtenerColumna(1));//OCULTA LA TARJETA
				}
			}else {//SI NO HAY MAS CARTAS OCULTAS
				i=memoTest.obtenerCantidadJugadores(); //IGUALO LA VARIABLE DE LA ESTRUCTURA PARA TERMINAR LA PARTIDA
				
			}
			
			console.esperar(3);//DOY TIEMPO AL USUARIO A REVISAR LA TABLA, LUEGO PASA DE TURNO
		}
	}
	
	
	
	private boolean sonTarjetasIguales(Juego memoTest ) {//CHEQUEA SI LAS TARJETAS SON IGUALES
		//PREGUNTO SI LOS VALORES DE LAS TARJETAS SON IGUALES
		if(memoTest.obtenerValorTarjeta(memoTest.coordenadasObtenerFila(0), memoTest.coordenadasObtenerColumna(0))
				== memoTest.obtenerValorTarjeta(memoTest.coordenadasObtenerFila(1), memoTest.coordenadasObtenerColumna(1))) 
			return true;//EN CASO DE SER IGUALES DEVUELVE TRUE
		return false;//SI NO DEVUELVE FALSE
	}
	
	private void pedirTarjetas(Juego memoTest) {	//LE PIDO LAS TARJETAS AL USUARIO
		for(int i=0;i<2;i++) {	//PIDO DOS TARJETAS 
			do {
				console.pedirTarjeta("\nElegir Tarjeta "+ (i+1));	//PIDO LA TARJETA CORRESPONDIENTE
				memoTest.coordenadasIndicarFila(i, console.pedirCoordenada("\tFila: ",memoTest.obtenerDimensionTablero()));	//ASIGNO LA FILA
				memoTest.coordenadasIndicarColumna(i, console.pedirCoordenada("\tColumna: ",memoTest.obtenerDimensionTablero()));	//ASIGNO LA COLUMNA
			}while(!this.esTarjetaValida(memoTest,memoTest.coordenadasObtenerFila(i),memoTest.coordenadasObtenerColumna(i)));	//LA ESTRUCTURA SIGUE SI LA TARJETA NO ES VALIDA
			
			console.limpiarPantalla();	//LIMPIO LA PANTALLA
			memoTest.voltearTarjeta(memoTest.coordenadasObtenerFila(i), memoTest.coordenadasObtenerColumna(i));	//VOLTEA LA TARJETA
			memoTest.board[memoTest.coordenadasObtenerFila(i)][memoTest.coordenadasObtenerColumna(i)].tarjetaVolteada();	//INDICA QUE YA FUE VOLTEADA
			console.mostrarTablero(memoTest);	//MUESTRA EL TABLERO
		}
		
		
	}
	
	private boolean esTarjetaValida(Juego memoTest,int fila,int columna) {	//DEVUELVE SI LA TARJETA ES VALIDA
		if((fila<memoTest.obtenerDimensionTablero() && columna<memoTest.obtenerDimensionTablero()))//PREGUNTA SI LA TARJETA SE ENCUENTRA EN LOS RANGOS PEDIDOS
			if(memoTest.existeTarjeta(fila, columna) && !memoTest.esTarjetaVolteada(fila, columna)) //PREGUNTA SI LA TARJETA YA ESTA VOLTEADA
				return true;
		console.errorTarjeta();//SI NO MUESTRA ERROR DE TARJETA
		return false;
	}
	
	private boolean existenCartasOcultas(Juego memoTest) {	//PREGUNTO SI HAY CARTAS OCULTAS
		
		int dimensionTablero = memoTest.obtenerDimensionTablero();	//OBTENGO LA DIMENSION DEL TABLERO
		
		for(int fila=0;fila<dimensionTablero;fila++) {
			for(int columna=0;columna<dimensionTablero;columna++) {
				if(!memoTest.esTarjetaVolteada(fila, columna)) {	//PREGUNTO SI HAY CARTAS NO VOLTEADAS
					return true;
				}
			}
		}
		
		return false;
	}
	
	private void mezclarCartas(Juego memoTest) {	//MEZCLO LAS CARTAS Y LAS ASIGNO AL TABLERO
		int fila = 0;
		int columna = 0;
		int dimensionTablero = memoTest.obtenerDimensionTablero();
		
		for (fila=0;fila<dimensionTablero;fila++) {
			for(columna=0;columna<dimensionTablero;columna++) {
				memoTest.tarjetaIndicarValor(fila,columna,obtenerTarjetaRandom(memoTest,dimensionTablero));	//LLENO EL TABLERO DE FORMA ALEATORIA
				memoTest.ocultarTarjeta(fila, columna);	//OCULTO LA TARJETA
			}
		}
	}
	
	private int obtenerTarjetaRandom(Juego memoTest, int dimensionTablero) {//PIDO UNA TARJETA RANDOM
		
		int tarjetaRandom = aleatorio.nextInt(dimensionTablero * dimensionTablero); //ASIGNO UN NUMERO ALEATORIO ENLOS RANGOS PEDIDOS
		
		if(memoTest.tarjetaEstaEnTablero(tarjetaRandom)) {	//SI LA TARJETA ESTA EN EL TABLERO
			return obtenerTarjetaRandom(memoTest,dimensionTablero);	//VUELVO A PEDIR OTRA TARJETA
		}
		
		memoTest.tarjetaPonerEnTablero(tarjetaRandom);	//PONGO LA TARJETA EN EL TABLERO
		return memoTest.tarjetaObtenerValor(tarjetaRandom);	//DEVUELVO EL VALOR DE LA TARJETA
		
	}
	
}

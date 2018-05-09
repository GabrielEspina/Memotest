//ESTA CLASE EXISTE PARA GUARDAR LAS REGLAS DEL JUEGO
//SE PUEDE ACCEDER A ELLAS EN LA OPCION 2 DEL MENU PRINCIPAL 

package ar.edu.ub.tps.memotest.datos;

public class Reglas {

	private String reglas;
	
	//SEPARO LOS METODOS PUBLICOS DE PRIVADOS
	
	//METODOS PUBLICOS 
	//-------------------------------------------------------
	
	public String obtenerReglas() {
		return this.getReglas();
	}		
	
	
	
	public Reglas() {
		
		this.setReglas("Objetivo : Volter Tarjetas e intentar encontrar las identicas.\n\n"
				
					 + "Como Jugar: Indicar Fila y Columna para ubicar las tarjeta en el tablero. \n\n"
					 
					 + "Dificultad: 3 Niveles >> Facil - Medio - Dificil\n\n"
					 
					 + "Juego Multijugador: Un jugador por turno. 4 Jugadores Maximo\n\n"
					 
					 + "En caso de encontrar una coincidencia,\n" 
					 + "  se otorgará un punto al jugador que la haya encontrado.\n\n"
					 
					 + "Si lo hizo al voltear cada tarjeta por primera vez, recibirá 3 puntos.\n\n");
	}
	
	//METODOS PRIVADOS
	//-------------------------------------------------------
	private String getReglas() {
		return reglas;
	}

	private void setReglas(String reglas) {
		this.reglas = reglas;
	}
	
}

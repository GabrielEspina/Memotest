//GABRIEL ESPINA - TESTING Y PRUEBA DE SOFTWARE
//UNIVERSIDAD DE BELGRANO
//TECNICATURA SUPERIOR DE PROGRAMACION DE COMPUTADORAS
//TAREA OBLIGATORIA : DESARROLLAR EL JUEGO MEMOTEST

//ESTA CLASE CONTIENE EL MAIN DEL PROGRAMA, DONDE INICIA EL MISMO
//SE DEFINE EL OBJETO JUEGO QUE CONTIENE TODOS LOS DATOS DEL MEMOTEST
//SE DEFINE EL OBJETO MENU QUE CONTIENE LOS MENUES, QUE LE DARAN OPCIONES AL USUARIO

package ar.edu.ub.tps.memotest.inicio;
import ar.edu.ub.tps.memotest.desarrollo.*;

public class Aplication {

	public static void main(String[] args) {
		Juego 		memoTest = new Juego();
		Menu 	 	menu = new Menu();	
		
		menu.menuInicio(memoTest);	//SE ENVIA EL JUEGO AL MENU DEL PROGRAMA
	}

}
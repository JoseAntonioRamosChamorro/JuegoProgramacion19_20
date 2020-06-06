package juego;

public class Main {

	public static void main(String[] args) {
		//vistas
		VistaInicio VInicio = new VistaInicio();
		VistaMejorJugador VMejorJugador = new VistaMejorJugador();
		VistaPedirNombre VPedirNombre = new VistaPedirNombre();
		VistaGameSolo VGameSolo = new VistaGameSolo();
		//Modelo
		Modelo modelo = new Modelo();
		//Controlador
		new Controlador(VInicio,VMejorJugador,VPedirNombre,VGameSolo,modelo);

	}

}

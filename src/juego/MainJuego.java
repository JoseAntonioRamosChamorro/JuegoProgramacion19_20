package juego;

public class MainJuego {

	public static void main(String[] args) {
		VistaInicio Invista = new VistaInicio();
		VistaMejorJugador VistMejrJugr = new VistaMejorJugador();
		VistaNuevaPartida VistNuevPart = new VistaNuevaPartida();
		VistaGame Vistagm = new VistaGame();
		ModeloJuego ModJuego = new ModeloJuego();
		
		new ControladorJuego(Invista,VistMejrJugr,VistNuevPart,Vistagm,ModJuego );
		
	 

	}

}

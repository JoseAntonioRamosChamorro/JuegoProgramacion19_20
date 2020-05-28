package juego;

import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.sql.Connection;

public class VistaGame extends Frame{
	private static final long serialVersionUID = 1L;
	Choice cho = new Choice();
	Panel pntop = new Panel();
	Panel pnmid = new Panel();
	Panel pnbot = new Panel();

	Label lbjd = new Label("Elegid Jugada:");
	Choice chpj1 = new Choice();
	Choice chpj2 = new Choice();

	Button btnStart = new Button("Comparar");
	Button btnVol = new Button("Volver");


	Label lbpj1 = new Label();
	Label lbpj2 = new Label();
	String j1;
	String j2;
	public VistaGame() {
		Connection con = ModeloJuego.conectar();
		setLayout(new FlowLayout());
		setSize(350,200);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("En partida");	
		//Nombres
		ModeloJuego.rellenarLabelj1(con,lbpj1);
		ModeloJuego.rellenarLabelj2(con,lbpj2);
		 j1 = lbpj1.getText();
		 j2 = lbpj2.getText();
		//Rellenar choice 1
		chpj1.add("Seleccionar 1");
		chpj1.add("Piedra");
		chpj1.add("Papel");
		chpj1.add("Tijeras");
		//Rellenar choice 2
		chpj2.add("Seleccionar 1");
		chpj2.add("Piedra");
		chpj2.add("Papel");
		chpj2.add("Tijeras");
		pntop.add(lbjd);
		add(pntop);
		pnmid.add(lbpj1);
		pnmid.add(chpj1);
		pnmid.add(lbpj2);
		pnmid.add(chpj2);
		add(pnmid);

		pnbot.add(btnStart);
		pnbot.add(btnVol);
		add(pnbot);

	}
	
}

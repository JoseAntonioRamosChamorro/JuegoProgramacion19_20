package juego;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class VistaNuevaPartida extends Frame{
	private static final long serialVersionUID = 1L;
	Button btnComenzar = new Button("Comenzar");
	Button btnVolver = new Button("Volver");
	Label ply1 = new Label("Jugador1");
	Label ply2 = new Label("Jugador2");
	TextField txpl1 = new TextField(5);
	TextField txpl2 = new TextField(5);
	public VistaNuevaPartida() {
		setLayout(new FlowLayout());
		setSize(200,200);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Nueva Partida");	

		add(ply1);
		add(txpl1);

		add(ply2);
		add(txpl2);

		add(btnComenzar);
		add(btnVolver);
		}

}

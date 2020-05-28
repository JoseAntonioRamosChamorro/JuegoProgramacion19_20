package juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.sql.Connection;

import javax.swing.JOptionPane;


public class ControladorJuego implements WindowListener, ActionListener{
	VistaInicio Invista = null;
	ModeloJuego ModJuego = null;
	VistaMejorJugador VistMejrJugr = null;
	VistaNuevaPartida VistNuevPart = null;
	VistaGame Vistagm = null;

	public ControladorJuego(VistaInicio invista, VistaMejorJugador vistMejrJugr,
			VistaNuevaPartida vistNuevPart, VistaGame vistagm, ModeloJuego modJuego) {

		Invista = invista;
		ModJuego = modJuego;
		VistMejrJugr = vistMejrJugr;
		VistNuevPart = vistNuevPart;
		Vistagm = vistagm;
		invista.addWindowListener(this);
		vistMejrJugr.addWindowListener(this);
		vistNuevPart.addWindowListener(this);
		vistagm.addWindowListener(this);
		Connection con = ModeloJuego.conectar();
		//Pantalla Inicio
		invista.ayuda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try
				{
					Runtime.getRuntime().exec("hh.exe Ayuda.chm");
				}
				catch (IOException e1)
				{
					e1.printStackTrace();
				}

			}
		});
		//boton mejor jugador
		invista.BtnMJ.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vistMejrJugr.setVisible(true);

			}
		});
		//boton nueva partida
		invista.BtnNP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vistNuevPart.setVisible(true);

			}
		});
		//Pantalla Mejor Jugador
		vistMejrJugr.btVolver.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				vistMejrJugr.setVisible(false);
				
			}
		});
		//Pantalla Nueva Partida
		vistNuevPart.btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vistNuevPart.setVisible(false);

			}
		});
		vistNuevPart.btnComenzar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Connection con = ModeloJuego.conectar();
				int empezar1 = modJuego.jugador1(con, vistNuevPart.txpl1.getText());
				int empezar2 = modJuego.jugador2(con, vistNuevPart.txpl2.getText());
				if(empezar1 == 0 && empezar2 ==0)
				{
					JOptionPane.showMessageDialog(null, "Empezando Partida");
					vistagm.setVisible(true);

					vistNuevPart.setVisible(false);
				}
				else
				{
					System.out.println("Error en ALTA");
				}
				// Desconectar de la base
				ModeloJuego.desconectar(con);
			}
		});
		
		//Pantalla Game
		vistagm.btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String elec1 = vistagm.chpj1.getSelectedItem();
				System.out.println("Eleccion del jugador 1 es "+elec1);

				String elec2 = vistagm.chpj2.getSelectedItem();
				System.out.println("Eleccion del jugador 2 es "+elec2);
				//eleccion piedra principal
				if (elec1 == "Piedra" && elec2 == "Piedra") {
					JOptionPane.showMessageDialog(null, "Empate");
				}else if (elec1 == "Piedra" && elec2 == "Papel") {

					JOptionPane.showMessageDialog(null, "Gano "+vistagm.j2);
					modJuego.BorrarP1(con, vistagm.lbpj1);
					vistagm.setVisible(false);
					modJuego.InsertarP2(con, vistagm.j2);
				}else if (elec1 == "Piedra" && elec2 == "Tijeras") {

					JOptionPane.showMessageDialog(null, "Gano "+vistagm.j1);
					modJuego.BorrarP2(con, vistagm.lbpj2);
					vistagm.setVisible(false);
					modJuego.InsertarP1(con, vistagm.j1);
				}
				//Eleccion Papel principal
				else if (elec1 == "Papel" && elec2 == "Piedra") {

					JOptionPane.showMessageDialog(null, "Gano "+vistagm.j1);
					modJuego.BorrarP2(con, vistagm.lbpj2);
					vistagm.setVisible(false);
					modJuego.InsertarP1(con, vistagm.j1);
				}else if (elec1 == "Papel" && elec2 == "Papel") {

					JOptionPane.showMessageDialog(null, "Empate");
				}else if (elec1 == "Papel" && elec2 == "Tijeras") {

					JOptionPane.showMessageDialog(null, "Gano "+vistagm.j2);
					modJuego.BorrarP1(con, vistagm.lbpj1);
					vistagm.setVisible(false);
					modJuego.InsertarP2(con, vistagm.j2);
				}
				//Eleccion Tijeras principal
				else if (elec1 == "Tijeras" && elec2 == "Piedra") {

					JOptionPane.showMessageDialog(null, "Gano "+vistagm.j2);
					modJuego.BorrarP1(con, vistagm.lbpj1);
					vistagm.setVisible(false);
					modJuego.InsertarP2(con, vistagm.j2);
				}else if (elec1 == "Tijeras" && elec2 == "Papel") {

					JOptionPane.showMessageDialog(null, "Gano "+vistagm.j1);
					modJuego.BorrarP2(con, vistagm.lbpj2);
					vistagm.setVisible(false);
					modJuego.InsertarP1(con, vistagm.j1);
				}else if (elec1 == "Tijeras" && elec2 == "Tijeras") {

					JOptionPane.showMessageDialog(null, "Empate");
				}
			}
		});
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}

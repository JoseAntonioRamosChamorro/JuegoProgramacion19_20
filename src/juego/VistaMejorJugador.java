package juego;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.sql.Connection;

public class VistaMejorJugador extends Frame{
	private static final long serialVersionUID = 1L;
	TextArea consulta = new TextArea(10,30);
	Button btVolver = new Button("Cerrar");
	public VistaMejorJugador() {
		setSize(300,300);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Ultimos Ganadores");
		setLayout(new FlowLayout());
		Connection con = Modelo.conectar();
		Modelo.rellenarTextArea(con, consulta);
		Modelo.desconectar(con);
		consulta.setEditable(false);
		add(consulta);
		add(btVolver);
	}
}

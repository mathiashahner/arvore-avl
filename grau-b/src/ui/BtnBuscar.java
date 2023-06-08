package ui;

import java.awt.Cursor;

import javax.swing.JButton;

public class BtnBuscar extends JButton {

	private static final long serialVersionUID = 1L;

	public BtnBuscar() {
		super("Buscar");
		setBounds(375, 0, 90, 25);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
}
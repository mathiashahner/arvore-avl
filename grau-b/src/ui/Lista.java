package ui;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.border.LineBorder;

public class Lista extends JList<String> {

	private static final long serialVersionUID = 1L;

	public Lista() {
		super();
		personalizarLista();
	}

	public Lista(DefaultListModel<String> elementos) {
		super(elementos);
		personalizarLista();
	}

	private void personalizarLista() {
		setBounds(5, 30, 460, 265);
		setBorder(new LineBorder(new Color(128, 128, 128)));
	}
}

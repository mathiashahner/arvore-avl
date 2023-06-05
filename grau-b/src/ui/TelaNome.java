package ui;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class TelaNome extends JPanel {

	private static final long serialVersionUID = 1L;

	public TelaNome() {

		super();

		InputTexto inputNome = new InputTexto("Buscar por nome...");
		inputNome.setMargin(new Insets(2, 5, 2, 5));
		inputNome.setBounds(5, 0, 460, 25);

		JList list = new JList();
		list.setBorder(new LineBorder(new Color(128, 128, 128)));
		list.setBounds(5, 30, 460, 265);

		setBounds(0, 35, 470, 300);
		setVisible(true);
		setLayout(null);
		add(inputNome);
		add(list);
	}
}

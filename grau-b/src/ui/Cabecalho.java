package ui;

import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Cabecalho extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton btnNome = new JButton("Nome");
	private JButton btnCpf = new JButton("CPF");
	private JButton btnDataNascimento = new JButton("Data de nascimento");

	public Cabecalho() {

		super();

		btnNome.setBounds(5, 5, 150, 25);
		btnNome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnCpf.setBounds(160, 5, 150, 25);
		btnCpf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnDataNascimento.setBounds(315, 5, 150, 25);
		btnDataNascimento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		setBounds(0, 0, 470, 35);
		setLayout(null);
		add(btnNome);
		add(btnCpf);
		add(btnDataNascimento);
	}

	public JButton getBtnNome() {
		return btnNome;
	}

	public JButton getBtnCpf() {
		return btnCpf;
	}

	public JButton getBtnDataNascimento() {
		return btnDataNascimento;
	}
}

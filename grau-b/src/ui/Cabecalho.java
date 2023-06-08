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

		btnNome = new BtnHeader("Nome", 5, 5);
		btnCpf = new BtnHeader("CPF", 200, 5);
		btnDataNascimento = new BtnHeader("Data de nascimento", 395, 5);

		setBounds(0, 0, 590, 35);
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

	private class BtnHeader extends JButton {

		private static final long serialVersionUID = 1L;

		public BtnHeader(String texto, int x, int y) {
			super(texto);
			setBounds(x, y, 190, 25);
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
	}
}

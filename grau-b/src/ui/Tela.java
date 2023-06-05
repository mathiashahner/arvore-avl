package ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;

	private Cabecalho cabecalho = new Cabecalho();
	private TelaNome telaNome = new TelaNome();
	private TelaCpf telaCpf = new TelaCpf();
	private TelaDataNascimento telaDataNascimento = new TelaDataNascimento();

	public Tela() {
		setupTela();
		setupListeners();
		setupFrame();
	}

	private void setupTela() {
		Container tela = getContentPane();
		tela.setLayout(null);
		tela.add(cabecalho);
		tela.add(telaNome);
		tela.add(telaCpf);
		tela.add(telaDataNascimento);
	}

	private void setupFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(486, 374));
		setLocationRelativeTo(null);
		setTitle("Árvore AVL");
		setResizable(false);
		setVisible(true);
	}

	private void setupListeners() {

		cabecalho.getBtnNome().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				telaNome.setVisible(true);
				telaCpf.setVisible(false);
				telaDataNascimento.setVisible(false);
			}
		});

		cabecalho.getBtnCpf().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				telaNome.setVisible(false);
				telaCpf.setVisible(true);
				telaDataNascimento.setVisible(false);
			}
		});

		cabecalho.getBtnDataNascimento().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				telaNome.setVisible(false);
				telaCpf.setVisible(false);
				telaDataNascimento.setVisible(true);
			}
		});
	}
}

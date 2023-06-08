package ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import arvore.ArvoreBinaria;
import main.Pessoa;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;

	private Cabecalho cabecalho;
	private TelaNome telaNome;
	private TelaCpf telaCpf;
	private TelaDataNascimento telaDataNascimento;
	protected List<Pessoa> pessoas;

	public Tela(List<ArvoreBinaria<?>> arvoresBinarias, List<Pessoa> pessoas) {

		this.pessoas = pessoas;
		cabecalho = new Cabecalho();
		telaNome = new TelaNome(arvoresBinarias.get(0));
		telaCpf = new TelaCpf(arvoresBinarias.get(1));
		telaDataNascimento = new TelaDataNascimento(arvoresBinarias.get(2));

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

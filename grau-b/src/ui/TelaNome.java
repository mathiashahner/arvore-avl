package ui;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;

import arvore.ArvoreBinaria;
import main.Pessoa;

public class TelaNome extends JPanel {

	private static final long serialVersionUID = 1L;

	private ArvoreBinaria<?> arvoreString;

	public TelaNome(ArvoreBinaria<?> arvoreString) {

		super();
		this.arvoreString = arvoreString;

		InputTexto inputNome = new InputTexto("Buscar por nome...");
		inputNome.setBounds(5, 0, 365, 25);

		BtnBuscar btnBuscar = new BtnBuscar();
		btnBuscar.addActionListener(e -> atualizarLista());

		setBounds(0, 35, 470, 300);
		setVisible(true);
		setLayout(null);
		add(inputNome);
		add(btnBuscar);
	}

	public void atualizarLista() {

		Tela parent = (Tela) this.getParent().getParent().getParent().getParent();
		DefaultListModel<String> elementos = new DefaultListModel<>();

		for (Pessoa p : parent.pessoas)
			elementos.addElement(p.getNome());

		this.add(new Lista(elementos));
		this.repaint();
	}
}

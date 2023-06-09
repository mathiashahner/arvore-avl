package ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import arvore.ArvoreBinaria;
import arvore.No;

public class TelaNome extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final String PLACEHOLDER = "Buscar por nome...";

	private Tabela tabela;
	private InputTexto inputNome;
	private ArvoreBinaria<String> arvoreString;

	public TelaNome(ArvoreBinaria<String> arvoreString) {

		super();
		this.arvoreString = arvoreString;

		inputNome = new InputTexto(PLACEHOLDER);
		inputNome.setBounds(5, 0, 475, 25);

		BtnBuscar btnBuscar = new BtnBuscar();
		btnBuscar.addActionListener(e -> atualizarLista());

		setBounds(0, 35, 590, 300);
		setVisible(true);
		setLayout(null);
		add(inputNome);
		add(btnBuscar);
	}

	public void atualizarLista() {

		String textoInput = inputNome.getText();

		if (!textoInput.equals("") && !textoInput.equals(PLACEHOLDER)) {

			if (tabela != null)
				remove(tabela);

			No<String> no = arvoreString.buscarString(textoInput);
//			List<Integer> indicePessoas = arvoreString.percorrerEmOrdem(no, textoInput);
			List<Integer> indicePessoas = new ArrayList<>(no.getPosicao());

			if (no != null) {
				tabela = new Tabela(getDadosPessoas(indicePessoas));
				add(tabela);
			}

			repaint();
		}
	}

	private Object[][] getDadosPessoas(List<Integer> indicePessoas) {
		Tela parent = (Tela) getRootPane().getParent();
		return parent.getPessoas().stream().map(p -> p.getArrayDados()).toArray(Object[][]::new);
	}
}

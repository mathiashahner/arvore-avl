package ui;

import java.util.Arrays;

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

		String textoInput = inputNome.getText().equals(PLACEHOLDER) ? "" : inputNome.getText();

		if (tabela != null)
			remove(tabela);

		No<String> no = arvoreString.buscarString(textoInput.toUpperCase());

		if (no != null) {
			String indicePessoas = arvoreString.percorrerEmOrdem(no, textoInput.toUpperCase());

			tabela = new Tabela(getDadosPessoas(indicePessoas.split(";")));
			add(tabela);
		}

		repaint();
	}

	private Object[][] getDadosPessoas(String[] indicePessoas) {
		Tela parent = (Tela) getRootPane().getParent();
		return Arrays.stream(indicePessoas)
				.map(indice -> parent.getPessoas().get(Integer.parseInt(indice)).getArrayDados())
				.toArray(Object[][]::new);
	}
}

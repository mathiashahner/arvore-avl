package ui;

import javax.swing.JPanel;

import arvore.ArvoreBinaria;

public class TelaNome extends JPanel {

	private static final long serialVersionUID = 1L;

	private InputTexto inputNome;
	private ArvoreBinaria<?> arvoreString;

	public TelaNome(ArvoreBinaria<?> arvoreString) {

		super();
		this.arvoreString = arvoreString;

		inputNome = new InputTexto("Buscar por nome...");
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
		
//		arvoreString.buscar(inputNome.getText());
		Tabela tabela = new Tabela(getDadosPessoas());

		this.add(tabela);
		this.repaint();
	}

	private Object[][] getDadosPessoas() {
		Tela parent = (Tela) this.getRootPane().getParent();

		return parent.getPessoas().stream().map(p -> {
			String[] pessoaString = { p.getNome(), p.getCpf().toString(), p.getRg().toString(),
					p.getDataNascimento().toString(), p.getCidade() };
			return pessoaString;
		}).toArray(Object[][]::new);
	}
}

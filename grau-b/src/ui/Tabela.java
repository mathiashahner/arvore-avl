package ui;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Tabela extends JScrollPane {

	private static final long serialVersionUID = 1L;

	private static final String[] COLUNAS = { "Nome", "CPF", "RG", "Data Nascimento", "Cidade Natal" };

	public Tabela(Object[][] dados) {

		super(new JTable(dados, COLUNAS));
		setBounds(5, 30, 580, 265);
	}
}

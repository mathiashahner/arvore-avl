package ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;
import arvore.ArvoreBinaria;
import arvore.No;

public class TelaDataNascimento extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final String PLACEHOLDER = "__/__/____";

	private Tabela tabela;
	private InputTexto inputDataInicio;
	private InputTexto inputDataFim;
	private ArvoreBinaria<Date> arvoreDate;

	public TelaDataNascimento(ArvoreBinaria<Date> arvoreDate) {

		super();
		this.arvoreDate = arvoreDate;

		try {
			MaskFormatter mascaraData = new MaskFormatter("##/##/####");
			mascaraData.setPlaceholderCharacter('_');

			inputDataInicio = new InputTexto(mascaraData);
			inputDataInicio.setBounds(5, 0, 235, 25);

			inputDataFim = new InputTexto(mascaraData);
			inputDataFim.setBounds(245, 0, 235, 25);

			BtnBuscar btnBuscar = new BtnBuscar();
			btnBuscar.addActionListener(e -> atualizarLista());

			setBounds(0, 35, 590, 300);
			setVisible(false);
			setLayout(null);
			add(inputDataInicio);
			add(inputDataFim);
			add(btnBuscar);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void atualizarLista() {

		String textoInputInicio = inputDataInicio.getText();
		String textoInputFim = inputDataFim.getText();

		if (!textoInputInicio.equals(PLACEHOLDER) && !textoInputFim.equals(PLACEHOLDER)) {

			if (tabela != null)
				remove(tabela);

			No<Date> no = arvoreDate.buscarDate(converterParaDate(textoInputInicio), converterParaDate(textoInputFim));

			if (no != null) {
				String indicePessoas = arvoreDate.percorrerEmOrdemDate(no, converterParaDate(textoInputInicio),
						converterParaDate(textoInputFim));

				tabela = new Tabela(getDadosPessoas(indicePessoas.split(";")));
				add(tabela);
			}

			repaint();
		}
	}

	private Date converterParaDate(String input) {
		try {
			return new SimpleDateFormat("dd/MM/yyyy").parse(input);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	private Object[][] getDadosPessoas(String[] indicePessoas) {
		Tela parent = (Tela) getRootPane().getParent();
		return Arrays.stream(indicePessoas)
				.map(indice -> parent.getPessoas().get(Integer.parseInt(indice)).getArrayDados())
				.toArray(Object[][]::new);
	}
}

package ui;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;
import arvore.ArvoreBinaria;
import arvore.No;

public class TelaDataNascimento extends JPanel {

	private static final long serialVersionUID = 1L;

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

		String textoInputInicio = inputDataInicio.getText().replaceAll("\\D", "");
		String textoInputFim = inputDataFim.getText().replaceAll("\\D", "");
//
//		if (!textoInput.equals("") && !textoInput.equals("___.___.___-__")) {
//
//			if (tabela != null)
//				remove(tabela);
//
		No<Date> noInicio = arvoreDate.buscar(new GregorianCalendar(Integer.parseInt(textoInputInicio.substring(4)),
				Integer.parseInt(textoInputInicio.substring(2, 3)), Integer.parseInt(textoInputInicio.substring(0, 1)))
				.getTime());

		if (noInicio != null) {
			tabela = new Tabela(getDadosPessoas(noInicio.getPosicao()));
			add(tabela);
		}

		repaint();
//		}
	}

	private Object[][] getDadosPessoas(int posicao) {
		Tela parent = (Tela) getRootPane().getParent();
		Object[][] array = { parent.getPessoas().get(posicao).getArrayDados() };
		return array;
	}
}

package ui;

import java.text.ParseException;

import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;
import arvore.ArvoreBinaria;

public class TelaDataNascimento extends JPanel {

	private static final long serialVersionUID = 1L;

	private ArvoreBinaria<?> arvoreDate;

	public TelaDataNascimento(ArvoreBinaria<?> arvoreDate) {

		super();
		this.arvoreDate = arvoreDate;

		try {
			MaskFormatter mascaraData = new MaskFormatter("##/##/####");
			mascaraData.setPlaceholderCharacter('_');

			InputTexto inputDataInicio = new InputTexto(mascaraData);
			inputDataInicio.setBounds(5, 0, 235, 25);

			InputTexto inputDataFim = new InputTexto(mascaraData);
			inputDataFim.setBounds(245, 0, 235, 25);

			BtnBuscar btnBuscar = new BtnBuscar();

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
}

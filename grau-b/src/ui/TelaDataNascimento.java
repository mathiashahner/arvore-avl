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

			InputTexto inputCpfInicio = new InputTexto(mascaraData);
			inputCpfInicio.setBounds(5, 0, 180, 25);

			InputTexto inputCpfFim = new InputTexto(mascaraData);
			inputCpfFim.setBounds(190, 0, 180, 25);

			BtnBuscar btnBuscar = new BtnBuscar();
			Lista lista = new Lista();

			setBounds(0, 35, 470, 300);
			setVisible(false);
			setLayout(null);
			add(inputCpfInicio);
			add(inputCpfFim);
			add(btnBuscar);
			add(lista);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}

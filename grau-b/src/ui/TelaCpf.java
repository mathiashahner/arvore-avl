package ui;

import java.text.ParseException;

import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import arvore.ArvoreBinaria;

public class TelaCpf extends JPanel {

	private static final long serialVersionUID = 1L;

	private ArvoreBinaria<?> arvoreInteger;

	public TelaCpf(ArvoreBinaria<?> arvoreInteger) {

		super();
		this.arvoreInteger = arvoreInteger;

		try {
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setPlaceholderCharacter('_');

			InputTexto inputCpf = new InputTexto(mascaraCpf);
			inputCpf.setBounds(5, 0, 365, 25);

			BtnBuscar btnBuscar = new BtnBuscar();
			Lista lista = new Lista();

			setBounds(0, 35, 470, 300);
			setVisible(false);
			setLayout(null);
			add(inputCpf);
			add(btnBuscar);
			add(lista);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}

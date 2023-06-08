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
			inputCpf.setBounds(5, 0, 475, 25);

			BtnBuscar btnBuscar = new BtnBuscar();

			setBounds(0, 35, 590, 300);
			setVisible(false);
			setLayout(null);
			add(inputCpf);
			add(btnBuscar);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}

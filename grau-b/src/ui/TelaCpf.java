package ui;

import java.math.BigInteger;
import java.text.ParseException;

import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import arvore.ArvoreBinaria;
import arvore.No;

public class TelaCpf extends JPanel {

	private static final long serialVersionUID = 1L;

	private Tabela tabela;
	private InputTexto inputCpf;
	private ArvoreBinaria<BigInteger> arvoreInteger;

	public TelaCpf(ArvoreBinaria<BigInteger> arvoreInteger) {

		super();
		this.arvoreInteger = arvoreInteger;

		try {
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setPlaceholderCharacter('_');

			inputCpf = new InputTexto(mascaraCpf);
			inputCpf.setBounds(5, 0, 475, 25);

			BtnBuscar btnBuscar = new BtnBuscar();
			btnBuscar.addActionListener(e -> atualizarLista());

			setBounds(0, 35, 590, 300);
			setVisible(false);
			setLayout(null);
			add(inputCpf);
			add(btnBuscar);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void atualizarLista() {

		String textoInput = inputCpf.getText().replaceAll("\\D", "");

		if (!textoInput.equals("")) {

			if (tabela != null)
				remove(tabela);

			No<BigInteger> no = arvoreInteger.buscar(new BigInteger(textoInput));

			if (no != null) {
				tabela = new Tabela(getDadosPessoas(no.getPosicao()));
				add(tabela);
			}

			repaint();
		}
	}

	private Object[][] getDadosPessoas(int posicao) {
		Tela parent = (Tela) getRootPane().getParent();
		Object[][] array = { parent.getPessoas().get(posicao).getArrayDados() };
		return array;
	}
}

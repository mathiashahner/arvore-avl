package ui;

import java.awt.Color;
import java.awt.Insets;
import java.text.ParseException;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

public class TelaCpf extends JPanel {

	private static final long serialVersionUID = 1L;

	public TelaCpf() {

		super();

		try {
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setPlaceholderCharacter('_');

			InputTexto inputCpf = new InputTexto(mascaraCpf);
			inputCpf.setMargin(new Insets(2, 5, 2, 5));
			inputCpf.setBounds(5, 0, 460, 25);

			JList list = new JList();
			list.setBorder(new LineBorder(new Color(128, 128, 128)));
			list.setBounds(5, 30, 460, 265);

			setBounds(0, 35, 470, 300);
			setVisible(false);
			setLayout(null);
			add(inputCpf);
			add(list);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}

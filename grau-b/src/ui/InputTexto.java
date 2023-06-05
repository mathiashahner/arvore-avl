package ui;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class InputTexto extends JFormattedTextField {

	private static final long serialVersionUID = 1L;

	public InputTexto(MaskFormatter mascaraCpf) {
		super(mascaraCpf);
	}

	public InputTexto(String placeholder) {
		super(placeholder);

		setForeground(Color.GRAY);

		addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (getText().equals(placeholder)) {
					setText("");
					setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (getText().isEmpty()) {
					setForeground(Color.GRAY);
					setText(placeholder);
				}
			}
		});
	}
}

package My;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HintTextField extends JTextField {
	Font gainFont = new Font("맑은 고딕 Semilight", Font.BOLD, 11);
	Font lostFont = new Font("맑은 고딕 Semilight", Font.BOLD, 11);

	public HintTextField(final String hint) {

		setText(hint);
		setFont(lostFont);
		setForeground(Color.GRAY);

		this.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (getText().equals(hint)) {
					setText("");
					setFont(gainFont);
				} else {
					setText(getText());
					setFont(gainFont);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (getText().equals(hint) || getText().length() == 0) {
					setText(hint);
					setFont(lostFont);
					setForeground(Color.GRAY);
				} else {
					setText(getText());
					setFont(gainFont);
					setForeground(Color.BLACK);
				}
			}
		});
	}
}

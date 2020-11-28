package views.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import constants.MyConstants;

public class OwnJSpinner extends JSpinner {

	public OwnJSpinner(String text) {
		setBorder(BorderFactory.createTitledBorder(text));
		setBackground(Color.WHITE);
		setFont(new Font(MyConstants.FONT_ARIAL, 0, 14));
		setModel(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE - 10000, 1));
	}

	private static final long serialVersionUID = 1L;
}
package views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import constants.MyConstants;
import controller.ActionsE;
import views.components.OwnJButton;
import views.components.OwnJLabel;
import views.components.OwnJTable;

public class PanelMedias extends JPanel {

	public PanelMedias(ActionListener actionListener) {
		setBackground(Color.WHITE);
		setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		createGrid(c);

		JPanel pnlElements = new JPanel(new GridLayout(1, 4));

		pnlElements.add(new OwnJLabel("Hola"));
		pnlElements.add(new OwnJLabel("Mundo"));
		pnlElements.add(new OwnJButton("Prueba de medias", ActionsE.MEDIAS, actionListener));
		pnlElements.add(new OwnJButton("Abrir archivo", ActionsE.SELECT_FILE, actionListener));

		c.gridy = 0;
		c.weighty = 0.2;
		c.gridx = 0;
		c.gridwidth = 12;
		add(pnlElements, c);
		
		c.gridy = 1;
		c.weighty = 0.8;
		c.gridx = 5;
		c.gridwidth = 2;
		add(new JScrollPane(new OwnJTable(MyConstants.RI_NUMBERS)), c);
	}

	/**
	 * Creates the grid for the GridBagLayout
	 * 
	 * @param c the layout columns
	 */
	private void createGrid(GridBagConstraints c) {
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridheight = 1;
		c.weighty = 0.01;

		for (int i = 0; i < 12; i++) {
			c.gridx = i;
			add(new JLabel("" + i), c);
		}
	}

	private static final long serialVersionUID = 1L;
}
package views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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

		c.gridy = 0;
		c.weighty = 0.1;
		c.gridx = 0;
		c.gridwidth = 1;
		add(new OwnJLabel("Label ejemplo"), c);
		
		c.gridy = 0;
		c.weighty = 0.1;
		c.gridx = 1;
		c.gridwidth = 1;
		add(new OwnJLabel("Label2 ejemplo"), c);

		c.gridy = 0;
		c.weighty = 0.1;
		c.gridx = 2;
		c.gridwidth = 1;
		add(new OwnJButton("Prueba Medias", ActionsE.MEDIAS, actionListener), c);
		
		c.gridy = 1;
		c.weighty = 0.05;
		c.gridx = 0;
		c.gridwidth = 12;
		add(new OwnJLabel(" "), c);
		
		c.gridy = 2;
		c.weighty = 0.85;
		c.gridx = 0;
		c.gridwidth = 12;
		add(new JScrollPane(new OwnJTable()), c);
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
package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import constants.MyConstants;
import views.components.OwnJFileChooser;

public class PruebasMainWindow extends JFrame {

	private JTabbedPane panelesPruebas;
	private OwnJFileChooser fileChooser;

	private PanelMedias panelMedias;
	private PanelVarianza panelVarianza;
	private PanelKS panelKS;
	private PanelChi2 panelChi2;
	private PanelPoker panelPoker;

	public PruebasMainWindow(ActionListener actionListener) {
		getContentPane().setBackground(Color.WHITE);
		setTitle(MyConstants.APP_TITLE);
		setIconImage(createImageIcon(MyConstants.MAIN_ICON).getImage());
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setMinimumSize(new Dimension(950, 550));

		panelesPruebas = new JTabbedPane();
		panelesPruebas.setBackground(Color.WHITE);
		panelesPruebas.setForeground(Color.BLACK);

		panelMedias = new PanelMedias(actionListener);
		panelesPruebas.add("Medias", panelMedias);

		panelVarianza = new PanelVarianza();
		panelesPruebas.add("Varianza", panelVarianza);

		panelKS = new PanelKS();
		panelesPruebas.add("Prueba KS", panelKS);

		panelChi2 = new PanelChi2();
		panelesPruebas.add("Chi Cuadrado", panelChi2);

		panelPoker = new PanelPoker();
		panelesPruebas.add("Prueba Poker", panelPoker);

		add(panelesPruebas);

		fileChooser = new OwnJFileChooser();

		setVisible(true);
	}

	public File getFileFromFileChooser() {
		int option = fileChooser.showOpenDialog(this);
		return option != 1 ? fileChooser.getSelectedFile() : null;
	}
	
	public double getMediasAcceptanceMargin(ArrayList<Double> dataForTable) {
		return panelMedias.getAcceptanceMargin(dataForTable);
	}
	
	public void mediasApprovedProve(boolean isApproved, Object[] results) {
		panelMedias.approvedProve(isApproved, results);
	}
 
	/**
	 * Muestra el mensaje por parametro en un JOptionPane con icono de error
	 * 
	 * @param errorMessage to show to the user
	 */
	public void showErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage, "ERROR !", JOptionPane.ERROR_MESSAGE);
	}

	public ImageIcon createImageIcon(String path) {
		return new ImageIcon(getClass().getResource(path));
	}

	private static final long serialVersionUID = 1L;
}
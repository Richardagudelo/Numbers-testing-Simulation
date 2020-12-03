package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import constants.MyConstants;

public class PruebasMainWindow extends JFrame {

	private JTabbedPane panelesPruebas;

	private PanelMedias panelMedias;
	private PanelVarianza panelVarianza;
	private PanelKS panelKS;
	private PanelChi2 panelChi2;
	private PanelPoker panelPoker;

	public PruebasMainWindow(ActionListener actionListener,double[]datos,double[]datosks) {
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

		panelVarianza = new PanelVarianza(datos);
		panelesPruebas.add("Varianza", panelVarianza);

		panelKS = new PanelKS(datosks);
		panelesPruebas.add("Prueba KS", panelKS);

		panelChi2 = new PanelChi2();
		panelesPruebas.add("Chi Cuadrado", panelChi2);

		panelPoker = new PanelPoker();
		panelesPruebas.add("Prueba Poker", panelPoker);

		add(panelesPruebas);

		setVisible(true);
	}
	
	public void fillTable(ArrayList<Double> datos) {
		panelVarianza.fillTable(datos);
	}
	
	public void fillTable3(double[] inicial, double[] finalx,double[] frecObt,double[] fAcum,double[] pObt,double[] fEsperA,double[] pEsp,double[] dif) {
		panelKS.fillTable2(inicial, finalx,frecObt,fAcum,pObt,fEsperA,pEsp,dif);
	}
	
	public void fillTable2(ArrayList<Double>list) {
		panelKS.fillTable(list);
	}
	
	public void crearTabla2() {
		panelKS.crearTabla2();
	}

	/**
	 * Muestra el mensaje por parametro en un JOptionPane con icono de error
	 * 
	 * @param errorMessage to show to the user
	 */
	public void showErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage, "� ERROR !", JOptionPane.ERROR_MESSAGE);
	}

	public ImageIcon createImageIcon(String path) {
		return new ImageIcon(getClass().getResource(path));
	}

	private static final long serialVersionUID = 1L;
}
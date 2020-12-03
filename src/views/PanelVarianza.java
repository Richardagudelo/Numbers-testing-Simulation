package views;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import constants.MyConstants;


public class PanelVarianza extends JPanel {
	public PnlTable pnlTable;
	private static final long serialVersionUID = 1L;
	public JLabel jLmedia;
	public JLabel jLVarianza;
	public JLabel jLLS;
	public JLabel jLIS;
	public JLabel jLPaso;

	public PanelVarianza(double[]datos) {
		this.setLayout(null);
		this.setBackground(Color.decode("#FFB833"));
		
		crearTabla();
		initComponent(datos);
	}
	
	public void initComponent(double[]datos) {
		jLmedia = new JLabel();
		jLmedia.setBorder(new TitledBorder("Media"));
		jLmedia.setText(datos[0]+"");
		jLmedia.setForeground(Color.decode(MyConstants.CLR_WHITE));
		jLmedia.setBackground(Color.decode(MyConstants.CLR_BLUE_BTNS));
		jLmedia.setFont(new Font(MyConstants.FONT_ROBOTO, 1, 25));
		jLmedia.setHorizontalAlignment(JLabel.CENTER);
		jLmedia.setBounds(800, 50, 250, 100);
		
		jLVarianza = new JLabel();
		jLVarianza.setBorder(new TitledBorder("Varianza"));
		jLVarianza.setText(datos[1]+"");
		jLVarianza.setForeground(Color.decode(MyConstants.CLR_WHITE));
		jLVarianza.setBackground(Color.decode(MyConstants.CLR_BLUE_BTNS));
		jLVarianza.setFont(new Font(MyConstants.FONT_ROBOTO, 1, 25));
		jLVarianza.setHorizontalAlignment(JLabel.CENTER);
		jLVarianza.setBounds(800, 170, 250, 100);
		
		jLLS = new JLabel();
		jLLS.setBorder(new TitledBorder("Lado Superior"));
		jLLS.setText(datos[2]+"");
		jLLS.setForeground(Color.decode(MyConstants.CLR_WHITE));
		jLLS.setBackground(Color.decode(MyConstants.CLR_BLUE_BTNS));
		jLLS.setFont(new Font(MyConstants.FONT_ROBOTO, 1, 25));
		jLLS.setHorizontalAlignment(JLabel.CENTER);
		jLLS.setBounds(800, 300, 250, 100);
		
		jLIS = new JLabel();
		jLIS.setBorder(new TitledBorder("Lado Inferior"));
		jLIS.setText(datos[3]+"");
		jLIS.setForeground(Color.decode(MyConstants.CLR_WHITE));
		jLIS.setBackground(Color.decode(MyConstants.CLR_BLUE_BTNS));
		jLIS.setFont(new Font(MyConstants.FONT_ROBOTO, 1, 25));
		jLIS.setHorizontalAlignment(JLabel.CENTER);
		jLIS.setBounds(800, 420, 250, 100);
		
		jLPaso = new JLabel();
		jLPaso.setBorder(new TitledBorder("Cumple?"));
		if(datos[4]==1) {
			jLPaso.setText("Si pasa la prueba");
		}else {
			jLPaso.setText("No pasa la prueba");
		}
		jLPaso.setForeground(Color.decode(MyConstants.CLR_WHITE));
		jLPaso.setBackground(Color.decode(MyConstants.CLR_BLUE_BTNS));
		jLPaso.setFont(new Font(MyConstants.FONT_ROBOTO, 1, 25));
		jLPaso.setHorizontalAlignment(JLabel.CENTER);
		jLPaso.setBounds(800, 540, 250, 100);
		
		add(jLmedia);
		add(jLVarianza);
		add(jLIS);
		add(jLLS);
		add(jLPaso);
	}
	
	public void crearTabla() {
		pnlTable = new PnlTable();
		pnlTable.setBounds(0, 30, 700, 500);
		add(pnlTable);
	}

	public void fillTable(ArrayList<Double> list) {
		pnlTable.chargueProducts(list);
	}
}
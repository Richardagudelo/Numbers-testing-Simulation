package views;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import constants.MyConstants;

public class PanelKS extends JPanel {
	public PnlTable2 pnlTable;
	public PnlTable3 pnlTable3;
	public JLabel mayor, menor,rPromedio,dMax,dMaxp,jLPaso;
	
	public PanelKS(double[] datos) {
		this.setLayout(null);
		this.setBackground(Color.decode("#FFB833"));
		crearTabla();
		initComponent(datos);
	}
	
	public void crearTabla2() {
		pnlTable3 = new PnlTable3();
		pnlTable3.setBounds(500, 30, 950, 280);
		add(pnlTable3);
	}

	public void initComponent(double[]datos) {
		menor = new JLabel();
		menor.setBorder(new TitledBorder("Menor"));
		menor.setText(datos[1]+"");
		menor.setForeground(Color.decode(MyConstants.CLR_WHITE));
		menor.setBackground(Color.decode(MyConstants.CLR_BLUE_BTNS));
		menor.setFont(new Font(MyConstants.FONT_ROBOTO, 1, 25));
		menor.setHorizontalAlignment(JLabel.CENTER);
		menor.setBounds(20, 550, 150, 80);
		
		mayor = new JLabel();
		mayor.setBorder(new TitledBorder("Mayor"));
		mayor.setText(datos[0]+"");
		mayor.setForeground(Color.decode(MyConstants.CLR_WHITE));
		mayor.setBackground(Color.decode(MyConstants.CLR_BLUE_BTNS));
		mayor.setFont(new Font(MyConstants.FONT_ROBOTO, 1, 25));
		mayor.setHorizontalAlignment(JLabel.CENTER);
		mayor.setBounds(180, 550, 150, 80);

		
		rPromedio = new JLabel();
		rPromedio.setBorder(new TitledBorder("R Promedio"));
		rPromedio.setText(datos[2]+"");
		rPromedio.setForeground(Color.decode(MyConstants.CLR_WHITE));
		rPromedio.setBackground(Color.decode(MyConstants.CLR_BLUE_BTNS));
		rPromedio.setFont(new Font(MyConstants.FONT_ROBOTO, 1, 25));
		rPromedio.setHorizontalAlignment(JLabel.CENTER);
		rPromedio.setBounds(340, 550, 150, 80);
		
		dMax = new JLabel();
		dMax.setBorder(new TitledBorder("DMax"));
		dMax.setText(datos[3]+"");
		dMax.setForeground(Color.decode(MyConstants.CLR_WHITE));
		dMax.setBackground(Color.decode(MyConstants.CLR_BLUE_BTNS));
		dMax.setFont(new Font(MyConstants.FONT_ROBOTO, 1, 25));
		dMax.setHorizontalAlignment(JLabel.CENTER);
		dMax.setBounds(510, 550, 150, 80);
		
		dMaxp= new JLabel();
		dMaxp.setBorder(new TitledBorder("DMax Tabla"));
		dMaxp.setText(datos[4]+"");
		dMaxp.setForeground(Color.decode(MyConstants.CLR_WHITE));
		dMaxp.setBackground(Color.decode(MyConstants.CLR_BLUE_BTNS));
		dMaxp.setFont(new Font(MyConstants.FONT_ROBOTO, 1, 25));
		dMaxp.setHorizontalAlignment(JLabel.CENTER);
		dMaxp.setBounds(670, 550, 150, 80);
		
		jLPaso = new JLabel();
		jLPaso.setBorder(new TitledBorder("Cumple?"));
		if(datos[5]==1) {
			jLPaso.setText("Si pasa la prueba");
		}else {
			jLPaso.setText("No pasa la prueba");
		}
		jLPaso.setForeground(Color.decode(MyConstants.CLR_WHITE));
		jLPaso.setBackground(Color.decode(MyConstants.CLR_BLUE_BTNS));
		jLPaso.setFont(new Font(MyConstants.FONT_ROBOTO, 1, 25));
		jLPaso.setHorizontalAlignment(JLabel.CENTER);
		jLPaso.setBounds(840, 550, 250, 80);

		add(mayor);
		add(menor);
		add(rPromedio);
		add(dMax);
		add(dMaxp);
		add(jLPaso);
	}
	
	public void crearTabla() {
		pnlTable = new PnlTable2();
		pnlTable.setBounds(0, 30, 700, 500);
		add(pnlTable);
	}

	public void fillTable(ArrayList<Double>datos) {
		pnlTable.chargueProducts(datos);
	}
	
	public void fillTable2(double[]inicial, double[] finalx,double[] frecObt,double[] fAcum,double[] pObt,double[] fEsperA,double[] pEsp,double[] dif) {
		pnlTable3.chargueProducts(inicial, finalx,frecObt, fAcum, pObt, fEsperA, pEsp, dif);
	}
	
	private static final long serialVersionUID = 1L;
}
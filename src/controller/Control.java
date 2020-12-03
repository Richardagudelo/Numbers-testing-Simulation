package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;

import models.KS;
import models.Varianza;
import persistence.FileManager;
import views.PruebasMainWindow;;

public class Control implements ActionListener {

	private Medias medias;

	private FileManager fileManager;
	private PruebasMainWindow mainW;
	private Varianza varianza;
	private KS ks;

	private static File FILETOREAD;

	public Control() {
		medias = new Medias();

		fileManager = new FileManager();
		mainW = new PruebasMainWindow(this);
		double[] valores = new double[50];
		valores =infoProfe();
		varianza = new Varianza(valores,.95);
		ks = new KS(infoProfeKS(),95,5);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (ActionsE.valueOf(e.getActionCommand())) {
		case MEDIAS:
			if (FILETOREAD != null) {
				medias();
			} else {
				mainW.showErrorMessage(MyConstants.ERR_NO_FILE_SELECTED);
				break;
			}
		case VARIANZA:
			break;
		case KS:
			break;
		case CHI2:
			break;
		case POKER:
			break;
		case SELECT_FILE:
			FILETOREAD = mainW.getFileFromFileChooser();
			break;
		}
	}
	
	public double[] infoProfe() {
		double[] aux = new double[50];
		aux[0]=0.031440;	aux[1]=0.311271;	aux[2]=0.928426;	aux[3]=0.699545;	aux[4]=0.070885;	
		aux[5]=0.263751;	aux[6]=0.896510;	aux[7]=0.601238;	aux[8]=0.695186;	aux[9]=0.257217;	
		aux[10]=0.661090;	aux[11]=0.911817;	aux[12]=0.766321;	aux[13]=0.834743;	aux[14]=0.463014;	
		aux[15]=0.209180;	aux[16]=0.723503;	aux[17]=0.180494;	aux[18]=0.157221;	aux[19]=0.414227;	
		aux[20]=0.833130;	aux[21]=0.617190;	aux[22]=0.525914;	aux[23]=0.199922;	aux[24]=0.485106;	
		aux[25]=0.104745;	aux[26]=0.021767;	aux[27]=0.049527;	aux[28]=0.730993;	aux[29]=0.265738;
		aux[30]=0.444933;	aux[31]=0.916792;	aux[32]=0.688692;	aux[33]=0.783611;	aux[34]=0.297193;	
		aux[35]=0.702240;	aux[36]=0.459911;	aux[37]=0.228080;	aux[38]=0.191410;	aux[39]=0.161257;	
		aux[40]=0.712137;	aux[41]=0.596760;	aux[42]=0.116946;	aux[43]=0.833208;	aux[44]=0.008572;	
		aux[45]=0.057809;	aux[46]=0.861116;	aux[47]=0.915069;	aux[48]=0.078038;	aux[49]=0.002133;
		return aux;
	}
	
	public ArrayList<Double> infoProfeKS() {
		ArrayList<Double> aux = new ArrayList<>();
		aux.add(0.578683);	aux.add(0.710617);	aux.add(0.689988);	aux.add(0.538994);	aux.add(0.394848);	
		aux.add(0.296490);	aux.add(0.000000);	aux.add(0.816477);	aux.add(0.646391);	aux.add(0.627781);	
		aux.add(0.578075);	aux.add(0.509941);	aux.add(0.525652);	aux.add(0.670381);	aux.add(0.590813);	
		aux.add(0.479619);	aux.add(0.496725);	aux.add(0.328576);	aux.add(0.909237);	aux.add(0.549172);	
		aux.add(0.450164);	aux.add(0.564734);	aux.add(0.250452);	aux.add(0.137134);	aux.add(0.816437);	
		aux.add(0.641199);	aux.add(0.633333);	aux.add(0.386215);	aux.add(0.220694);	aux.add(0.593446);
		aux.add(0.821086);	aux.add(0.506602);	aux.add(0.290430);	aux.add(0.247806);	aux.add(0.574323);	
		aux.add(0.491296);	aux.add(1.000000);	aux.add(0.437993);	aux.add(0.620486);	aux.add(0.639490);	
		aux.add(0.700753);	aux.add(0.391825);	aux.add(0.346095);	aux.add(0.517212);	aux.add(0.824114);	
		aux.add(0.427438);	aux.add(0.443694);	aux.add(0.161216);	aux.add(0.376285);	aux.add(0.348020);
		return aux;

	private void medias() {
		ArrayList<Double> pseudoRandomNumbers = new ArrayList<Double>();
		try {
			pseudoRandomNumbers = fileManager.readFile(FILETOREAD);
		} catch (IOException e) {
			mainW.showErrorMessage(MyConstants.ERR_READ_FILE);
		}

		double acceptanceMargin = mainW.getMediasAcceptanceMargin(pseudoRandomNumbers);
		boolean paso = medias.mediasTesting(acceptanceMargin, pseudoRandomNumbers);
		mainW.mediasApprovedProve(paso, medias.getResults());
	}
}
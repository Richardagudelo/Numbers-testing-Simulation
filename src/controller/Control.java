package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import constants.MyConstants;
import models.*;
import persistence.FileManager;
import views.PruebasMainWindow;;

public class Control implements ActionListener {

	private FileManager fileManager;
	private PruebasMainWindow mainW;

	public Control() {
		fileManager = new FileManager();
		mainW = new PruebasMainWindow(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (ActionsE.valueOf(e.getActionCommand())) {
		case MEDIAS:
			break;
		case VARIANZA:
			break;
		case KS:
			break;
		case CHI2:
			break;
		case POKER:
			break;
		case SELECT_FILE:
			mainW.getFileFromFileChooser();
			break;
		}
	}
}
package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

	/**
	 * Lee un archivo tipo .txt especificado
	 * 
	 * @param pathname  la ruta donde esta el archivo, llegara en JFileChooser
	 * @param separator el separador del archivo, ej comas, se pedira por UI
	 * @return una lista de numeros pseudoaleatorios enteros leidos del archivo
	 * @throws IOException excepcion de lectura de archivos
	 */
	public ArrayList<Double> readFile(String pathname) throws IOException {
		File file = new File(pathname);

		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		ArrayList<Double> pseudoNumbers = new ArrayList<Double>();

		String data = "";
		while ((data = bufferedReader.readLine()) != null) {
			String[] lineData = data.split("#");
			for (String number : lineData) {
				pseudoNumbers.add(Double.parseDouble(number.replace(',', '.')));
			}
		}

		bufferedReader.close();
		fileReader.close();

		return pseudoNumbers;
	}
}
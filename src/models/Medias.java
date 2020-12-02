package models;

import java.util.ArrayList;

public class Medias {

	/** Cantidad de numeros pseudoaleatorios que llegan */
	private int n;

	/**
	 * 1 - el margen de aceptacion, los limites de aceptacion a partir de miu 0,5
	 */
	private double alpha;

	/**
	 * El valor x generado a buscar en la tabla Z de distribucion normal, esta dado
	 * por la formula x = 1 - (alpha / 2)
	 */
	private double x;

	/** Valor Z encontrado en la tabla de distro normal */
	private double z;

	/** Limite inferior de aceptación */
	private double lowerLimit;

	/** Limite superior de aceptación */
	private double upperLimit;

	/**
	 * Ejecuta la prueba de medias
	 * 
	 * @param acceptanceMargin margen de aceptacion para la prueba de medias,
	 *                         generalmente 95%
	 * @param pseudoNumbers    los numeros a testear para la prueba
	 * @return si el conjunto de números pseudoaleatorios pasa la prueba o no
	 */
	public boolean mediasTesting(double acceptanceMargin, ArrayList<Double> pseudoNumbers) {
//		n = pseudoNumbers.size();
		n = 0;

		alpha = 1 - acceptanceMargin;

		x = 1 - (alpha / 2);

		// Math.exp
		z = 0.975;
		// valor dentro de la tabla de distro normal
		// por ejemplo como x me da 0.9750
		// entonces z debe dar 1.9600
		System.out.println(Math.exp(-Math.pow(z, 2) / 2) / Math.sqrt(2 * Math.PI));

		lowerLimit = (0.5) - (z * (1 / Math.sqrt(12 * n)));

		upperLimit = (0.5) + (z * (1 / Math.sqrt(12 * n)));

		double average = this.findAverageOfPseudoNumbers(pseudoNumbers);
		if (average >= lowerLimit && average <= upperLimit) {
			return true;
		} else
			return false;
	}

	/**
	 * Calcula el promedio de los números pseudoaleatorios
	 * 
	 * @param pseudoNumbers los numeros pseudoaleatorios a testear, vienen del
	 *                      archivo txt
	 * @return el promedio calculado
	 */
	private double findAverageOfPseudoNumbers(ArrayList<Double> pseudoNumbers) {
		double accumulatedSum = 0;
		for (Double pseudoNum : pseudoNumbers) {
			accumulatedSum += pseudoNum;
		}
		return accumulatedSum / this.n;
	}

	public static double percentile_z(double p) {
		double a0 = 2.5066282, a1 = -18.6150006, a2 = 41.3911977, a3 = -25.4410605, b1 = -8.4735109, b2 = 23.0833674,
				b3 = -21.0622410, b4 = 3.1308291, c0 = -2.7871893, c1 = -2.2979648, c2 = 4.8501413, c3 = 2.3212128,
				d1 = 3.5438892, d2 = 1.6370678;

		double z = 0;
		double r = 0;
		
		if (p > 0.42) {
			r = Math.sqrt(-Math.log(0.5 - p));
			z = (((c3 * r + c2) * r + c1) * r + c0) / ((d2 * r + d1) * r + 1);
		} else {
			r = p * p;
			z = p * (((a3 * r + a2) * r + a1) * r + a0) / ((((b4 * r + b3) * r + b2) * r + b1) * r + 1);
		}
		return z;
	}

	public static void main(String[] args) {
		Medias medias = new Medias();

		System.out.println(percentile_z(0.6628));
	}
}
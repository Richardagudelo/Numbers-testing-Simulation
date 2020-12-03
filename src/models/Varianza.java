package models;
import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Varianza {

	int cant_datos;
	int grados_libertad;
	double confianza;
	double alfa;
	double[]datos;

	public Varianza(double[]datos,double confianza) {
		this.datos = datos;
		cant_datos=datos.length;
		grados_libertad=cant_datos-1;
		this.confianza = confianza;
		alfa=1-confianza;
		//Creamos objetos con las tablas de distribución normal y chi cuadrada, y un objeto que nos ayudará a obtener la media y la varianza.
		ChiSquaredDistribution chi = new ChiSquaredDistribution(grados_libertad);
		DescriptiveStatistics estadistica = new DescriptiveStatistics();

		//Metemos los datos del arreglo en el objeto estadistica.

		double media = estadistica.getMean();
		double varianza,li2, ls2;
		varianza = estadistica.getVariance();

		li2 = chi.inverseCumulativeProbability(alfa/2)/(12*grados_libertad);
		ls2 = chi.inverseCumulativeProbability(1-alfa/2)/(12*grados_libertad);

		System.out.println("---Prueba de varianza---");
		System.out.println("Media: " + media);
		System.out.println("Varianza: "+ varianza);
		System.out.println("Limite Superior: " + li2);
		System.out.println("Limite Inferios: " + ls2);
	}
}
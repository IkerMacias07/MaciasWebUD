package cdt.bean;

import java.io.Serializable;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named("cdt")
@ViewScoped
public class CDT implements Serializable {

	private static final long serialVersionUID = 1L;

	private double inversion;
	private double interes;
	private double plazo;
	private double ganancia;
	private double valorFuturo;
	private double impuesto;
	private static final double ANIO = 360;

	public CDT() {
		super();
	}

	public CDT(double inversion, double interes, double plazo) {
		super();
		this.inversion = inversion;
		this.interes = interes;
		this.plazo = plazo;
	}

	public double getInversion() {
		return inversion;
	}

	public void setInversion(double inversion) {
		this.inversion = inversion;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public double getPlazo() {
		return plazo;
	}

	public void setPlazo(double plazo) {
		this.plazo = plazo;
	}

	public double getGanancia() {
		return ganancia;
	}

	public void setGanancia(double ganancia) {
		this.ganancia = ganancia;
	}

	public double getValorFuturo() {
		return valorFuturo;
	}

	public void setValorFuturo(double valorFuturo) {
		this.valorFuturo = valorFuturo;
	}

	public void calcular() {
		// El interés se ingresa como porcentaje (ej: 10 para 10% E.A.), se divide entre 100
		ganancia = inversion * ((interes / 100.0) * (plazo / ANIO));
		System.out.println("ganancia: " + ganancia);
		valorFuturo = inversion + ganancia;
		System.out.println("valorFuturo:" + valorFuturo);
		impuesto = ganancia * 0.04;
	}

	public double getImpuesto() {
		return impuesto;
	}
}

package contribuintes;

import exceptions.StringInvalidaException;
import exceptions.ValorInvalidoException;

public class Professor extends Contribuinte {

	private double salario;
	private double despesas;

	public Professor(String nomeContribuinte, String cpfContribuinte,
			double salario, double despesas) throws StringInvalidaException,
			ValorInvalidoException {
		super(nomeContribuinte, cpfContribuinte, 0.0);

		if (salario < 0) {
			throw new ValorInvalidoException(
					"Salario nao pode ser menor que zero");
		}
		this.salario = salario;
		this.despesas = despesas;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getDespesas() {
		return despesas;
	}

	public void setDespesas(double despesas) {
		this.despesas = despesas;
	}

	public double getDescontos(double despesas) {
		return (despesas * 0.5);
	}

	@Override
	public double calculoTributacao() {
		if (this.getSalario() <= 880.0) {
			return this.getSalario() - (0.05 * this.getSalario());
		} else if (this.getSalario() > 880.0
				&& this.getSalario() <= (5 * 880.0)) {
			return this.getSalario() - (0.10 * this.getSalario());
		} else {
			return this.getSalario() - (0.20 * this.getSalario());
		}
	}

	public double impostoPago() {
		//Chamada Polimorfica
		double imposto = this.calculoTributacao()
				- this.getDescontos(this.getDespesas());
		if (this.getDescontos(this.getDespesas()) > this.calculoTributacao()) {
			return 0.0;
		} else {
			return imposto;
		}
	}

	public String toString() {
		return "[PROFESSOR] " + super.toString();
	}
	
	public String toStringAcimaLimiar() {
		if (this.getValorBens() > 300000.0) {
			return "[PROFESSOR] Acima Limiar " + super.toString();
		} else {
			return null;
		}
	}

}

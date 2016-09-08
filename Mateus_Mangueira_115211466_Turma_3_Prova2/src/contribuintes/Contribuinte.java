package contribuintes;

import exceptions.StringInvalidaException;

public abstract class Contribuinte {

	private String nome;
	private String cpf;
	private double valorBens;

	public Contribuinte(String nomeContribuinte, String cpfContribuinte,
			double valorBens) throws StringInvalidaException {
		if (nomeContribuinte.equals(null) || nomeContribuinte.trim().isEmpty()) {
			throw new StringInvalidaException(
					"Nome do contribuinte nao pode ser vazio ou nulo.");
		}
		if (cpfContribuinte.equals(null) || cpfContribuinte.trim().isEmpty()) {
			throw new StringInvalidaException(
					"Cpf do contribuinte nao pode ser vazio ou nulo.");
		}
		this.nome = nomeContribuinte;
		this.cpf = cpfContribuinte;
		this.valorBens = 0.0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getValorBens() {
		return valorBens;
	}

	public void setValorBens(double valorBens) {
		this.valorBens = valorBens;
	}

	public abstract double calculoTributacao();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorBens);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object outroObjeto) {
		if (outroObjeto instanceof Contribuinte) {
			Contribuinte outroContribuinte = (Contribuinte) outroObjeto;
			if (this.getCpf().equalsIgnoreCase(outroContribuinte.getCpf())) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		return this.getNome() + ", " + this.getCpf();
	}

}

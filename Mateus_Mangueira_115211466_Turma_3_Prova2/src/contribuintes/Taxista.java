package contribuintes;

import exceptions.StringInvalidaException;

public class Taxista extends Contribuinte {

	private int passageirosTransportados;
	private int quilometragem;

	public Taxista(String nomeContribuinte, String cpfContribuinte,
			int quilometragem, int passageiros) throws StringInvalidaException {
		super(nomeContribuinte, cpfContribuinte, 0.0);

		this.passageirosTransportados = quilometragem;
		this.quilometragem = passageiros;
	}

	public int getPassageirosTransportados() {
		return passageirosTransportados;
	}

	public int getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(int quilometragem) {
		this.quilometragem = quilometragem;
	}

	public void setPassageirosTransportados(int passageirosTransportados) {
		this.passageirosTransportados = passageirosTransportados;
	}

	public double getDescontos() {
		return this.getQuilometragem() * 0.01;
	}

	public double impostoPago() {
		//Chamada Polimorfica
		double imposto = this.calculoTributacao() - this.getDescontos();
		if (this.getDescontos() > this.calculoTributacao()) {
			return 0.0;
		} else {
			return imposto;
		}
	}

	@Override
	public double calculoTributacao() {
		return this.getPassageirosTransportados() * 0.5;
	}

	public String toString() {
		return "[TAXISTA] " + super.toString();
	}

	public String toStringAcimaLimiar() {
		if (this.getValorBens() > 150000.0) {
			return "[TAXISTA] Acima Limiar " + super.toString();
		} else {
			return null;
		}
	}
}

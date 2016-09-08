package contribuintes;

import exceptions.StringInvalidaException;

public class Caminhoneiro extends Contribuinte {

	private int toneladasTransportadas;
	private int quilometragem;

	public Caminhoneiro(String nomeContribuinte, String cpfContribuinte,
			int toneladasTransportadas, int quilometragem)
			throws StringInvalidaException {
		super(nomeContribuinte, cpfContribuinte, 0.0);

		this.toneladasTransportadas = toneladasTransportadas;
		this.quilometragem = quilometragem;
	}

	public int getToneladasTransportadas() {
		return toneladasTransportadas;
	}

	public void setToneladasTransportadas(int toneladasTransportadas) {
		this.toneladasTransportadas = toneladasTransportadas;
	}

	public int getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(int quilometragem) {
		this.quilometragem = quilometragem;
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
		if (this.getToneladasTransportadas() <= 10.0) {
			return 500.0;
		} else {
			return 500.0 + (100.0 * (this.getToneladasTransportadas() - 10.0));
		}
	}

	public String toString() {
		return "[CAMINHONEIRO] " + super.toString();
	}

	public String toStringAcimaLimiar() {
		if (this.getValorBens() > 100000.0) {
			return "[CAMINHONEIRO] Acima do Limiar " + super.toString();
		}
		return null;
	}
}

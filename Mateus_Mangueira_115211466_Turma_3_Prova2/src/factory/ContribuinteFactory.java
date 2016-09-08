package factory;

import contribuintes.Caminhoneiro;
import contribuintes.Contribuinte;
import contribuintes.Professor;
import contribuintes.Taxista;
import exceptions.StringInvalidaException;
import exceptions.ValorInvalidoException;

public class ContribuinteFactory {
	
	public ContribuinteFactory() {
	}
	
	public Contribuinte criaTaxista(String nome, String cpf, int quilometros, int passageiros) {
		try {
			//Polimorfismo
			Contribuinte taxista = new Taxista(nome, cpf, quilometros, passageiros);
			return taxista;
		} catch (StringInvalidaException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public Contribuinte criaCaminhoneiro(String nome, String cpf, int quilometros, int passageiros) {
		try {
			//Polimorfismo
			Contribuinte caminhoneiro = new Caminhoneiro(nome, cpf, quilometros, passageiros);
			return caminhoneiro;
		} catch (StringInvalidaException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public Contribuinte criaProfessor(String nome, String cpf, double salario, double despesas) {
		try {
			//Polimorfismo
			Contribuinte professor = new Professor(nome, cpf, salario, despesas);
			return professor;
		} catch (StringInvalidaException e) {
			System.out.println(e.getMessage());
		} catch (ValorInvalidoException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}

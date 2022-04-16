package br.edu.insper.desagil.aps4.catz;

import java.util.HashMap;
import java.util.Map;

public class FichaSimples extends Ficha {
	
	private Gato gato;

	public FichaSimples(Gato gato) {
		super();
		this.gato = gato;
	}

	public Gato getGato() {
		return gato;
	}

	@Override
	public Map<String, String> descricao() {
		Map<String, String> catDescription = new HashMap<String, String>();

		// Nome do gatinho
		catDescription.put("Nome", gato.getNome());

		// História do gatinho
		catDescription.put("História", gato.getHistoria());

		return catDescription;
	}

	@Override
	public boolean especial() {
		if (gato.isTemFeLV() == true || gato.isTemFIV() == true) {
			return true;
		}

		return false;
	}

}

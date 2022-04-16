package br.edu.insper.desagil.aps4.catz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class FichaComposta extends Ficha {
	
	private List<FichaSimples> fichas;
	private String historia;
	
	public FichaComposta(List<FichaSimples> fichas, String historia) {
		super();
		this.fichas = fichas;
		this.historia = historia;
	}

	@Override
	public Map<String, String> descricao() {
		List<String> namesList = new ArrayList<>();
		for (FichaSimples ficha : fichas) {
			Gato gato = ficha.getGato();
			namesList.add(gato.getNome());
		}

		String names = "";
		int lastItemIndex = namesList.size() - 1;
		for (String name : namesList) {
			if (namesList.indexOf(name) == lastItemIndex) {
				names += "e " + name;
			} else {
				if (namesList.indexOf(name) == lastItemIndex - 1) {
					names += name + " ";
				} else {
					names += name + ", ";
				}

			}
		}

		Map<String, String> mapa = new HashMap<>();
		mapa.put("Nomes", names);

		mapa.put("História", historia);
		return mapa;
	}

	@Override
	public boolean especial() {
		boolean isSpecial = false;
		for (FichaSimples ficha : fichas) {
			Gato gato = ficha.getGato();
			if (ficha.especial()) {
				isSpecial = true;
			}

		}
		return isSpecial;
	}

}

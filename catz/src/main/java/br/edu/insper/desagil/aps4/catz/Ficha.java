package br.edu.insper.desagil.aps4.catz;

import java.util.Map;

public abstract class Ficha {
	
	private boolean adotado;
	
	public Ficha() {
		this.adotado = false;
	}

	public boolean isAdotado() {
		return adotado;
	}

	public void setAdotado(boolean adotado) {
		this.adotado = adotado;
	}
	
	public abstract Map<String, String> descricao();
	
	public abstract boolean especial();
	
}

package br.edu.insper.desagil.aps4.catz;

import java.util.*;
import java.time.LocalDate;

public class Gato {
	
	private String nome;
	private LocalDate nascimento;
	private boolean temFIV;
	private boolean temFeLV;
	private String historia;
	private Map<String, Integer> apadrinhamentos;
	
	public Gato(String nome, LocalDate nascimento, boolean temFIV, boolean temFeLV, String historia) {
		this.nome = nome;
		this.nascimento = nascimento;
		this.temFIV = temFIV;
		this.temFeLV = temFeLV;
		this.historia = historia;
		this.apadrinhamentos = new HashMap<>();
	}

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public boolean isTemFIV() {
		return temFIV;
	}

	public boolean isTemFeLV() {
		return temFeLV;
	}
	
	public List<String> padrinhos() {
		List<String> names = new ArrayList<>();
		apadrinhamentos.forEach((nome, valor) -> {
			names.add(nome);
		});

		return names;
	}
	public void atualizaApadrinhamento(String nome, Integer valor) {
		if (valor > 0) {
			apadrinhamentos.put(nome, valor);
		} else {
			if (apadrinhamentos.containsKey(nome)) {
				apadrinhamentos.remove(nome);
			}
		}


	}
	
	public Integer totalApadrinhamentos() {
		int soma = 0;
		for (Integer valor: apadrinhamentos.values()) {
			soma += valor;
		}

		return soma;
	}
	
}

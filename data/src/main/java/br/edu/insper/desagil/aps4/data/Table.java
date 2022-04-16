package br.edu.insper.desagil.aps4.data;

import java.util.HashMap;
import java.util.Map;

public class Table extends Set {
	private Map<Integer, Node> table;

	public Table() {
		this.table = new HashMap<>();
	}

	private int hash(int value) {
		return value % 7;
	}

	@Override
	public boolean has() {
		return false;
	}

	@Override
	public void add(int value) {
		table.put(hash(value), new Node(value));
	}

	@Override
	public void remove(int value) {
	}
}

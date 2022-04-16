package br.edu.insper.desagil.aps4.data;

public class Tree extends Set {
	private Node root;

	public Tree() {
		this.root = null;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public Node predecessor() {
		return null;
	}

	public Node sucessor() {
		return null;
	}

	@Override
	public boolean has() {
		return false;
	}

	@Override
	public void add(int value) {
	}

	@Override
	public void remove(int value) {
	}
}

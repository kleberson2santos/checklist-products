package com.bokine.conferencia.java8;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Produto {
	
	private Long romaneio;
	private int quantidade;
	private String nome;
	private boolean conferido;
	
	public Produto(String nome) {
		this.nome = nome;
	}

	public Produto(String nome, int quantidade) {
		this.quantidade = quantidade;
		this.nome = nome;
		this.conferido = false;
	}

	public Produto(String nome, int quantidade, boolean conferido) {
		this.quantidade = quantidade;
		this.nome = nome;
		this.conferido = conferido;
	}
	
	public Produto(Long romaneio, String nome, int quantidade, boolean conferido) {
		this.romaneio = romaneio;
		this.quantidade = quantidade;
		this.nome = nome;
		this.conferido = conferido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public String getNome() {
		return nome;
	}
	
	public Long getRomaneio() {
		return romaneio;
	}
	

	public void tornaModerador() {
		this.conferido = true;
	}
	
	public String toString() {
		return "Produto " + nome;
	}

	public boolean isConferido() {
		return conferido;
	}
}

class Pedido {
	private Set<Produto> produtos = new HashSet<>();

	public void add(Produto p) {
		produtos.add(p);
	}

	public Set<Produto> getProdutos() {
		return Collections.unmodifiableSet(this.produtos);
	}


}

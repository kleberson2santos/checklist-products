package com.bokine.conferencia.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import com.bokine.conferencia.model.Produto;

import org.springframework.stereotype.Repository;

@Repository
public class Conferencia {

	private List<Produto> produtos = new ArrayList<>();
	private List<Produto> conferidos = new ArrayList<>();

	public Conferencia() {
		Produto p1 = new Produto("0031996000U", 1, true);
		Produto p2 = new Produto("0031972000U", 1, true);
		Produto p3 = new Produto("0032006000U", 2);
		Produto p4 = new Produto("0031977000U", 3);
		Produto p5 = new Produto("0032166000U", 3);
		Produto p6 = new Produto("0030572000U", 3);
		Produto p7 = new Produto("0031999000U", 3);
		Produto p8 = new Produto("0031981000U", 3);
		Produto p9 = new Produto("0031993000U", 3);
		Produto p10 = new Produto("0031968000U", 3);
		Produto p11 = new Produto("0031980000U", 3);
		this.produtos.add(p1);
		this.produtos.add(p2);
		this.produtos.add(p3);
		this.produtos.add(p4);
		this.produtos.add(p5);
		this.produtos.add(p6);
		this.produtos.add(p7);
		this.produtos.add(p8);
		this.produtos.add(p9);
		this.produtos.add(p10);
		this.produtos.add(p11);
	};

	public List<Produto> getProdutos() {
		return produtos;
	}

	public List<Produto> getConferidos() {
		return conferidos;
	}

	public void remove(List<Produto> produtos, String sf) {
		produtos.removeIf(p -> p.getNome().equals(sf));
	}

	public void confere(List<Produto> produtos, List<Produto> conferidos, final Produto produto) {
		Consumer<Produto> adicionaChecado = u -> conferidos.add(u);
		produtos.stream().filter(p -> p.getNome().equals(produto.getNome())).findFirst().ifPresent(adicionaChecado);
	}
}

package com.bokine.conferencia.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bokine.conferencia.model.Produto;
import com.bokine.conferencia.service.ConferenciaService;

@Repository
public class Conferencia {
	
	@Autowired
	ConferenciaService conferenciaService ;

	private List<Produto> produtos = new ArrayList<>();
	private List<Produto> conferidos = new ArrayList<>();

	public Conferencia() {
	}

	public List<Produto> getProdutos() {
		
		return conferenciaService.listar();
	}

	public List<Produto> getConferidos() {
		return conferidos;
	}

	public void load() {
		this.produtos = conferenciaService.listar();
	}
	
	public void remove(List<Produto> produtos, String sf) {
		produtos.removeIf(p -> p.getNome().equals(sf));
	}

	public void confere(List<Produto> produtos, List<Produto> conferidos, final Produto produto) {
		Consumer<Produto> adicionaChecado = u -> conferidos.add(u);
		produtos.stream().filter(p -> p.getNome().equals(produto.getNome())).findFirst().ifPresent(adicionaChecado);
	}
}

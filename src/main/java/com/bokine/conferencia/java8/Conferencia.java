package com.bokine.conferencia.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Conferencia{
	
	public static void main (String... args) throws Exception 	{
		
		Produto p1 = new Produto("0025", 1, true);
		Produto p2 = new Produto("0029", 1, true);
		Produto p3 = new Produto("0030", 2);
		Produto p4 = new Produto("0031", 3);
		Produto p5 = new Produto("0035", 3);
		Produto p6 = new Produto("0035", 3);
		
		List<Produto> produtos = new ArrayList<>();
		produtos.add(p1);
		produtos.add(p2);
		produtos.add(p3);
		produtos.add(p4);
		produtos.add(p5);
		produtos.add(p6);
		
		List<Produto> conferidos = new ArrayList<>();
		
		Scanner ler = new Scanner(System.in);
		String s = null;
		
		System.out.println(conferidos);
		System.out.println(produtos);
		
		do {
			System.out.printf("Informe o codigo do produto:\n");
			s = ler.nextLine();
			String sf = s;
			String p = s;
			confere(produtos,conferidos, new Produto(sf));
			remove(produtos,sf);
			System.out.println(conferidos);
			System.out.println(produtos);
			
		}while(produtos.size()>0);
		
		System.out.println("Produtos Conferidos:");
		System.out.println(conferidos);
	}

	private static void remove(List<Produto> produtos, String sf) {
		produtos.removeIf(p->p.getNome().equals(sf));
		
	}

	private static void confere(List<Produto> produtos, List<Produto> conferidos, final Produto produto) {
		Consumer<Produto> adicionaChecado = u -> conferidos.add(u);
		produtos.stream().filter(p->p.getNome().equals(produto.getNome()))
			.findFirst().ifPresent(adicionaChecado);
	}
}

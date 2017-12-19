package com.bokine.conferencia.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@Transient
	@Enumerated(EnumType.STRING)
	private TipoVinho tipo;	
	@Transient
	private int quantidade;
	@Transient
	private boolean conferido;
	
	public Produto() {
	}
	
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
	
	public Produto(Long id, String nome, int quantidade, boolean conferido) {
		this.id = id;
		this.quantidade = quantidade;
		this.nome = nome;
		this.conferido = conferido;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public TipoVinho getTipo() {
		return tipo;
	}

	public void setTipo(TipoVinho tipo) {
		this.tipo = tipo;
	}
	
	public void tornaConferido() {
		this.conferido = true;
	}
	
	public String toString() {
		return "Produto " + nome;
	}

	public boolean isConferido() {
		return conferido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}


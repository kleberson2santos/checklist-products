package com.bokine.conferencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bokine.conferencia.model.Produto;

public interface Conferencias extends JpaRepository<Produto, Long> {

}

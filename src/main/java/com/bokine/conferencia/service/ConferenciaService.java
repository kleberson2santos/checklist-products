package com.bokine.conferencia.service;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bokine.conferencia.model.Produto;

@Service
public class ConferenciaService {

	public List<Produto> listar() {
		RestTemplate restTemplate = new RestTemplate();

		RequestEntity<Void> request = RequestEntity.get(URI.create("http://192.168.1.200:8080/conferencias")).build();

		ResponseEntity<Produto[]> response = restTemplate.exchange(request, Produto[].class);

		return Arrays.asList(response.getBody());
	}

}

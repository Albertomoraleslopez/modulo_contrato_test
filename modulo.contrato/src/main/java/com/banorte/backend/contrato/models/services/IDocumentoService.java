package com.banorte.backend.contrato.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.banorte.backend.contrato.models.entity.Documento;



public interface IDocumentoService {

	public List<Documento> findAll();
	
	public Documento findById(Long id);
	
	public Page<Documento> findAll(Pageable pageable);
	
	public Documento save(Documento documento);
	
	public void Delete(Long id);
	
	
	
}

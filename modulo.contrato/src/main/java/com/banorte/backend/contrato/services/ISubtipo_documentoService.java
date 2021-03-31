package com.banorte.backend.contrato.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.banorte.backend.contrato.models.entity.Subtipo_documento;


public interface ISubtipo_documentoService {
	
	public List<Subtipo_documento> findAll();
	
	public Subtipo_documento findById(Long id);
	
	public Page<Subtipo_documento> findAll(Pageable pageable);
	
	public Subtipo_documento save(Subtipo_documento subtipo_documento);
	
	public void Delete(Long id);

}

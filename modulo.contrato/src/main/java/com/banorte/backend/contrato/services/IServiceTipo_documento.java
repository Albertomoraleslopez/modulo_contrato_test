package com.banorte.backend.contrato.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.banorte.backend.contrato.models.entity.Tipo_documento;


public interface IServiceTipo_documento {

	
	public List<Tipo_documento> findAll();
	
	public Tipo_documento findById(Long id);
	
	public Page<Tipo_documento> findAll(Pageable pageable);
	
	public Tipo_documento save(Tipo_documento Tipo_documento);
	
	public void Delete(Long id);
}

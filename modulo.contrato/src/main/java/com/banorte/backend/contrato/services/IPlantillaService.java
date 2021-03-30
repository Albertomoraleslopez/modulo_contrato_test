package com.banorte.backend.contrato.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.banorte.backend.contrato.models.entity.Plantilla;

public interface IPlantillaService {

	public List<Plantilla> findAll();
	
	public Plantilla findById(Long id);
	
	public Page<Plantilla> findAll(Pageable pageable);
	
	public Plantilla save(Plantilla cliente);
	
	public void Delete(Long id);
	
	
	
}

package com.banorte.backend.contrato.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.banorte.backend.contrato.models.entity.Variables;

public interface IVariablesService {
	


	
	public List<Variables> findAll();
	
	public Variables findById(Long id);
	
	public Page<Variables> findAll(Pageable pageable);
	
	public Variables save(Variables variables);
	
	public void Delete(Long id);


}

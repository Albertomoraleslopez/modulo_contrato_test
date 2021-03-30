package com.banorte.backend.contrato.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.banorte.backend.contrato.models.entity.Agrupacion;


public interface IAgrupacionService {


		public List<Agrupacion> findAll();
		
		public Agrupacion findById(Long id);
		
		public Page<Agrupacion> findAll(Pageable pageable);
		
		public Agrupacion save(Agrupacion agrupacion);
		
		public void Delete(Long id);
		
		
}

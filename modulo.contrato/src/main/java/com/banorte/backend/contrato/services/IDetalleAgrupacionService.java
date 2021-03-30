package com.banorte.backend.contrato.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.banorte.backend.contrato.models.entity.Detalle_agrupacion;

public interface IDetalleAgrupacionService {

	
	
	public List<Detalle_agrupacion> findAll();
	
	public Detalle_agrupacion findById(Long id);
	
	public Page<Detalle_agrupacion> findAll(Pageable pageable);
	
	public Detalle_agrupacion save(Detalle_agrupacion detalle_agrupacion);
	
	public void Delete(Long id);
}

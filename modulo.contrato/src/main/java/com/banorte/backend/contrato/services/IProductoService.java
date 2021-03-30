package com.banorte.backend.contrato.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.banorte.backend.contrato.models.entity.Producto;

public interface IProductoService {


	public List<Producto> findAll();
	
	public Producto findById(Long id);
	
	public Page<Producto> findAll(Pageable pageable);
	
	public Producto save(Producto producto);
	
	public void Delete(Long id);
	
}

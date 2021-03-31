package com.banorte.backend.contrato.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.banorte.backend.contrato.dao.IProductosDao;
import com.banorte.backend.contrato.models.entity.Producto;
import com.banorte.backend.contrato.services.IProductoService;

public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductosDao productosDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productosDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Producto>findAll(Pageable pageable) {
		return productosDao.findAll(pageable);
	
	}
	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		// TODO Auto-generated method stub
		return productosDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		return productosDao.save(producto);
	}

	@Override
	@Transactional
	public void Delete(Long id) {
		productosDao.deleteById(id);
		// TODO Auto-generated method stub
	}
	

	
}

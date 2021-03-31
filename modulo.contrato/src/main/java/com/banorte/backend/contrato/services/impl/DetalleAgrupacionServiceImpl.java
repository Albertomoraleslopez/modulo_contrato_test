package com.banorte.backend.contrato.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.banorte.backend.contrato.dao.IDetalleAgrupacionDao;
import com.banorte.backend.contrato.models.entity.Detalle_agrupacion;
import com.banorte.backend.contrato.services.IDetalleAgrupacionService;

public class DetalleAgrupacionServiceImpl implements IDetalleAgrupacionService{

	@Autowired
	private IDetalleAgrupacionDao detalleAgrupacionDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Detalle_agrupacion> findAll() {
		return (List<Detalle_agrupacion>) detalleAgrupacionDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Detalle_agrupacion>findAll(Pageable pageable) {
		return detalleAgrupacionDao.findAll(pageable);
	
	}
	@Override
	@Transactional(readOnly = true)
	public Detalle_agrupacion findById(Long id) {
		return detalleAgrupacionDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Detalle_agrupacion save(Detalle_agrupacion detalle_agrupacion) {
		return detalleAgrupacionDao.save(detalle_agrupacion);
	}

	@Override
	@Transactional
	public void Delete(Long id) {
		detalleAgrupacionDao.deleteById(id);
	}
}

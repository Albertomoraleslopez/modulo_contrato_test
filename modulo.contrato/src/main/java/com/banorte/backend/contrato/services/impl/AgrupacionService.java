package com.banorte.backend.contrato.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.banorte.backend.contrato.dao.IAgrupacionDao;
import com.banorte.backend.contrato.models.entity.Agrupacion;
import com.banorte.backend.contrato.services.IAgrupacionService;


public class AgrupacionService implements IAgrupacionService {
	@Autowired
	private IAgrupacionDao agrupacionDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Agrupacion> findAll() {
		return (List<Agrupacion>) agrupacionDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Agrupacion>findAll(Pageable pageable) {
		return agrupacionDao.findAll(pageable);
	
	}
	@Override
	@Transactional(readOnly = true)
	public Agrupacion findById(Long id) {
		return agrupacionDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Agrupacion save(Agrupacion agrupacion) {
		return agrupacionDao.save(agrupacion);
	}

	@Override
	@Transactional
	public void Delete(Long id) {
		agrupacionDao.deleteById(id);
	}
}

package com.banorte.backend.contrato.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.banorte.backend.contrato.dao.ISubTipo_documentoDao;
import com.banorte.backend.contrato.models.entity.Subtipo_documento;
import com.banorte.backend.contrato.services.ISubtipo_documentoService;

public class Subtipo_documentoServiceImp implements ISubtipo_documentoService{
	
	
	@Autowired
	private ISubTipo_documentoDao subTipo_documentoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Subtipo_documento> findAll() {
		return (List<Subtipo_documento>) subTipo_documentoDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Subtipo_documento>findAll(Pageable pageable) {
		return subTipo_documentoDao.findAll(pageable);
	
	}
	@Override
	@Transactional(readOnly = true)
	public Subtipo_documento findById(Long id) {
		// TODO Auto-generated method stub
		return subTipo_documentoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Subtipo_documento save(Subtipo_documento subtipo_documento) {
		// TODO Auto-generated method stub
		return subTipo_documentoDao.save(subtipo_documento);
	}

	@Override
	@Transactional
	public void Delete(Long id) {
		subTipo_documentoDao.deleteById(id);
		// TODO Auto-generated method stub
	}
	


}

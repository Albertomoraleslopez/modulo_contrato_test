package com.banorte.backend.contrato.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.banorte.backend.contrato.dao.ITipoDocumentoDao;
import com.banorte.backend.contrato.models.entity.Tipo_documento;
import com.banorte.backend.contrato.services.ITipo_documentoService;

public class Tipo_documentoServiceImp implements ITipo_documentoService {

	@Autowired
	private ITipoDocumentoDao tipo_documentoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Tipo_documento> findAll() {
		return (List<Tipo_documento>) tipo_documentoDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Tipo_documento>findAll(Pageable pageable) {
		return tipo_documentoDao.findAll(pageable);
	
	}
	@Override
	@Transactional(readOnly = true)
	public Tipo_documento findById(Long id) {
		// TODO Auto-generated method stub
		return tipo_documentoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Tipo_documento save(Tipo_documento tipo_documento) {
		// TODO Auto-generated method stub
		return tipo_documentoDao.save(tipo_documento);
	}

	@Override
	@Transactional
	public void Delete(Long id) {
		tipo_documentoDao.deleteById(id);
		// TODO Auto-generated method stub
	}
	

}

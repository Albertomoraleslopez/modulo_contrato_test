package com.banorte.backend.contrato.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banorte.backend.contrato.models.dao.IDocumentoDao;
import com.banorte.backend.contrato.models.entity.Documento;


@Service
public class DocumentoServiceImp implements IDocumentoService{

	@Autowired
	private IDocumentoDao documentoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Documento> findAll() {
		return (List<Documento>) documentoDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Documento>findAll(Pageable pageable) {
		return documentoDao.findAll(pageable);
	
	}
	@Override
	@Transactional(readOnly = true)
	public Documento findById(Long id) {
		return documentoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Documento save(Documento documento) {
		return documentoDao.save(documento);
	}

	@Override
	@Transactional
	public void Delete(Long id) {
		documentoDao.deleteById(id);
	}
	
}

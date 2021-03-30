package com.banorte.backend.contrato.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banorte.backend.contrato.dao.IPlantillaDao;
import com.banorte.backend.contrato.models.entity.Plantilla;
import com.banorte.backend.contrato.services.IPlantillaService;

@Service
public class PlantillaServiceImpl implements IPlantillaService{
	
	@Autowired
	private IPlantillaDao plantillaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Plantilla> findAll() {
		return (List<Plantilla>) plantillaDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Plantilla>findAll(Pageable pageable) {
		return plantillaDao.findAll(pageable);
	
	}
	@Override
	@Transactional(readOnly = true)
	public Plantilla findById(Long id) {
		// TODO Auto-generated method stub
		return plantillaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Plantilla save(Plantilla cliente) {
		// TODO Auto-generated method stub
		return plantillaDao.save(cliente);
	}

	@Override
	@Transactional
	public void Delete(Long id) {
		plantillaDao.deleteById(id);
		// TODO Auto-generated method stub
	}
	

}

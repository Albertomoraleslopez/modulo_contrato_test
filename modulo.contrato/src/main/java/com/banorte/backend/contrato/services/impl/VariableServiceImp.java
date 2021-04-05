package com.banorte.backend.contrato.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banorte.backend.contrato.dao.IVariablesDao;
import com.banorte.backend.contrato.models.entity.Variables;
import com.banorte.backend.contrato.services.IVariablesService;


@Service
public class VariableServiceImp implements IVariablesService {
	

	@Autowired
	private IVariablesDao variablesDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Variables> findAll() {
		return (List<Variables>) variablesDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Variables>findAll(Pageable pageable) {
		return variablesDao.findAll(pageable);
	
	}
	@Override
	@Transactional(readOnly = true)
	public Variables findById(Long id) {
		// TODO Auto-generated method stub
		return variablesDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Variables save(Variables variables) {
		// TODO Auto-generated method stub
		return variablesDao.save(variables);
	}

	@Override
	@Transactional
	public void Delete(Long id) {
		variablesDao.deleteById(id);
		// TODO Auto-generated method stub
	}
	


}

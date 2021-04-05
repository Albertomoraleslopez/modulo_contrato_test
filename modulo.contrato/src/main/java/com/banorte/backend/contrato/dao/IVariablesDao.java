package com.banorte.backend.contrato.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banorte.backend.contrato.models.entity.Variables;

public interface IVariablesDao extends JpaRepository<Variables, Long> {

}

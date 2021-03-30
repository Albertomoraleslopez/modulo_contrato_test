package com.banorte.backend.contrato.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banorte.backend.contrato.models.entity.Agrupacion;


public interface IAgrupacionDao extends JpaRepository<Agrupacion, Long> {

}

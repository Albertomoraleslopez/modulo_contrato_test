package com.banorte.backend.contrato.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banorte.backend.contrato.models.entity.Detalle_agrupacion;

public interface IDetalleAgrupacionDao extends JpaRepository<Detalle_agrupacion, Long>{

}

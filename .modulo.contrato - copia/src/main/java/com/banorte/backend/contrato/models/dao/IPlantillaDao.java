package com.banorte.backend.contrato.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banorte.backend.contrato.models.entity.Plantilla;


public interface IPlantillaDao extends JpaRepository<Plantilla, Long>{

}

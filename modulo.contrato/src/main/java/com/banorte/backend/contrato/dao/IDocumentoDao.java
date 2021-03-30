package com.banorte.backend.contrato.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banorte.backend.contrato.models.entity.Documento;

public interface IDocumentoDao extends JpaRepository<Documento, Long> {

}

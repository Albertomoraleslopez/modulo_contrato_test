package com.banorte.backend.contrato.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banorte.backend.contrato.models.entity.Tipo_documento;

public interface ITipoDocumentoDao extends JpaRepository<Tipo_documento, Long> {

}

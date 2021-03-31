package com.banorte.backend.contrato.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banorte.backend.contrato.models.entity.Subtipo_documento;

public interface ISubTipo_documentoDao extends JpaRepository<Subtipo_documento, Long> {

}

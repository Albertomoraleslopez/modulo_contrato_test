package com.banorte.backend.contrato.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banorte.backend.contrato.models.entity.Producto;

public interface IProductosDao extends JpaRepository<Producto, Long> {

}

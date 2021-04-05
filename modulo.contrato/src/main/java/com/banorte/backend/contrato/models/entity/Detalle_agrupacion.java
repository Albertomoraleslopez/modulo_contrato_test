package com.banorte.backend.contrato.models.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "detalle_agrupacion")
public class Detalle_agrupacion {

	
	@NotEmpty
	@Size(min=4, max=4)
	@Column(nullable = false)
	private Long id_agrupacion;
	

	@NotEmpty
	@Size(min=4, max=4)
	@Column(nullable = false)
	private Long id_documento;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "documento_seq", sequenceName = "documento_id_seq", allocationSize = 1, initialValue = 100)
	@Basic(optional = false)
	@Column(name = "id_detalle_agrupacion")
	private Long id_detalle_agrupacion;
	
	
	public Long getId_agrupacion() {
		return id_agrupacion;
	}
	public void setId_agrupacion(Long id_agrupacion) {
		this.id_agrupacion = id_agrupacion;
	}
	public Long getId_documento() {
		return id_documento;
	}
	public void setId_documento(Long id_documento) {
		this.id_documento = id_documento;
	}
	public Long getId_detalle_agrupacion() {
		return id_detalle_agrupacion;
	}
	public void setId_detalle_agrupacion(Long id_detalle_agrupacion) {
		this.id_detalle_agrupacion = id_detalle_agrupacion;
	}
	
	
}

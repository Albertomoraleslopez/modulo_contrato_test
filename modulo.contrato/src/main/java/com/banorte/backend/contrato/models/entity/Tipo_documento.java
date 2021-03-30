package com.banorte.backend.contrato.models.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Tipo_documento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "tipo_doc_seq", sequenceName = "tipo_doc_id_seq", allocationSize = 1, initialValue = 100)
	@Basic(optional = false)
	@Column(name = "id_tipo_doc")
	private Long id_tipo_doc;
	

	@NotEmpty
	@Size(min=4, max=30)
	@Column(nullable = false)
	private String Nombre;

	@NotEmpty
	@Size(min=4, max=100)
	@Column(nullable = false)
	private String Descripcion;
	
	
	
	public Long getId_tipo_doc() {
		return id_tipo_doc;
	}
	public void setId_tipo_doc(Long id_tipo_doc) {
		this.id_tipo_doc = id_tipo_doc;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	
}

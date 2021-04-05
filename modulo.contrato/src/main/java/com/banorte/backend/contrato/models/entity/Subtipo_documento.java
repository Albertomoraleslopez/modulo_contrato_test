package com.banorte.backend.contrato.models.entity;

import java.io.Serializable;

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
@Table(name = "subtipo_documento")
public class Subtipo_documento implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "subtipo_doc_seq", sequenceName = "subtipo_doc_id_seq", allocationSize = 1, initialValue = 100)
	@Basic(optional = false)
	@Column(name = "id_subtipo_doc")
	private Long id_subtipo_doc;
	
	@NotEmpty
	@Size(min=4, max=30)
	@Column(nullable = false)
	private String Nombre;
	
	@NotEmpty
	@Size(min=4, max=100)
	@Column(nullable = false)
	private String Descripcion;
	
	
	public Long getId_subtipo_doc() {
		return id_subtipo_doc;
	}
	public void setId_subtipo_doc(Long id_subtipo_doc) {
		this.id_subtipo_doc = id_subtipo_doc;
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

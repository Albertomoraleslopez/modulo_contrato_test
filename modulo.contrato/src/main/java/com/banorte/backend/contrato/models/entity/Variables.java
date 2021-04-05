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
@Table(name = "variables")
public class Variables implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "variables_seq", sequenceName = "variable_id_seq", allocationSize = 1, initialValue = 100)
	@Basic(optional = false)
	@Column(name = "id_variable")
	private Long idVariable;
	
	@NotEmpty
	@Size(min = 4, max = 30)
	@Column(nullable = false)
	private String nombre;
	
	
	public Long getIdVariable() {
		return idVariable;
	}
	public void setIdVariable(Long idVariable) {
		this.idVariable = idVariable;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}

package com.banorte.backend.contrato.models.entity;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "agrupacion")
public class Agrupacion implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "agrupacion_seq", sequenceName = "agrupacion_id_seq", allocationSize = 1, initialValue = 100)
	@Basic(optional = false)
	@Column(name = "id_agrupacion")
	private Long id_agrupacion;
	
	@NotEmpty
	@Size(min=2, max=30)
	@Column(nullable = false)
	private String usuario;
	
	@NotEmpty
	@Column(nullable = false)
	private Date fecha_creacion;
	
	
	public Long getId_agrupacion() {
		return id_agrupacion;
	}
	public void setId_agrupacion(Long id_agrupacion) {
		this.id_agrupacion = id_agrupacion;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	
	
}

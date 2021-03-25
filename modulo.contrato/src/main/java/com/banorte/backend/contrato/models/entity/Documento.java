package com.banorte.backend.contrato.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="documento")
public class Documento implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "documento_seq", sequenceName = "documento_id_seq", allocationSize = 1, initialValue = 100)
	@Basic(optional = false)
	@Column(name = "id_documento") 	
	private long id_documento; 
	

	//private long id_plantilla; 
	
	private Date fecha_creacion; 
	private Long usuario_creador;
	
	@NotEmpty
	@Size(min=4, max=4)
	@Column(nullable = false)
	private String version; 
	
	@NotEmpty
	@Size(min=4, max=15)
	@Column(nullable = false)
	private String status;
	
	@NotEmpty
	@Size(min=4, max=15)
	@Column(nullable = false)
	private String reca; 
	
	@NotEmpty
	@Size(min=4, max=30)
	@Column(nullable = false)
	private String aprobacion; 
	
	//@Lob
	@NotEmpty
	@Size(min=4, max=30)
	@Column(nullable = false)
	private String contenido_documento;
	
	@PrePersist
	public void prePersist() {
		fecha_creacion = new Date();
	}
	
	public long getId_documento() {
		return id_documento;
	}
	public void setId_documento(long id_documento) {
		this.id_documento = id_documento;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public Long getUsuario_creador() {
		return usuario_creador;
	}
	public void setUsuario_creador(Long usuario_creador) {
		this.usuario_creador = usuario_creador;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReca() {
		return reca;
	}
	public void setReca(String reca) {
		this.reca = reca;
	}
	public String getAprobacion() {
		return aprobacion;
	}
	public void setAprobacion(String aprobacion) {
		this.aprobacion = aprobacion;
	}
	public String getContenido_documento() {
		return contenido_documento;
	}
	public void setContenido_documento(String contenido_documento) {
		this.contenido_documento = contenido_documento;
	}
	
	
	
}

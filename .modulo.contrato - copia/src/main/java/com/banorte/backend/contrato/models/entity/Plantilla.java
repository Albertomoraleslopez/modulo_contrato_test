package com.banorte.backend.contrato.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="plantilla")
public class Plantilla implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "plantilla_seq", sequenceName = "plantilla_id_seq", allocationSize = 1, initialValue = 100)
	@Basic(optional = false)
	@Column(name = "id_plantilla") 
	private Long id_plantilla;
	
	@NotEmpty
	@Size(min=4, max=30)
	@Column(nullable = false)
	private String nombre;
	
	

	private Long id_tipo_doc;
	private Long id_subtipo_doc;
	private Long id_producto;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fecha_creacion;
	
	private Long usuario_creador;
	
	@NotEmpty
	@Size(min=4, max=4)
	@Column(nullable = false)
	private String version;
	
	@NotEmpty
	@Size(min=4, max=20)
	@Column(nullable = false)
	private String status;
	
	@NotEmpty
	@Size(min=4, max=20)
	@Column(nullable = false)
	private String ambiente;
	
	@NotEmpty
	@Size(min=15, max=15)
	@Column(nullable = false)
	private String reca;
	
	@NotEmpty
	@Size(min=1, max=2)
	@Column(nullable = false)
	private String aprobacion;
	
	@NotEmpty
	@Column(nullable = false)
	private String contenido_plantilla;
	
	
	@PrePersist
	public void prePersist() {
		fecha_creacion = new Date();
	}
	
	
	public Plantilla() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getId_plantilla() {
		return id_plantilla;
	}
	public void setId_plantilla(Long id_plantilla) {
		this.id_plantilla = id_plantilla;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getId_tipo_doc() {
		return id_tipo_doc;
	}
	public void setId_tipo_doc(Long id_tipo_doc) {
		this.id_tipo_doc = id_tipo_doc;
	}
	public Long getId_subtipo_doc() {
		return id_subtipo_doc;
	}
	public void setId_subtipo_doc(Long id_subtipo_doc) {
		this.id_subtipo_doc = id_subtipo_doc;
	}
	
	public Long getId_producto() {
		return id_producto;
	}

	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
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
	public String getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
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
	public String getContenido_plantilla() {
		return contenido_plantilla;
	}
	public void setContenido_plantilla(String contenido_plantilla) {
		this.contenido_plantilla = contenido_plantilla;
	}
	
	
	
}

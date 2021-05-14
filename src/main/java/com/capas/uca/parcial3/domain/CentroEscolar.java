package com.capas.uca.parcial3.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.SequenceGenerator;

@Entity
@Table(schema="public",name="centroEscolar")
public class CentroEscolar {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idCentroEscolar")
	private Integer idCentroEscolar;
	
	@Column(name="nombre")
	@Size(max=200, message="El campo sobrepasa la cantidad de 200 caracteres!")
	@NotEmpty(message="No puede ir vacio!")
	private String nombre;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fkmunicipio")
	private Municipio municipio;
	
	@Transient
	private Integer fkMunicipio;
	
	@Column(name="descripcion")
	@Size(max=300, message="El campo sobrepasa la cantidad de 300 caracteres!")
	@NotEmpty(message="No puede ir vacio!")
	private String descripcion;
	
	@Column(name="estado")
	private Boolean estado;
	
	public CentroEscolar() {
		
	}

	public Integer getIdCentroEscolar() {
		return idCentroEscolar;
	}

	public void setIdCentroEscolar(Integer idCentroEscolar) {
		this.idCentroEscolar = idCentroEscolar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Integer getIdMunicipio() {
		return fkMunicipio;
	}

	public void setIdMunicipio(Integer idMunicipio) {
		this.fkMunicipio = idMunicipio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	public String getDelegateEstado() {
		return estado ? "Activo":"Inactivo";
	}
	

}

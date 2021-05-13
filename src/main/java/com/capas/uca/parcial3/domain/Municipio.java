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
import javax.validation.constraints.Size;
import javax.persistence.SequenceGenerator;

@Entity
@Table(schema="public",name="municipio")
public class Municipio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idMunicipio")
	private Integer idMunicipio;
	
	@Column(name="nombreMunicipio")
	private String nombreMunicipio;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fkDepartamento")
	private Departamento departamento;
	
	@Transient
	private Integer idDepartamento;

	@OneToMany(mappedBy="municipio",fetch=FetchType.LAZY)
	private List<Usuario> usuario;
	
	@OneToMany(mappedBy="municipio",fetch=FetchType.LAZY)
	private List<Estudiante> estudiante;
	
	public Municipio() {
		
	}
	
	public Integer getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public String getNombreMunicipio() {
		return nombreMunicipio;
	}

	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	public List<Estudiante> getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(List<Estudiante> estudiante) {
		this.estudiante = estudiante;
	}
	
	

}

package com.capas.uca.parcial3.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(schema="public",name="SERVICIOS_ESCUELA")
public class Servicio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idServicioEscuela")
	private Integer idApoyo;

	@Column(name="instalacion_electrica")
	private Boolean instalacion_electrica;
	
	@Column(name="funciona_instalacion_electrica")
	private Boolean funciona_instalacion_electrica;
	
	@Column(name="servicios_sanitarios")
	private Boolean servicios_sanitarios;
	
	@Column(name="computadoras_estudiante")
	private Boolean computadoras_estudiante;
	
	@Column(name="servicio_internet")
	private Boolean servicio_internet;
	/*
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fkCentroEscolar")
	private CentroEscolar fkCentroEscolar;
	*/
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fkCentroEscolar", referencedColumnName = "idcentroescolar")
    private CentroEscolar fkCentroEscolar;
	
	@Transient
	@Id
	private Integer idCentroEscolar;
	
	public Integer getIdApoyo() {
		return idApoyo;
	}

	public void setIdApoyo(Integer idApoyo) {
		this.idApoyo = idApoyo;
	}

	public Boolean getInstalacion_electrica() {
		return instalacion_electrica;
	}

	public void setInstalacion_electrica(Boolean instalacion_electrica) {
		this.instalacion_electrica = instalacion_electrica;
	}

	public Boolean getFunciona_instalacion_electrica() {
		return funciona_instalacion_electrica;
	}

	public void setFunciona_instalacion_electrica(Boolean funciona_instalacion_electrica) {
		this.funciona_instalacion_electrica = funciona_instalacion_electrica;
	}

	public Boolean getServicios_sanitarios() {
		return servicios_sanitarios;
	}

	public void setServicios_sanitarios(Boolean servicios_sanitarios) {
		this.servicios_sanitarios = servicios_sanitarios;
	}

	public Boolean getComputadoras_estudiante() {
		return computadoras_estudiante;
	}

	public void setComputadoras_estudiante(Boolean computadoras_estudiante) {
		this.computadoras_estudiante = computadoras_estudiante;
	}

	public Boolean getServicio_internet() {
		return servicio_internet;
	}

	public void setServicio_internet(Boolean servicio_internet) {
		this.servicio_internet = servicio_internet;
	}

	public CentroEscolar getFkCentroEscolar() {
		return fkCentroEscolar;
	}

	public void setFkCentroEscolar(CentroEscolar fkCentroEscolar) {
		this.fkCentroEscolar = fkCentroEscolar;
	}

	public Integer getIdCentroEscolar() {
		return idCentroEscolar;
	}

	public void setIdCentroEscolar(Integer idCentroEscolar) {
		this.idCentroEscolar = idCentroEscolar;
	}
	
	public Servicio() {
		
	}

}

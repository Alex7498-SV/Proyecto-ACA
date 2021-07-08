package com.capas.uca.parcial3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;

@Entity
@Table(schema="public",name="APOYOXESCUELA")
public class Apoyoxescuela {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idApoyoEscuela")
	private Integer idApoyoEscuela;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fkApoyo")
	private Apoyo fkApoyo;
	
	@Transient
	@Id
	private Integer idApoyo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fkCentroEscolar")
	private CentroEscolar fkCentroEscolar;
	
	@Transient
	@Id
	private Integer idCentroEscolar;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fkTipoApoyo")
	private TipoApoyo fkTipoApoyo;
	
	@Transient
	@Id
	private Integer idTipoApoyo;
	
	public Apoyoxescuela() {
		
	}
	
	public Integer getIdApoyoEscuela() {
		return idApoyoEscuela;
	}

	public void setIdApoyoEscuela(Integer idApoyoEscuela) {
		this.idApoyoEscuela = idApoyoEscuela;
	}

	public Apoyo getFkApoyo() {
		return fkApoyo;
	}

	public void setFkApoyo(Apoyo fkApoyo) {
		this.fkApoyo = fkApoyo;
	}

	public Integer getIdApoyo() {
		return idApoyo;
	}

	public void setIdApoyo(Integer idApoyo) {
		this.idApoyo = idApoyo;
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

	public TipoApoyo getFkTipoApoyo() {
		return fkTipoApoyo;
	}

	public void setFkTipoApoyo(TipoApoyo fkTipoApoyo) {
		this.fkTipoApoyo = fkTipoApoyo;
	}

	public Integer getIdTipoApoyo() {
		return idTipoApoyo;
	}

	public void setIdTipoApoyo(Integer idTipoApoyo) {
		this.idTipoApoyo = idTipoApoyo;
	}
}

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
@Table(schema="public",name="NECESIDADES_ESPECIALES")
public class Necesidades {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idNecesidadEspecial")
	private Integer idNecesidadEspecial;

	@Column(name="rampa")
	private Boolean rampa;
	
	@Column(name="pasamanos")
	private Boolean pasamanos;
	
	@Column(name="sanitariosEspeciales")
	private Boolean sanitariosEspeciales;
	
	@Column(name="noPosee")
	private Boolean noPosee;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fkCentroEscolar", referencedColumnName = "idcentroescolar")
    private CentroEscolar fkCentroEscolar;
	
	@Transient
	@Id
	private Integer idCentroEscolar;
	
	public Integer getIdNecesidadEspecial() {
		return idNecesidadEspecial;
	}

	public void setIdNecesidadEspecial(Integer idNecesidadEspecial) {
		this.idNecesidadEspecial = idNecesidadEspecial;
	}

	public Boolean getRampa() {
		return rampa;
	}

	public void setRampa(Boolean rampa) {
		this.rampa = rampa;
	}

	public Boolean getPasamanos() {
		return pasamanos;
	}

	public void setPasamanos(Boolean pasamanos) {
		this.pasamanos = pasamanos;
	}

	public Boolean getSanitariosEspeciales() {
		return sanitariosEspeciales;
	}

	public void setSanitariosEspeciales(Boolean sanitariosEspeciales) {
		this.sanitariosEspeciales = sanitariosEspeciales;
	}

	public Boolean getNoPosee() {
		return noPosee;
	}

	public void setNoPosee(Boolean noPosee) {
		this.noPosee = noPosee;
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
	
	public Necesidades() {
		
	}
}

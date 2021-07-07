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
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(schema="public", name="equipoxescuela")
public class EquipoXEscuela {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idEquipoxEscuela")
	private Integer idEquipoxEscuela;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fkEquipo")
	private Equipo equipo;
	
	@Transient
	private Integer idEquipo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fkCentroEscolar")
	private CentroEscolar centroescolar;
	
	@Transient
	private Integer idCentroEscolar;
	
	@Column(name="buena_condicion")
	private Integer buena_condicion;
	
	@Column(name="mala_condicion")
	private Integer mala_condicion;
	
	@Column(name="arrendada")
	private Integer arrendada;
	
	@Column(name="utilizadas")
	private Integer utilizadas;
	
	
	public EquipoXEscuela() {
		
	}
	
		public Integer getIdEquipoxEscuela() {
		return idEquipoxEscuela;
	}


	public void setIdEquipoxEscuela(Integer idEquipoxEscuela) {
		this.idEquipoxEscuela = idEquipoxEscuela;
	}


	public Equipo getEquipo() {
		return equipo;
	}


	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}


	public Integer getIdEquipo() {
		return idEquipo;
	}


	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}


	public CentroEscolar getCentroescolar() {
		return centroescolar;
	}


	public void setCentroescolar(CentroEscolar centroescolar) {
		this.centroescolar = centroescolar;
	}


	public Integer getIdCentroEscolar() {
		return idCentroEscolar;
	}


	public void setIdCentroEscolar(Integer idCentroEscolar) {
		this.idCentroEscolar = idCentroEscolar;
	}


	public Integer getBuena_condicion() {
		return buena_condicion;
	}


	public void setBuena_condicion(Integer buena_condicion) {
		this.buena_condicion = buena_condicion;
	}


	public Integer getMala_condicion() {
		return mala_condicion;
	}


	public void setMala_condicion(Integer mala_condicion) {
		this.mala_condicion = mala_condicion;
	}


	public Integer getArrendada() {
		return arrendada;
	}


	public void setArrendada(Integer arrendada) {
		this.arrendada = arrendada;
	}


	public Integer getUtilizadas() {
		return utilizadas;
	}


	public void setUtilizadas(Integer utilizadas) {
		this.utilizadas = utilizadas;
	}
	
}

package com.capas.uca.parcial3.domain;

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
@Table(schema="public",name="INFRAESTRUCTURA")
public class Infraestructura {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idInfraestructura")
	private Integer idInfraestructura;

	@Column(name="biblioteca")
	private Boolean biblioteca;
	
	@Column(name="centro_computo")
	private Boolean centro_computo;
	
	@Column(name="laboratorio_ciencia")
	private Boolean laboratorio_ciencia;
	
	@Column(name="aula_apoyo_educativo")
	private Boolean aula_apoyo_educativo;
	
	@Column(name="cancha_futbol")
	private Boolean cancha_futbol;
	
	@Column(name="cancha_basquetbol")
	private Boolean cancha_basquetbol;
	
	@Column(name="laboratorio_ingles")
	private Boolean laboratorio_ingles;
	
	@Column(name="granja_agricola")
	private Boolean granja_agricola;
	
	@Column(name="area_administrativa")
	private Boolean area_administrativa;
	
	@Column(name="sala_profesores")
	private Boolean sala_profesores;
	
	@Column(name="clinica_para_estudiantes")
	private Boolean clinica_para_estudiantes;
	
	@Column(name="talleres_bachillerato_industrial")
	private Boolean talleres_bachillerato_industrial;
	
	@Column(name="clinica_bachillerato_en_salud")
	private Boolean clinica_bachillerato_en_salud;
	
	@Column(name="salon_usos_multiples")
	private Boolean salon_usos_multiples;
	
	@Column(name="espacio_recreativo")
	private Boolean espacio_recreativo;
	
	@Column(name="comedor")
	private Boolean comedor;
	
	@Column(name="bodega")
	private Boolean bodega;
	
	@Column(name="cocina")
	private Boolean cocina;
	
	@Column(name="cocina_bodigo")
	private Boolean cocina_bodigo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fkCentroEscolar")
	private CentroEscolar fkCentroEscolar;
	
	@Transient
	@Id
	private Integer idCentroEscolar;
	
	public Infraestructura() {
		
	}
	
	public Integer getIdInfraestructura() {
		return idInfraestructura;
	}

	public void setIdInfraestructura(Integer idInfraestructura) {
		this.idInfraestructura = idInfraestructura;
	}

	public Boolean getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(Boolean biblioteca) {
		this.biblioteca = biblioteca;
	}

	public Boolean getCentro_computo() {
		return centro_computo;
	}

	public void setCentro_computo(Boolean centro_computo) {
		this.centro_computo = centro_computo;
	}

	public Boolean getLaboratorio_ciencia() {
		return laboratorio_ciencia;
	}

	public void setLaboratorio_ciencia(Boolean laboratorio_ciencia) {
		this.laboratorio_ciencia = laboratorio_ciencia;
	}

	public Boolean getAula_apoyo_educativo() {
		return aula_apoyo_educativo;
	}

	public void setAula_apoyo_educativo(Boolean aula_apoyo_educativo) {
		this.aula_apoyo_educativo = aula_apoyo_educativo;
	}

	public Boolean getCancha_futbol() {
		return cancha_futbol;
	}

	public void setCancha_futbol(Boolean cancha_futbol) {
		this.cancha_futbol = cancha_futbol;
	}

	public Boolean getCancha_basquetbol() {
		return cancha_basquetbol;
	}

	public void setCancha_basquetbol(Boolean cancha_basquetbol) {
		this.cancha_basquetbol = cancha_basquetbol;
	}

	public Boolean getLaboratorio_ingles() {
		return laboratorio_ingles;
	}

	public void setLaboratorio_ingles(Boolean laboratorio_ingles) {
		this.laboratorio_ingles = laboratorio_ingles;
	}

	public Boolean getGranja_agricola() {
		return granja_agricola;
	}

	public void setGranja_agricola(Boolean granja_agricola) {
		this.granja_agricola = granja_agricola;
	}

	public Boolean getArea_administrativa() {
		return area_administrativa;
	}

	public void setArea_administrativa(Boolean area_administrativa) {
		this.area_administrativa = area_administrativa;
	}

	public Boolean getSala_profesores() {
		return sala_profesores;
	}

	public void setSala_profesores(Boolean sala_profesores) {
		this.sala_profesores = sala_profesores;
	}

	public Boolean getClinica_para_estudiantes() {
		return clinica_para_estudiantes;
	}

	public void setClinica_para_estudiantes(Boolean clinica_para_estudiantes) {
		this.clinica_para_estudiantes = clinica_para_estudiantes;
	}

	public Boolean getTalleres_bachillerato_industrial() {
		return talleres_bachillerato_industrial;
	}

	public void setTalleres_bachillerato_industrial(Boolean talleres_bachillerato_industrial) {
		this.talleres_bachillerato_industrial = talleres_bachillerato_industrial;
	}

	public Boolean getClinica_bachillerato_en_salud() {
		return clinica_bachillerato_en_salud;
	}

	public void setClinica_bachillerato_en_salud(Boolean clinica_bachillerato_en_salud) {
		this.clinica_bachillerato_en_salud = clinica_bachillerato_en_salud;
	}

	public Boolean getSalon_usos_multiples() {
		return salon_usos_multiples;
	}

	public void setSalon_usos_multiples(Boolean salon_usos_multiples) {
		this.salon_usos_multiples = salon_usos_multiples;
	}

	public Boolean getEspacio_recreativo() {
		return espacio_recreativo;
	}

	public void setEspacio_recreativo(Boolean espacio_recreativo) {
		this.espacio_recreativo = espacio_recreativo;
	}

	public Boolean getComedor() {
		return comedor;
	}

	public void setComedor(Boolean comedor) {
		this.comedor = comedor;
	}

	public Boolean getBodega() {
		return bodega;
	}

	public void setBodega(Boolean bodega) {
		this.bodega = bodega;
	}

	public Boolean getCocina() {
		return cocina;
	}

	public void setCocina(Boolean cocina) {
		this.cocina = cocina;
	}

	public Boolean getCocina_bodigo() {
		return cocina_bodigo;
	}

	public void setCocina_bodego(Boolean cocina_bodigo) {
		this.cocina_bodigo = cocina_bodigo;
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
}

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
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.SequenceGenerator;


@Entity
@Table(schema = "public", name = "Poblacion_Estudiantil")
public class Poblacion_Estudiantil{
	
	@Id
	@Column(name = "idPoblacionEstudiantil")
	private Integer idPoblacionEstudiantil;
	
	@Column(name = "parvularia")
	private Integer parvularia;
	
	@Column(name = "ciclo_I")
	private Integer ciclo_I;
	
	@Column(name = "ciclo_II")
	private Integer ciclo_II;
	
	@Column(name = "ciclo_III")
	private Integer ciclo_III;
	
	@Column(name = "educacion_media")
	private Integer educacion_media;
	
	@Transient
	private Integer fkCentroEscolar;

	public Integer getIdPoblacionEstudiantil() {
		return idPoblacionEstudiantil;
	}

	public void setIdPoblacionEstudiantil(Integer idPoblacionEstudiantil) {
		this.idPoblacionEstudiantil = idPoblacionEstudiantil;
	}

	public Integer getParvularia() {
		return parvularia;
	}

	public void setParvularia(Integer parvularia) {
		this.parvularia = parvularia;
	}

	public Integer getCiclo_I() {
		return ciclo_I;
	}

	public void setCiclo_I(Integer ciclo_I) {
		this.ciclo_I = ciclo_I;
	}

	public Integer getCiclo_II() {
		return ciclo_II;
	}

	public void setCiclo_II(Integer ciclo_II) {
		this.ciclo_II = ciclo_II;
	}

	public Integer getCiclo_III() {
		return ciclo_III;
	}

	public void setCiclo_III(Integer ciclo_III) {
		this.ciclo_III = ciclo_III;
	}

	public Integer getEducacion_media() {
		return educacion_media;
	}

	public void setEducacion_media(Integer educacion_media) {
		this.educacion_media = educacion_media;
	}
	
	
}
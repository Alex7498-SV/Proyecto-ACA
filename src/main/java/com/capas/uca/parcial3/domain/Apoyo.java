package com.capas.uca.parcial3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="apoyo")
public class Apoyo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idApoyo")
	private Integer idApoyo;

	@Column(name="nombre_organismo")
	private String nombre_organismo;
	
	public Integer getIdApoyo() {
		return idApoyo;
	}

	public void setIdApoyo(Integer idApoyo) {
		this.idApoyo = idApoyo;
	}

	public String getNombre_organismo() {
		return nombre_organismo;
	}

	public void setNombre_organismo(String nombre_organismo) {
		this.nombre_organismo = nombre_organismo;
	}
	
	public Apoyo() {
		
	}
	
}

package com.capas.uca.parcial3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="tipo_apoyo")
public class TipoApoyo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idTipoApoyo")
	private Integer idTipoApoyo;

	@Column(name="nombre_tipo_apoyo")
	private String nombre_tipo_apoyo;
	
	public TipoApoyo() {
		
	}
	
	public Integer getIdTipoApoyo() {
		return idTipoApoyo;
	}

	public void setIdTipoApoyo(Integer idTipoApoyo) {
		this.idTipoApoyo = idTipoApoyo;
	}

	public String getNombre_tipo_apoyo() {
		return nombre_tipo_apoyo;
	}

	public void setNombre_tipo_apoyo(String nombre_tipo_apoyo) {
		this.nombre_tipo_apoyo = nombre_tipo_apoyo;
	}
	
}

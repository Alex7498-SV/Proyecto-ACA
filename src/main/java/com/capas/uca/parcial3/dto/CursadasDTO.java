package com.capas.uca.parcial3.dto;

public class CursadasDTO {

	public Integer idMateriaXestudiante;
	public Integer idestudiante;
	public Integer idmateria;
	public String nombremateria;
	public Integer anio;
	public Integer ciclo;
	public float nota;
	
	public CursadasDTO() {
		super();
	}

	public Integer getIdestudiante() {
		return idestudiante;
	}

	public void setIdestudiante(Integer idestudiante) {
		this.idestudiante = idestudiante;
	}

	public Integer getIdmateria() {
		return idmateria;
	}

	public void setIdmateria(Integer idmateria) {
		this.idmateria = idmateria;
	}

	public String getNombremateria() {
		return nombremateria;
	}

	public void setNombremateria(String nombremateria) {
		this.nombremateria = nombremateria;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getCiclo() {
		return ciclo;
	}

	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}
	public String getDelegateNota() {
		Boolean estado;
		if(nota >= 6) {
			estado = true;
		}else {
			estado = false;
		}
		return estado ? "Aprobado":"Reprobado";
	}
	public Integer getIdMateriaXestudiante() {
		return idMateriaXestudiante;
	}

	public void setIdMateriaXestudiante(Integer idMateriaXestudiante) {
		this.idMateriaXestudiante = idMateriaXestudiante;
	}
}

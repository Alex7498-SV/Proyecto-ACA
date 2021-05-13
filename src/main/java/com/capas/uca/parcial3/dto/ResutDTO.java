package com.capas.uca.parcial3.dto;

public class ResutDTO {
	
	public Integer id;
	public String nombre;
	public String apellido;
	public Integer aprobadas;
	public Integer reprobadas;
	public float prom;
	
	public ResutDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getAprobadas() {
		return aprobadas;
	}

	public void setAprobadas(Integer aprobadas) {
		this.aprobadas = aprobadas;
	}

	public Integer getReprobadas() {
		return reprobadas;
	}

	public void setReprobadas(Integer reprobadas) {
		this.reprobadas = reprobadas;
	}

	public float getProm() {
		return prom;
	}

	public void setProm(float prom) {
		this.prom = prom;
	}
	
}

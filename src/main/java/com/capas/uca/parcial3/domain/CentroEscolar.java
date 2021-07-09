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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.SequenceGenerator;

@Entity
@Table(schema="public",name="centro_escolar")
public class CentroEscolar {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idCentroEscolar")
	private Integer idCentroEscolar;

	@Column(name="nombre_escuela")
	private String nombre_escolar;
	
	@Column(name="sector")
	private Boolean sector;
	
	@Column(name="zona")
	private Boolean zona;
	
	@Column(name="direccion")
	private String Direccion;
	
	@Column(name="NIP")
	private String nip;
	
	@Column(name="numero_telefonico")
	private String numero_telefonico;
	
	@Column(name="numero_fax")
	private String numero_fax;
	
	@Column(name="correo_electronico")
	private String correo_electronico;
	
	@Column(name="numero_aula_total")
	private int numero_aula_total;
	
	@Column(name="numero_otros_espacios_total")
	private int numero_otros_espacios_total;
	
	@Column(name="latitud")
	private double latitud;
	
	@Column(name="longitud")
	private double longitud;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fkmunicipio")
	private Municipio municipio;
	
	@Transient
	private Integer fkMunicipio;
	
	@OneToOne(mappedBy = "fkCentroEscolar")
    private Infraestructura infraestructura;
	
	@OneToOne(mappedBy = "fkCentroEscolar")
    private Servicio servicio;
	
	@OneToOne(mappedBy = "fkCentroEscolar")
    private Necesidades necesidades;
	
	public CentroEscolar() {
		
	}	
	
	
	
	public Servicio getServicio() {
		return servicio;
	}



	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}



	public Necesidades getNecesidades() {
		return necesidades;
	}



	public void setNecesidades(Necesidades necesidades) {
		this.necesidades = necesidades;
	}



	public Infraestructura getInfraestructura() {
		return infraestructura;
	}

	public void setInfraestructura(Infraestructura infraestructura) {
		this.infraestructura = infraestructura;
	}

	public Integer getIdCentroEscolar() {
		return idCentroEscolar;
	}

	public void setIdCentroEscolar(Integer idCentroEscolar) {
		this.idCentroEscolar = idCentroEscolar;
	}

	public String getNombre() {
		return nombre_escolar;
	}

	public void setNombre(String nombre) {
		this.nombre_escolar = nombre;
	}

	public Boolean getSector() {
		return sector;
	}

	public void setSector(Boolean sector) {
		this.sector = sector;
	}

	public Boolean getZona() {
		return zona;
	}

	public void setZona(Boolean zona) {
		this.zona = zona;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getNumero_telefonico() {
		return numero_telefonico;
	}

	public void setNumero_telefonico(String numero_telefonico) {
		this.numero_telefonico = numero_telefonico;
	}

	public String getNumero_fax() {
		return numero_fax;
	}

	public void setNumero_fax(String numero_fax) {
		this.numero_fax = numero_fax;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public int getNumero_aula_total() {
		return numero_aula_total;
	}

	public void setNumero_aula_total(int numero_aula_total) {
		this.numero_aula_total = numero_aula_total;
	}

	public int getNumero_otros_espacios_total() {
		return numero_otros_espacios_total;
	}

	public void setNumero_otros_espacios_total(int numero_otros_espacior_total) {
		this.numero_otros_espacios_total = numero_otros_espacior_total;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Integer getFkMunicipio() {
		return fkMunicipio;
	}

	public void setFkMunicipio(Integer fkMunicipio) {
		this.fkMunicipio = fkMunicipio;
	}

}

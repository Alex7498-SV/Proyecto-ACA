package com.capas.uca.parcial3.domain;

import java.sql.Date;
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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.SequenceGenerator;

@Entity
@Table(schema="public",name="estudiante")
public class Estudiante {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idEstudiante")
	private Integer idEstudiante;
	
	@Column(name="nombre")
	@Size(max=20, message="El campo sobrepasa la cantidad de 20 caracteres!")
	@NotEmpty(message="No puede ir vacio!")
	private String nombre;
	
	@Column(name="apellido")
	@Size(max=20, message="El campo sobrepasa la cantidad de 20 caracteres!")
	@NotEmpty(message="No puede ir vacio!")
	private String apellido;
	
	@Column(name="carnet")
	@Size(max=9, min=9, message="El campo debe tener 9 caracteres!")
	@NotEmpty(message="No puede ir vacio!")
	private String carnet;
	
	@Column(name="fechaNac")
	private Date fechaNac;
	
	@Column(name="edad")
	private Integer edad;
	
	@Column(name="direccion")
	@Size(max=100, message="El campo sobrepasa la cantidad de 100 caracteres!")
	@NotEmpty(message="No puede ir vacio!")
	private String direccion;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fkMunicipio")
	private Municipio municipio;
	
	@Transient
	private Integer fkMunicipio;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fkDepartamento")
	private Departamento departamento;
	
	@Transient
	private Integer fkDepartamento;
	
	@Column(name="telefonoFijo")
	@Pattern(message="El campo debe tener el siguiente formato: 23412314" , regexp="[2]{1}[\\d]{7}")
	@NotEmpty(message="No puede ir vacio!")
	private String telefonoFijo;
	
	@Column(name="telefonoMovil")
	@Pattern(message="El campo debe tener el siguiente formato: 78124321 o 68124321" , regexp="[6-7]{1}[\\d]{7}")
	@NotEmpty(message="No puede ir vacio!")
	private String telefonoMovil;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fkCentroEscolar")
	private CentroEscolar centroEscolar;
	
	@Transient
	private Integer fkCentroEscolar;
	
	@Column(name="nombrePadre")
	@Size(max=50, message="El campo sobrepasa la cantidad de 50 caracteres!")
	@NotEmpty(message="No puede ir vacio!")
	private String nombrePadre;
	
	@Column(name="nombreMadre")
	@Size(max=50, message="El campo sobrepasa la cantidad de 50 caracteres!")
	@NotEmpty(message="No puede ir vacio!")
	private String nombreMadre;
	
	@OneToMany(mappedBy="estudiante",fetch=FetchType.LAZY)
	private List<MateriaXestudiante> materiaXestudiante;
	
	public Estudiante() {
		
	}

	public Integer getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(Integer idEstudiante) {
		this.idEstudiante = idEstudiante;
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

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public CentroEscolar getCentroEscolar() {
		return centroEscolar;
	}

	public void setCentroEscolar(CentroEscolar centroEscolar) {
		this.centroEscolar = centroEscolar;
	}

	public Integer getIdCentroEscolar() {
		return fkCentroEscolar;
	}

	public void setIdCentroEscolar(Integer idCentroEscolar) {
		this.fkCentroEscolar = idCentroEscolar;
	}

	public String getNombrePadre() {
		return nombrePadre;
	}

	public void setNombrePadre(String nombrePadre) {
		this.nombrePadre = nombrePadre;
	}

	public String getNombreMadre() {
		return nombreMadre;
	}

	public void setNombreMadre(String nombreMadre) {
		this.nombreMadre = nombreMadre;
	}

	public List<MateriaXestudiante> getMateriaXestudiante() {
		return materiaXestudiante;
	}

	public void setMateriaXestudiante(List<MateriaXestudiante> materiaXestudiante) {
		this.materiaXestudiante = materiaXestudiante;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Integer getIdMunicipio() {
		return fkMunicipio;
	}

	public void setIdMunicipio(Integer idMunicipio) {
		this.fkMunicipio = idMunicipio;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Integer getIdDepartamento() {
		return fkDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.fkDepartamento = idDepartamento;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Integer getFkMunicipio() {
		return fkMunicipio;
	}

	public void setFkMunicipio(Integer fkMunicipio) {
		this.fkMunicipio = fkMunicipio;
	}

	public Integer getFkDepartamento() {
		return fkDepartamento;
	}

	public void setFkDepartamento(Integer fkDepartamento) {
		this.fkDepartamento = fkDepartamento;
	}

	public Integer getFkCentroEscolar() {
		return fkCentroEscolar;
	}

	public void setFkCentroEscolar(Integer fkCentroEscolar) {
		this.fkCentroEscolar = fkCentroEscolar;
	}
	
	

}
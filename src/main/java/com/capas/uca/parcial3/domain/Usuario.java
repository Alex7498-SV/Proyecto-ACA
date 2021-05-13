package com.capas.uca.parcial3.domain;

import java.sql.Date;

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
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.SequenceGenerator;

@Entity
@Table(schema="public",name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(generator = "usuario_idusuario_seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name = "usuario_idusuario_seq", sequenceName = "usuario_idusuario_seq", allocationSize = 1)
	@Column(name="idUsuario")
	private Integer idUsuario;
	
	@Column(name="nombre")
	@Size(max=25, message="El campo sobrepasa la cantidad de 25 caracteres!")
	@NotEmpty(message="No puede ir vacio!")
	private String nombre;
	
	@Column(name="apellido")
	@Size(max=25, message="El campo sobrepasa la cantidad de 25 caracteres!")
	@NotEmpty(message="No puede ir vacio!")
	private String apellido;
	
	@Column(name="fechaNac")
	private Date fechaNac;
	
	@Column(name="edad")
	private Integer edad;
	
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
	
	@Column(name="direccion")
	@Size(max=100, message="El campo sobrepasa la cantidad de 100 caracteres!")
	@NotEmpty(message="No puede ir vacio!")
	private String direccion;
	
	@Column(name="nombreUser")
	@Size(max=25, message="El campo sobrepasa la cantidad de 25 caracteres!")
	@NotEmpty(message="No puede ir vacio!")
	private String nombreUser;
	
	@Column(name="contrasenia")
	@Size(max=25, message="El campo sobrepasa la cantidad de 25 caracteres!")
	@NotEmpty(message="No puede ir vacio!")
	private String contrasenia;
	
	@Column(name="tipoUsuario")
	private Boolean tipoUsuario;
	
	@Column(name="sesion")
	private Boolean sesion;

	@Column(name="estado")
	private Boolean estado;
	
	public Usuario() {
		
	}
	
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombreUser() {
		return nombreUser;
	}

	public void setNombreUser(String nombreUser) {
		this.nombreUser = nombreUser;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Boolean getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(Boolean tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Boolean getSesion() {
		return sesion;
	}

	public void setSesion(Boolean sesion) {
		this.sesion = sesion;
	}
	
	public String getDelegateSesion() {
		return sesion ? "Activo":"Inactivo";
	}

	public String getDelegateTipoUsuario() {
		return tipoUsuario ? "Administrador":"Coordinador";
	}
	
	public String getDelegateEstado() {
		return estado ? "Activo":"Inactivo";
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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	
	
}

package com.capas.uca.parcial3.domain.meta;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.capas.uca.parcial3.domain.Departamento;
import com.capas.uca.parcial3.domain.Municipio;
import com.capas.uca.parcial3.domain.Usuario;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, Boolean> estado;
	public static volatile SingularAttribute<Usuario, Boolean> sesion;
	public static volatile SingularAttribute<Usuario, Municipio> municipio;
	public static volatile SingularAttribute<Usuario, Integer> idUsuario;
	public static volatile SingularAttribute<Usuario, String> direccion;
	public static volatile SingularAttribute<Usuario, String> nombreUser;
	public static volatile SingularAttribute<Usuario, String> nombre;
	public static volatile SingularAttribute<Usuario, Integer> edad;
	public static volatile SingularAttribute<Usuario, Date> fechaNac;
	public static volatile SingularAttribute<Usuario, String> apellido;
	public static volatile SingularAttribute<Usuario, Departamento> departamento;
	public static volatile SingularAttribute<Usuario, String> contrasenia;
	public static volatile SingularAttribute<Usuario, Boolean> tipoUsuario;

	public static final String ESTADO = "estado";
	public static final String SESION = "sesion";
	public static final String MUNICIPIO = "municipio";
	public static final String ID_USUARIO = "idUsuario";
	public static final String DIRECCION = "direccion";
	public static final String NOMBRE_USER = "nombreUser";
	public static final String NOMBRE = "nombre";
	public static final String EDAD = "edad";
	public static final String FECHA_NAC = "fechaNac";
	public static final String APELLIDO = "apellido";
	public static final String DEPARTAMENTO = "departamento";
	public static final String CONTRASENIA = "contrasenia";
	public static final String TIPO_USUARIO = "tipoUsuario";

}


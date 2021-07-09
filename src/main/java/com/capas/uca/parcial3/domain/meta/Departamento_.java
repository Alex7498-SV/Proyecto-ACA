package com.capas.uca.parcial3.domain.meta;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.capas.uca.parcial3.domain.Departamento;
import com.capas.uca.parcial3.domain.Municipio;
import com.capas.uca.parcial3.domain.Usuario;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Departamento.class)
public abstract class Departamento_ {

	public static volatile SingularAttribute<Departamento, Integer> idDepartamento;
	public static volatile SingularAttribute<Departamento, String> nombreDepartamento;
	public static volatile ListAttribute<Departamento, Municipio> municipio;
	public static volatile ListAttribute<Departamento, Usuario> usuario;

	public static final String ID_DEPARTAMENTO = "idDepartamento";
	public static final String NOMBRE_DEPARTAMENTO = "nombreDepartamento";
	public static final String MUNICIPIO = "municipio";
	public static final String USUARIO = "usuario";

}


package com.capas.uca.parcial3.domain.meta;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.capas.uca.parcial3.domain.Departamento;
import com.capas.uca.parcial3.domain.Municipio;
import com.capas.uca.parcial3.domain.Usuario;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Municipio.class)
public abstract class Municipio_ {

	public static volatile SingularAttribute<Municipio, String> nombreMunicipio;
	public static volatile SingularAttribute<Municipio, Integer> idMunicipio;
	public static volatile SingularAttribute<Municipio, Departamento> departamento;
	public static volatile ListAttribute<Municipio, Usuario> usuario;

	public static final String NOMBRE_MUNICIPIO = "nombreMunicipio";
	public static final String ID_MUNICIPIO = "idMunicipio";
	public static final String DEPARTAMENTO = "departamento";
	public static final String USUARIO = "usuario";

}


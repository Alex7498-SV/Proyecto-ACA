package com.capas.uca.parcial3.domain.meta;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.capas.uca.parcial3.domain.Equipo;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Equipo.class)
public abstract class Equipo_ {

	public static volatile SingularAttribute<Equipo, Integer> idEquipo;
	public static volatile SingularAttribute<Equipo, String> nombre_equipo;

	public static final String ID_EQUIPO = "idEquipo";
	public static final String NOMBRE_EQUIPO = "nombre_equipo";

}


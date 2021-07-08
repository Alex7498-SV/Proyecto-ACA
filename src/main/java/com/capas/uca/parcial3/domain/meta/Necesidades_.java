package com.capas.uca.parcial3.domain.meta;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.capas.uca.parcial3.domain.CentroEscolar;
import com.capas.uca.parcial3.domain.Necesidades;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Necesidades.class)
public abstract class Necesidades_ {

	public static volatile SingularAttribute<Necesidades, Boolean> noPosee;
	public static volatile SingularAttribute<Necesidades, CentroEscolar> fkCentroEscolar;
	public static volatile SingularAttribute<Necesidades, Boolean> sanitariosEspeciales;
	public static volatile SingularAttribute<Necesidades, Boolean> rampa;
	public static volatile SingularAttribute<Necesidades, Boolean> pasamanos;
	public static volatile SingularAttribute<Necesidades, Integer> idNecesidadEspecial;

	public static final String NO_POSEE = "noPosee";
	public static final String FK_CENTRO_ESCOLAR = "fkCentroEscolar";
	public static final String SANITARIOS_ESPECIALES = "sanitariosEspeciales";
	public static final String RAMPA = "rampa";
	public static final String PASAMANOS = "pasamanos";
	public static final String ID_NECESIDAD_ESPECIAL = "idNecesidadEspecial";

}


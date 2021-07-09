package com.capas.uca.parcial3.domain.meta;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.capas.uca.parcial3.domain.Poblacion_Estudiantil;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Poblacion_Estudiantil.class)
public abstract class Poblacion_Estudiantil_ {

	public static volatile SingularAttribute<Poblacion_Estudiantil, Integer> ciclo_I;
	public static volatile SingularAttribute<Poblacion_Estudiantil, Integer> ciclo_III;
	public static volatile SingularAttribute<Poblacion_Estudiantil, Integer> ciclo_II;
	public static volatile SingularAttribute<Poblacion_Estudiantil, Integer> educacion_media;
	public static volatile SingularAttribute<Poblacion_Estudiantil, Integer> idPoblacionEstudiantil;
	public static volatile SingularAttribute<Poblacion_Estudiantil, Integer> parvularia;

	public static final String CICLO__I = "ciclo_I";
	public static final String CICLO__II_I = "ciclo_III";
	public static final String CICLO__II = "ciclo_II";
	public static final String EDUCACION_MEDIA = "educacion_media";
	public static final String ID_POBLACION_ESTUDIANTIL = "idPoblacionEstudiantil";
	public static final String PARVULARIA = "parvularia";

}


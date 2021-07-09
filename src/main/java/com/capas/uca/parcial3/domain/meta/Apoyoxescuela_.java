package com.capas.uca.parcial3.domain.meta;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.capas.uca.parcial3.domain.Apoyo;
import com.capas.uca.parcial3.domain.Apoyoxescuela;
import com.capas.uca.parcial3.domain.CentroEscolar;
import com.capas.uca.parcial3.domain.TipoApoyo;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Apoyoxescuela.class)
public abstract class Apoyoxescuela_ {

	public static volatile SingularAttribute<Apoyoxescuela, TipoApoyo> fkTipoApoyo;
	public static volatile SingularAttribute<Apoyoxescuela, CentroEscolar> fkCentroEscolar;
	public static volatile SingularAttribute<Apoyoxescuela, Integer> idApoyoEscuela;
	public static volatile SingularAttribute<Apoyoxescuela, Apoyo> fkApoyo;

	public static final String FK_TIPO_APOYO = "fkTipoApoyo";
	public static final String FK_CENTRO_ESCOLAR = "fkCentroEscolar";
	public static final String ID_APOYO_ESCUELA = "idApoyoEscuela";
	public static final String FK_APOYO = "fkApoyo";

}


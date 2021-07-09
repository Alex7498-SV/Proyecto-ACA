package com.capas.uca.parcial3.domain.meta;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.capas.uca.parcial3.domain.CentroEscolar;
import com.capas.uca.parcial3.domain.Equipo;
import com.capas.uca.parcial3.domain.EquipoXEscuela;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EquipoXEscuela.class)
public abstract class EquipoXEscuela_ {

	public static volatile SingularAttribute<EquipoXEscuela, Integer> arrendada;
	public static volatile SingularAttribute<EquipoXEscuela, Integer> mala_condicion;
	public static volatile SingularAttribute<EquipoXEscuela, Equipo> equipo;
	public static volatile SingularAttribute<EquipoXEscuela, Integer> idEquipoxEscuela;
	public static volatile SingularAttribute<EquipoXEscuela, Integer> utilizadas;
	public static volatile SingularAttribute<EquipoXEscuela, CentroEscolar> centroescolar;
	public static volatile SingularAttribute<EquipoXEscuela, Integer> buena_condicion;

	public static final String ARRENDADA = "arrendada";
	public static final String MALA_CONDICION = "mala_condicion";
	public static final String EQUIPO = "equipo";
	public static final String ID_EQUIPOX_ESCUELA = "idEquipoxEscuela";
	public static final String UTILIZADAS = "utilizadas";
	public static final String CENTROESCOLAR = "centroescolar";
	public static final String BUENA_CONDICION = "buena_condicion";

}


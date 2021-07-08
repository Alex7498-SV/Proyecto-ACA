package com.capas.uca.parcial3.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import com.capas.uca.parcial3.domain.CentroEscolar;
import com.capas.uca.parcial3.domain.Infraestructura;
import com.capas.uca.parcial3.domain.Necesidades;
import com.capas.uca.parcial3.domain.Servicio;
import com.capas.uca.parcial3.domain.meta.CentroEscolar_;
import com.capas.uca.parcial3.domain.meta.Infraestructura_;
import com.capas.uca.parcial3.domain.meta.Servicio_;

public final class CentroEscolarSpec {

    private CentroEscolarSpec() {
    }

    public static Specification<CentroEscolar> filterCE() {
    	/*
        if (CollectionUtils.isEmpty(categories)) {
            return null;
        }
        */
        return (root, query, builder) -> {
            Join<CentroEscolar,Infraestructura> CentroServicioJoin = root.join("infraestructura");
        //    Join<Servicio, Infraestructura> ServicioInfraJoin = root.join(Servicio_.FK_CENTRO_ESCOLAR);
          //  Join<Infraestructura, Necesidades> InfraNecesJoin = ServicioInfraJoin.join(Infraestructura_.FK_CENTRO_ESCOLAR);
            
            List<Predicate> list = new ArrayList<Predicate>();
            List<Predicate> list2 = new ArrayList<>();
            
            list.add(builder.equal(CentroServicioJoin.get(Infraestructura_.BIBLIOTECA),false ));
            list.add(builder.equal(CentroServicioJoin.get(Infraestructura_.BODEGA),true ));
            
            
       //     list.add( );
          //  list.push(   );
          
            //builder.equal(CentroServicioJoin.get(Infraestructura_.BODEGA),true );
            Predicate[] p = new Predicate[list.size()];
           // return buil
            return builder.and(list.toArray(p));
        };
    }
}
package com.TiendaM_IQ2023.Dao;

import com.TiendaM_IQ2023.domain.Articulo;
import org.springframework.data.repository.CrudRepository;


public interface ArticuloDao extends CrudRepository<Articulo, Long>{
    
}

package com.TiendaM_IQ2023.Dao;

import org.springframework.data.repository.CrudRepository;
import com.TiendaM_IQ2023.domain.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Long>{
    
}

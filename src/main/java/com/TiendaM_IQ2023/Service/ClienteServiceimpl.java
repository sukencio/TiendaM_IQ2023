package com.TiendaM_IQ2023.Service;

import com.TiendaM_IQ2023.Dao.ClienteDao;
import com.TiendaM_IQ2023.domain.Cliente;
import com.TiendaM_IQ2023.Dao.creditoDao;
import com.TiendaM_IQ2023.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ClienteServiceimpl implements ClienteService {
    
    
    @Autowired
    ClienteDao clienteDao;
    
    @Autowired
    creditoDao CreditoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        Credito credito = cliente.getCredito();
        CreditoDao.save(credito);
        
        cliente.setCredito(credito);
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.deleteById(cliente.getIdCliente());
    }
    
}

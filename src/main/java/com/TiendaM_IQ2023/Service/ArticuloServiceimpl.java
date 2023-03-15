package com.TiendaM_IQ2023.Service;


import com.TiendaM_IQ2023.Dao.ArticuloDao;
import com.TiendaM_IQ2023.domain.articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticuloServiceimpl implements ArticuloService{
    
    @Autowired
    ArticuloDao articuloDao;

    @Override
    @Transactional(readOnly = true)
    public List<articulo> getarticulo(boolean activo) {
        List<articulo> lista= (List<articulo>) articuloDao.findAll();
        
        if(activo)
        {
            lista.removeIf(e ->!e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public articulo getarticulo(articulo articulo) {
        return articuloDao.findById(articulo.getIdarticulo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(articulo articulo) {
        articuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(articulo articulo) {
        articuloDao.deleteById(articulo.getIdarticulo());
    }
    
}
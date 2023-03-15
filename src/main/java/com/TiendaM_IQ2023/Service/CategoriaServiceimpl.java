package com.TiendaM_IQ2023.Service;

import com.TiendaM_IQ2023.Dao.categoriaDao;
import com.TiendaM_IQ2023.domain.categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceimpl implements CategoriaService{
    
    @Autowired
    categoriaDao categoriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<categoria> getcategorias(boolean activos) {
        List<categoria> lista= (List<categoria>) categoriaDao.findAll();
        
        if(activos)
        {
            lista.removeIf(e ->!e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public categoria getcategoria(categoria categoria) {
        return categoriaDao.findById(categoria.getIdcategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(categoria categoria) {
        categoriaDao.deleteById(categoria.getIdcategoria());
    }
    
}

    


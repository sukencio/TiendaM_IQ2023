package com.TiendaM_IQ2023.Service;

import com.TiendaM_IQ2023.Dao.ArticuloDao;
import com.TiendaM_IQ2023.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticuloServiceimpl implements ArticuloService {

    @Autowired
    ArticuloDao articuloDao;

    @Override
    @Transactional(readOnly = true)
    public List<Articulo> getarticulo(boolean activos) {
        List<Articulo> lista = (List<Articulo>) articuloDao.findAll();

        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Articulo getarticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(Articulo articulo) {
        articuloDao.deleteById(articulo.getIdArticulo());
    }
}

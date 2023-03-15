package com.TiendaM_IQ2023.Service;

import com.TiendaM_IQ2023.domain.articulo;
import java.util.List;

public interface ArticuloService {

    public List<articulo> getarticulo(boolean activos);

    public articulo getarticulo(articulo articulo);

    public void save(articulo articulo);

    public void delete(articulo articulo);

}

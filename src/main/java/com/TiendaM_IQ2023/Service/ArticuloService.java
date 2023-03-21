package com.TiendaM_IQ2023.Service;

import com.TiendaM_IQ2023.domain.Articulo;
import java.util.List;

public interface ArticuloService {

    public List<Articulo> getarticulo(boolean activos);

    public Articulo getarticulo(Articulo articulo);

    public void save(Articulo articulo);

    public void delete(Articulo articulo);

}

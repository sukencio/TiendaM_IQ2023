package com.TiendaM_IQ2023.Service;

import com.TiendaM_IQ2023.domain.categoria;
import java.util.List;

public interface CategoriaService {

    public List<categoria> getcategorias(boolean activos);

    public categoria getcategoria(categoria categoria);

    public void save(categoria categoria);

    public void delete(categoria categoria);

}

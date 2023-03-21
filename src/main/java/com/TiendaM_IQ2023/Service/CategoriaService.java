package com.TiendaM_IQ2023.Service;

import com.TiendaM_IQ2023.domain.Categoria;
import java.util.List;

public interface CategoriaService {

    public List<Categoria> getCategorias(boolean activos);

    public Categoria getCategoria(Categoria categoria);

    public void save(Categoria categoria);

    public void delete(Categoria categoria);

}

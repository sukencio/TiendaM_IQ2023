package com.TiendaM_IQ2023.controller;

import com.TiendaM_IQ2023.Service.CategoriaService;
import com.TiendaM_IQ2023.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/categoria/listado")
    public String inicio(Model model) {

        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);

        return "/categoria/listado";

    }

    @GetMapping("/categoria/nuevo")
    public String nuevaCategoria(Categoria categoria) {
        return "/categoria/modificar";
    }

    @PostMapping("/categoria/guardar")
    public String guardarCategoria(Categoria categoria) {
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("//categoria/modificar/{Idcategoria}")
    public String modificarCategoria(Categoria categoria, Model model) {
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modificar";

    }

    @GetMapping("/eliminarCliente/{Idcategoria}")
    public String eliminarCliente(Categoria Categoria) {
        categoriaService.delete(Categoria);
        return "redirect:/categoria/listado";
    }
}

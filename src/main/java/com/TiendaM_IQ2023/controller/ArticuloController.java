package com.TiendaM_IQ2023.controller;

import com.TiendaM_IQ2023.Service.ArticuloService;
import com.TiendaM_IQ2023.Service.CategoriaService;
import com.TiendaM_IQ2023.domain.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticuloController {

    @Autowired
    ArticuloService articuloService;
    
    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/Articulo/listado")
    public String inicio(Model model) {

        var articulos = articuloService.getarticulo(false);
        model.addAttribute("Articulos", articulos);

        return "/Articulo/listado";
    }

    @GetMapping("/Articulo/nuevo")
    public String nuevaArticulo(Articulo Articulo, Model model) {
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        return "/Articulo/modificar";
    }

    @PostMapping("/Articulo/guardar")
    public String guardarArticulo(Articulo Articulo) {
        articuloService.save(Articulo);
        return "redirect:/Articulo/listado";
    }

    @GetMapping("//Articulo/modificar/{IdArticulo}")
    public String modificarArticulo(Articulo Articulo, Model model) {
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        
        Articulo = articuloService.getarticulo(Articulo);
        model.addAttribute("Articulo", Articulo);
        return "/Articulo/modificar";

    }

    @GetMapping("/eliminarCliente/{IdArticulo}")
    public String eliminarCliente(Articulo Articulo) {
        articuloService.delete(Articulo);
        return "redirect:/Articulo/listado";
    }

}

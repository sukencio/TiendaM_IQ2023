package com.TiendaM_IQ2023.controller;

import com.TiendaM_IQ2023.Service.ArticuloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    ArticuloService articuloService;

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora desde MVC");

        var articulos = articuloService.getarticulo(true);
        model.addAttribute("Articulos", articulos);

        return "Index";

    }

}

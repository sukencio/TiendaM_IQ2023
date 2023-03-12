package com.TiendaM_IQ2023.controller;

import com.TiendaM_IQ2023.domain.Cliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {
    
    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora desde MVC");
        model.addAttribute("mensaje", "Hola desde el controller");
        
        Cliente cliente = new Cliente("Jonathan","Brenes Blanco","jbrenesbl@gmail.com","88745906");
        model.addAttribute("objetocliente", cliente);
        
        Cliente cliente2 = new Cliente("Jonathan","Brenes Blanco","jbrenesbl@gmail.com","88745906");
        
        return "Index"; 
    }
    
}

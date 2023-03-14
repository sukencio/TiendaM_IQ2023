package com.TiendaM_IQ2023.controller;

import com.TiendaM_IQ2023.domain.Cliente;
import com.TiendaM_IQ2023.Dao.ClienteDao;
import java.util.List;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Controller
public class IndexController {
    
    @Autowired
    ClienteDao clienteDao;
    
    @GetMapping("/")
    public String inicio(Model model) {
    //    log.info("Ahora desde MVC");
    //    model.addAttribute("mensaje", "Hola desde el controller");
        
     //   Cliente cliente = new Cliente("Jonathan","Brenes Blanco","jbrenesbl@gmail.com","88745906");
    //    model.addAttribute("objetocliente", cliente);
        
     //   Cliente cliente2 = new Cliente("Luisa","Castro Blanco","luisacastro533@gmail.com","69852195");
     //   Cliente cliente3 = new Cliente("Carlos","Garcia Villalobos","villagarcia42@gmail.com","88793595");
        
     //   List<Cliente> clientes = Arrays.asList( cliente, cliente2, cliente3);
     
        var clientes = clienteDao.findAll();
        model.addAttribute("clientes", clientes);
        
        return "Index"; 
        
    }
    
}

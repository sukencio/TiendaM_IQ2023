package com.TiendaM_IQ2023.controller;

import com.TiendaM_IQ2023.Service.ClienteService;
import com.TiendaM_IQ2023.domain.Cliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora desde MVC");

        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);

        return "Index";

    }
    
    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente){
        return "modificarCliente";
    }
    
    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente)
    {
        clienteService.save(cliente);
        return "redirect:/";
    }
    
    @GetMapping("/modificarCliente/{Idcliente}")
    public String modificarCliente(Cliente cliente, Model model)
    {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modificarCliente";
        
    }
    @GetMapping("/eliminarCliente/{Idcliente}")
    public String eliminarCliente(Cliente cliente)
    {
        clienteService.delete(cliente);
        return "redirect:/";
    }

}

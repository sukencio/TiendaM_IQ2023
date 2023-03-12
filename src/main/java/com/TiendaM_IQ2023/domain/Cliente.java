
package com.TiendaM_IQ2023.domain;

import lombok.Data;

@Data
public class Cliente {
    
    private String nombre;
    private String Apellidos;
    private String Correo;
    private String Telefono;

    public Cliente() {
    }

    public Cliente(String nombre, String Apellidos, String Correo, String Telefono) {
        this.nombre = nombre;
        this.Apellidos = Apellidos;
        this.Correo = Correo;
        this.Telefono = Telefono;
    }
    
    
}

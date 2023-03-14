
package com.TiendaM_IQ2023.domain;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
    
    private static final long SerialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcliente;
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

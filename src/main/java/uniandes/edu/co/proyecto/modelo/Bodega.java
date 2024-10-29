package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bodegas")
public class Bodega {
    
    //Atributos
    @Id
    private String nombre;
    private Integer tamanio;
    
    @ManyToOne
    @JoinColumn(name = "nombre_sucursal", referencedColumnName = "nombre")
    private Sucursal nombre_sucursal;

    // Constructor
    public Bodega(String nombre, Integer tamanio, Sucursal nombre_sucursal) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.nombre_sucursal = nombre_sucursal;
    }

    // Constructor vacio
    public Bodega() {;}

    //GETTERS
    public String getNombre() {
        return nombre;
    }

    public Integer  getTamanio() {
        return tamanio;
    }

    public Sucursal getNombre_sucursal() {
        return nombre_sucursal;
    }

    //SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTamanio(Integer  tamanio) {
        this.tamanio = tamanio;
    }

    public void setNombre_sucursal(Sucursal nombre_sucursal) {
        this.nombre_sucursal = nombre_sucursal;
    }
}

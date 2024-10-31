package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventariodeproductos")
public class InventarioDeProducto {

    // Atributos
    @EmbeddedId
    private InventarioDeProductoPK pk;
    private Integer costoPromedio;
    private Integer cantidad;
    private Integer capacidad;
    private Integer nivelMinimoReorden;

    // Constructor
    public InventarioDeProducto(Bodega nombre_bodega, Producto codigoDeBarras_producto, Integer costoPromedio,
            Integer cantidad, Integer capacidad, Integer nivelMinimoReorden) {
        this.pk = new InventarioDeProductoPK(nombre_bodega, codigoDeBarras_producto);
        this.costoPromedio = costoPromedio;
        this.cantidad = cantidad;
        this.capacidad = capacidad;
        this.nivelMinimoReorden = nivelMinimoReorden;
    }

    // Constructor vacio
    public InventarioDeProducto() {
        ;
    }

    // GETTERS
    public InventarioDeProductoPK getPk() {
        return pk;
    }

    public Integer getCostoPromedio() {
        return costoPromedio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public Integer getNivelMinimoReorden() {
        return nivelMinimoReorden;
    }

    // SETTERS
    public void setPk(InventarioDeProductoPK pk) {
        this.pk = pk;
    }

    public void setCostoPromedio(Integer costoPromedio) {
        this.costoPromedio = costoPromedio;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setNivelMinimoReorden(Integer nivelMinimoReorden) {
        this.nivelMinimoReorden = nivelMinimoReorden;
    }
}
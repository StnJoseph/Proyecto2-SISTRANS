package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public class Item {

    // Atributos
    @EmbeddedId
    private ItemPK pk;
    private Integer cantidad;
    private Integer precio;

    // Constructor
    public Item(OrdenDeCompra ordendecompra_codigo, Producto produto_codigodebarras, Integer cantidad, Integer precio) {
        this.pk = new ItemPK(ordendecompra_codigo, produto_codigodebarras);
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Constructor vacio
    public Item() {
        ;
    }

    // Getters and Setters
    public ItemPK getPk() {
        return pk;
    }

    public void setPk(ItemPK pk) {
        this.pk = pk;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

}
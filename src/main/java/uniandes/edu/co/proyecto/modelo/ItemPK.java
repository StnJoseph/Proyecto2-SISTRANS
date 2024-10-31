package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Embeddable
public class ItemPK implements Serializable {

    // Atributos
    @ManyToOne
    @JoinColumn(name = "ordendecompra_codigo", referencedColumnName = "codigo")
    private OrdenDeCompra ordendecompra_codigo;

    @OneToOne
    @JoinColumn(name = "producto_codigodebarras", referencedColumnName = "codigo_de_barras")
    private Producto producto_codigodebarras;

    // Constructor
    public ItemPK(OrdenDeCompra ordendecompra_codigo, Producto producto_codigodebarras) {
        super();
        this.ordendecompra_codigo = ordendecompra_codigo;
        this.producto_codigodebarras = producto_codigodebarras;
    }

    // Constructor vacio
    public ItemPK() {
        super();
    }

    // Getters and Setters
    public OrdenDeCompra getOrdendecompra_codigo() {
        return ordendecompra_codigo;
    }

    public void setOrdendecompra_codigo(OrdenDeCompra ordendecompra_codigo) {
        this.ordendecompra_codigo = ordendecompra_codigo;
    }

    public Producto getProducto_codigodebarras() {
        return producto_codigodebarras;
    }

    public void setProducto_codigodebarras(Producto producto_codigodebarras) {
        this.producto_codigodebarras = producto_codigodebarras;
    }
}
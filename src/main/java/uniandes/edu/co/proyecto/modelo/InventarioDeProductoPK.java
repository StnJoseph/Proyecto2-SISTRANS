package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Embeddable
public class InventarioDeProductoPK implements Serializable {

    // Atributos
    @ManyToOne
    @JoinColumn(name = "bodega_nombre", referencedColumnName = "nombre")
    private Bodega bodega_nombre;

    @OneToOne
    @JoinColumn(name = "producto_codigodebarras", referencedColumnName = "codigo_de_barras")
    private Producto producto_codigodebarras;

    // Constructor
    public InventarioDeProductoPK(Bodega bodega_nombre, Producto producto_codigodebarras) {
        super();
        this.bodega_nombre = bodega_nombre;
        this.producto_codigodebarras = producto_codigodebarras;
    }

    // Constructor vacio
    public InventarioDeProductoPK() {
        super();
    }

    // GETTERS
    public Bodega getNombreBodega() {
        return bodega_nombre;
    }

    public Producto getCodigoDeBarras() {
        return producto_codigodebarras;
    }

    // SETTERS
    public void setNombreBodega(Bodega bodega_nombre) {
        this.bodega_nombre = bodega_nombre;
    }

    public void setCodigoDeBarras(Producto producto_codigodebarras) {
        this.producto_codigodebarras = producto_codigodebarras;
    }
}
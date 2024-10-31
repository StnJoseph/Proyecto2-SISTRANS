package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Embeddable
public class RecepcionDeProductoPK implements Serializable {

    // Atributos
    @ManyToOne
    @JoinColumn(name = "bodega_nombre", referencedColumnName = "nombre")
    private Bodega bodega_nombre;

    @OneToOne
    @JoinColumn(name = "ordendecompra_codigo", referencedColumnName = "codigo")
    private OrdenDeCompra ordendecompra_codigo;

    // Constructor
    public RecepcionDeProductoPK(Bodega bodega, OrdenDeCompra ordendecompra) {
        this.bodega_nombre = bodega;
        this.ordendecompra_codigo = ordendecompra;
    }

    public RecepcionDeProductoPK() {
    }

    public Bodega getBodega_nombre() {
        return bodega_nombre;
    }

    public void setBodega_nombre(Bodega bodega_nombre) {
        this.bodega_nombre = bodega_nombre;
    }

    public OrdenDeCompra getOrdendecompra_codigo() {
        return ordendecompra_codigo;
    }

    public void setOrdendecompra_codigo(OrdenDeCompra ordendecompra_codigo) {
        this.ordendecompra_codigo = ordendecompra_codigo;
    }

}
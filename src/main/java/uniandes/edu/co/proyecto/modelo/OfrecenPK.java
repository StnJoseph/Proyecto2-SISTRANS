package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OfrecenPK {

    @ManyToOne
    @JoinColumn(name = "proveedor_nit", referencedColumnName = "nit") 
    private Proveedor proveedor_nit;

    @ManyToOne
    @JoinColumn(name = "producto_codigodebarras", referencedColumnName = "codigo_de_barras") 
    private Producto producto_codigodebarras;

    public OfrecenPK() {
        super();
    }

    public OfrecenPK(Proveedor proveedor_nit, Producto producto_codigodebarras) {
        super();
        this.proveedor_nit = proveedor_nit;
        this.producto_codigodebarras = producto_codigodebarras;
    }

    public Proveedor getProveedor_nit() {
        return proveedor_nit;
    }

    public void setProveedor_nit(Proveedor proveedor_nit) {
        this.proveedor_nit = proveedor_nit;
    }

    public Producto getProducto_codigodebarras() {
        return producto_codigodebarras;
    }

    public void setProducto_codigodebarras(Producto producto_codigodebarras) {
        this.producto_codigodebarras = producto_codigodebarras;
    }
}

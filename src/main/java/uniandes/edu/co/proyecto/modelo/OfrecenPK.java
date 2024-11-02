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
    @JoinColumn(name = "producto_codigodebarras",referencedColumnName =   "codigo_de_barras") 
    private Producto producto_codigodebarras;

}

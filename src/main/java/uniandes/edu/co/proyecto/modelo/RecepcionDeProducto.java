package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "recepciondeproductos")
public class RecepcionDeProducto {

    // Atributos
    @EmbeddedId
    private RecepcionDeProductoPK pk;
    private Integer idrecepcion;

    // Constructor
    public RecepcionDeProducto(Bodega bodega, OrdenDeCompra ordendecompra, Integer idrecepcion) {
        this.pk = new RecepcionDeProductoPK(bodega, ordendecompra);
        this.idrecepcion = idrecepcion;
    }

    public RecepcionDeProducto() {
    }

    public RecepcionDeProductoPK getPk() {
        return pk;
    }

    public void setPk(RecepcionDeProductoPK pk) {
        this.pk = pk;
    }

    public Integer getIdrecepcion() {
        return idrecepcion;
    }

    public void setIdrecepcion(Integer idrecepcion) {
        this.idrecepcion = idrecepcion;
    }
}

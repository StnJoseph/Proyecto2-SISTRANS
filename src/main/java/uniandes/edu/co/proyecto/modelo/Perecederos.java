package uniandes.edu.co.proyecto.modelo;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "perecederos")
public class Perecederos extends Categoria {

    private Date fechaExpiracion;

    public Perecederos(Integer codigoCategoria, String nombreCategoria, String descripcion,String caracteristicasAlmacenamiento, Date fechaExpiracion) {
        super(codigoCategoria, nombreCategoria, descripcion, caracteristicasAlmacenamiento);
        this.fechaExpiracion = fechaExpiracion;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }   
}
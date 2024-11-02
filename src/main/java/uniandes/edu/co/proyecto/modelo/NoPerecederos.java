package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "no_perecederos")
public class NoPerecederos extends Categoria {

    public NoPerecederos(Integer codigoCategoria, String nombreCategoria, String descripcion,String caracteristicasAlmacenamiento) {
        super(codigoCategoria, nombreCategoria, descripcion, caracteristicasAlmacenamiento);
    }
}
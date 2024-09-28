package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bodega;

public interface BodegaRepository extends JpaRepository<Bodega, Integer>{
    
    @Query(value = "SELECT * FROM bodega", nativeQuery=true)
    Collection<Bodega> darBodegas();

    @Query(value = "SELECT * FROM bodega WHERE id= :id", nativeQuery=true)
    Bodega darBodega(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO bodega(id, nombre, tamanio, capacidad, id_sucursal) VALUES(secuencia_bodega.nextval, :nombre, :tamanio, :capacidad, :id_sucursal)", nativeQuery = true)
    void insertarBodega(@Param("nombre") String nombre, @Param("tamanio") Double tamanio, @Param("capacidad") Integer capacidad, @Param("id_sucursal") Integer idSucursal);

    @Modifying
    @Transactional
    @Query(value = "DELETE from bodega WHERE id = :id", nativeQuery= true)
    void eliminarBodega(@Param("id") int id);
}

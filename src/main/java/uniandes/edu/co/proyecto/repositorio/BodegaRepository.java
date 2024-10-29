package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bodega;

public interface BodegaRepository extends JpaRepository<Bodega, String> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO bodegas (nombre, tamanio, nombre_sucursal) VALUES (:nombre, :tamanio, :nombre_sucursal)", nativeQuery = true)
    void insertBodega(@Param("nombre") String nombre, @Param("tamanio") Integer tamanio, @Param("nombre_sucursal") String nombre_sucursal);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM bodegas WHERE nombre = :nombre", nativeQuery = true)
    void deleteBodega(@Param("nombre") String nombre);

    @Query(value = "SELECT * FROM bodegas", nativeQuery = true)
    Collection<Bodega> findAllBodegas();

    //@Query(value = "SELECT * FROM bodega WHERE id = :id", nativeQuery = true)
    //Bodega findBodegaById(@Param("id") int id);
   
    //@Modifying
    //@Transactional
    //@Query(value = "UPDATE bodega SET nombre = :nombre, tamanio = :tamanio WHERE id = :id", nativeQuery = true)
    //void updateBodega(@Param("id") long id, @Param("nombre") String nombre, @Param("tamanio") Integer tamanio);
}

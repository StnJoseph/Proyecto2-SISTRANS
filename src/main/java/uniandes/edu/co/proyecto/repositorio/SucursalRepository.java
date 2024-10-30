package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, String> {

    @Query(value = "SELECT * FROM sucursales", nativeQuery = true)
    Collection<Sucursal> findAllSucursales();   

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO sucursales (nombre, tamanio, direccion, telefono, codigo_ciudad) VALUES (:nombre, :tamanio, :direccion, :telefono, :codigo_ciudad)", nativeQuery = true)
    void insertSucursal(@Param("nombre") String nombre, @Param("tamanio") Integer tamanio, @Param("direccion") String direccion, @Param("telefono") Integer telefono, @Param("codigo_ciudad") Integer codigo_ciudad);
}

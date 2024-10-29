package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

    @Query(value = "SELECT * FROM proveedores", nativeQuery = true)
    Collection<Proveedor> findAllProveedores();

    @Query(value = "SELECT * FROM proveedores WHERE nit = :nit", nativeQuery = true)
    Proveedor findProveedorByNit(@Param("nit") Integer nit);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO proveedores (nit, nombre, direccion, nombre_contacto, telefono_contacto) VALUES (:nit, :nombre, :direccion, :nombre_contacto, :telefono_contacto)", nativeQuery = true)
    void insertProveedor(@Param("nit") Integer nit, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("nombre_contacto") String nombre_contacto, @Param("telefono_contacto") Integer telefono_contacto);

    @Modifying
    @Transactional
    @Query(value = "UPDATE proveedores SET nombre = :nombre, direccion = :direccion, nombre_contacto = :nombre_contacto, telefono_contacto = :telefono_contacto WHERE nit = :nit", nativeQuery = true)
    void updateProveedor(@Param("nit") Integer nit, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("nombre_contacto") String nombre_contacto, @Param("telefono_contacto") Integer telefono_contacto);

}
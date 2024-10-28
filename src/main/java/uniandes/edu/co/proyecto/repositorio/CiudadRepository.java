package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ciudades (codigo, nombre) VALUES (:codigo, :nombre)", nativeQuery = true)
    void insertCiudad(@Param("codigo") int codigo, @Param("nombre") String nombre);

    @Query(value = "SELECT * FROM ciudades", nativeQuery = true)
    Collection<Ciudad> findAllCiudades();

}

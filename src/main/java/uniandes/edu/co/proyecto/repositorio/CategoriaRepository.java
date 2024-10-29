package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {


    @Query(value = "SELECT * FROM categorias", nativeQuery = true)
    Collection<Categoria> findAllCategorias();

    @Query(value = "SELECT * FROM categorias WHERE codigo = :codigo", nativeQuery = true)
    Categoria findCategoriaById(@Param("codigo") Integer codigo);

    @Query(value = "SELECT * FROM categorias WHERE nombre = :nombre", nativeQuery = true)//funciona
    Categoria findCategoriaByNombre(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO categorias (codigo, nombre, descripcion, caracteristicas_almacenamiento) VALUES (:codigo, :nombre, :descripcion, :caracteristicas_almacenamiento)", nativeQuery = true)
    void insertCategoria(@Param("codigo") Integer codigo, 
                         @Param("nombre") String nombre, 
                         @Param("descripcion") String descripcion, 
                         @Param("caracteristicas_almacenamiento") String caracteristicas_almacenamiento);
} 
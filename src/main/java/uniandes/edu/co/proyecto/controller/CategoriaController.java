package uniandes.edu.co.proyecto.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Categoria;
import uniandes.edu.co.proyecto.repositorio.CategoriaRepository;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping("/categorias/new/save")
    public ResponseEntity<String> crearCategoria(@RequestBody Categoria categoria) {
        try {
            categoriaRepository.insertCategoria(categoria.getCodigo(), categoria.getNombre(), categoria.getDescripcion(), categoria.getCaracteristicas_almacenamiento());
                    return new ResponseEntity<>("Categoria creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la categoria", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/categorias/codigo/{codigo}")
    public ResponseEntity<?> darCategoriaPorCodigo(@PathVariable int codigo) {
        try {
            Optional<Categoria> categoria = categoriaRepository.findCategoriaById(codigo);
            return new ResponseEntity<>(categoria.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al leer la categoría: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/categorias/nombre/{nombre}")
    public ResponseEntity<?> darCategoriaPorNombre(@PathVariable String nombre) {
        try {
            Optional<Categoria> categoria = categoriaRepository.findCategoriaByNombre(nombre);
            return new ResponseEntity<>(categoria.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al leer la categoría: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
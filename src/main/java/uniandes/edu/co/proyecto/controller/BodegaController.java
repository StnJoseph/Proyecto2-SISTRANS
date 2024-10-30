package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository;

@RestController
public class BodegaController {

    @Autowired
    private BodegaRepository bodegaRepository;

    @PostMapping("/bodegas/new/save")
    public ResponseEntity<String> crearBodega(@RequestBody Bodega bodega) {
        try {
            bodegaRepository.insertBodega(bodega.getNombre(), bodega.getTamanio(), bodega.getNombre_sucursal().getNombre());
            return new ResponseEntity<>("Bodega creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/bodegas/bodega/{nombre}/delete")
    public ResponseEntity<String> eliminarBodega(@PathVariable("nombre") String nombre) {
        try {
            bodegaRepository.deleteBodega(nombre);
            return new ResponseEntity<>("Bodega eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    //RFC 3 
    // @GetMapping("/bodegas")
    // public ResponseEntity<Collection<Bodega>> getBodegas(@RequestParam(required = false) Integer id) {
    //     try {
    //         if (id != null) {
    //             Bodega bodega = bodegaRepository.findBodegaById(id);

    //             if (bodega != null) {

    //                 return new ResponseEntity<>();


    //             } else {

    //                 return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_FOUND);
    //             }
    //         } else {

    //             return new ResponseEntity<>(bodegaRepository.findAllBodegas(), HttpStatus.OK);
    //         }
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }


}



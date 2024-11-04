package uniandes.edu.co.proyecto.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository.IndiceOcupacionBodega;

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

    @DeleteMapping("/bodegas/{nombre}/delete")
    public ResponseEntity<String> eliminarBodega(@PathVariable("nombre") String nombre) {
        try {
            bodegaRepository.deleteBodega(nombre);
            return new ResponseEntity<>("Bodega eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // RFC1
    @GetMapping("/bodegas/ocupacion/{productos}")
    public ResponseEntity<Collection<IndiceOcupacionBodega>> obtenerIndiceDeOcupacion(@PathVariable("productos") List<String> productos) {
        try {
            Collection<IndiceOcupacionBodega> ocupaciones = new ArrayList<>();
            for (String codigo : productos) {
                IndiceOcupacionBodega ocupacion = bodegaRepository.obtenerIndiceDeOcupacion(codigo);
                ocupaciones.add(ocupacion);
            }
            return new ResponseEntity<>(ocupaciones, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
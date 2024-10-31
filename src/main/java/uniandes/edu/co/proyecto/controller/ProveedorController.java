package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Proveedor;
import uniandes.edu.co.proyecto.repositorio.ProveedorRepository;

@RestController
public class ProveedorController {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @PostMapping("/proveedores/new/save")
    public ResponseEntity<String> crearProveedor(@RequestBody Proveedor proveedor) {
        try {
            proveedorRepository.insertProveedor(proveedor.getNit(), proveedor.getNombre(), proveedor.getDireccion(), proveedor.getNombre_contacto(), proveedor.getTelefono_contacto());
            return new ResponseEntity<>("Proveedor creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/proveedores/{nit}/edit/save")
    public ResponseEntity<String> actualizarBodega(@PathVariable("nit") Integer nit, @RequestBody Proveedor proveedor) {
        try {
            proveedorRepository.updateProveedor(nit, proveedor.getNombre(), proveedor.getDireccion(), proveedor.getNombre_contacto(), proveedor.getTelefono_contacto());
            return ResponseEntity.ok("Proveedor actualizado exitosamente");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al editar el proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

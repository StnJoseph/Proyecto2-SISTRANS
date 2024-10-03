package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.MS;
import uniandes.edu.co.proyecto.modelo.Proveedor;
import uniandes.edu.co.proyecto.repositorio.ProveedorRepository;

@RestController
public class ProveedoresController {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @GetMapping("/proveedores")
    public Collection<Proveedor> darProveedores() {
        return proveedorRepository.findAll();
    }

    @PostMapping("/proveedores/new/save")
    public ResponseEntity<Map<String,Object>> proveedorGuardar(@RequestBody Proveedor proveedor) {
        proveedorRepository.insertarProveedor(proveedor.getNombre(),
                                              proveedor.getTelefono(),
                                              proveedor.getDireccion());
        Map<String,Object> response = MS.response("ok","create",proveedor);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/proveedores/{id}/edit/save")
    public ResponseEntity<Map<String,Object>> proveedorEditarGuardar(@PathVariable("id") Integer id, @RequestBody Proveedor proveedor) {
        try {
            proveedorRepository.actualizarProveedor(id,
                                                    proveedor.getNombre(),
                                                    proveedor.getTelefono(),
                                                    proveedor.getDireccion());
            Map<String,Object> response = MS.response("ok","update",proveedor);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String,Object> response = MS.response("not_ok","update",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

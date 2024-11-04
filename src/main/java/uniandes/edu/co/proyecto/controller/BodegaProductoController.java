package uniandes.edu.co.proyecto.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.service.BodegaProductoService;

@RestController
public class BodegaProductoController {

    @Autowired
    private BodegaProductoService bodegaProductoService;

    @GetMapping("/consulta_documentos_serializable")
    public List<Map<String, Object>> consultarDocumentosSerializable(
            @RequestParam String nombreSucursal, 
            @RequestParam String nombreBodega) throws InterruptedException {

        return bodegaProductoService.obtenerDocumentosIngreso(nombreSucursal, nombreBodega);
    }

    @GetMapping("/consulta_documentos_read_committed")
    public List<Map<String, Object>> consultarDocumentosReadCommitted(
            @RequestParam String nombreSucursal, 
            @RequestParam String nombreBodega) throws InterruptedException {

        return bodegaProductoService.obtenerDocumentosIngresoReadCommitted(nombreSucursal, nombreBodega);
    }
}










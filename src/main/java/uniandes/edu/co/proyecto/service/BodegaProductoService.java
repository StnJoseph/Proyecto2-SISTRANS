package uniandes.edu.co.proyecto.service;


import org.springframework.stereotype.Service;

@Service
public class BodegaProductoService {

    // @Autowired
    // private BodegaProductoRepository bodegaProductoRepository;

    // @Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    // public List<DocumentoIngreso> obtenerDocumentosIngreso(String nombreSucursal, String nombreBodega) throws InterruptedException {
    
    //     LocalDate fechaLimite = LocalDate.now().minus(30, ChronoUnit.DAYS);
       

    //     List<DocumentoIngreso> resultados = bodegaProductoRepository.findDocumentosIngresoBodega(nombreSucursal, nombreBodega);


    //     //eto es para probar 

    //     if (resultados.isEmpty()) {
    //         System.out.println("no sirvio :(  ");

    //     } else {
    //         System.out.println("Documentos de ingreso encontrados:");
    //         for (DocumentoIngreso documento : resultados) {
    //             System.out.println("Sucursal: " + documento.getNombreSucursal() + 
    //                                ", Bodega: " + documento.getNombreBodega() +
    //                                ", Proveedor: " + documento.getNombreProveedor() +
    //                                ", Documento: " + documento.getNumeroDocumento() +
    //                                ", Fecha: " + documento.getFechaDocumento());
    //         }
    //     }

    //     return resultados;
    // }
}

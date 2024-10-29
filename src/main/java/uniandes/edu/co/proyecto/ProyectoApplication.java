package uniandes.edu.co.proyecto;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.modelo.Ciudad;
import uniandes.edu.co.proyecto.modelo.Proveedor;
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository;
import uniandes.edu.co.proyecto.repositorio.CategoriaRepository;
import uniandes.edu.co.proyecto.repositorio.CiudadRepository;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;
import uniandes.edu.co.proyecto.repositorio.ProveedorRepository;
import uniandes.edu.co.proyecto.repositorio.SucursalRepository;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{

	@Autowired
	private ProductoRepository x;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String... arg)
	{
		// Collection<Producto> elemento = x.findAllProductos();
		// for (Producto b: elemento)
		// {
		// 	System.out.println("");
		// 	System.out.println(b.getCodigoDeBarras());
		// 	System.out.println(b.getNombre());
		// }

		//System.out.println(x.findProductoByCodigoDeBarras("0000000002").getNombre());
		x.updateProducto("0000000003", "Producto C", 4500.0, 2000.0, "Unidad", 4, "ml", 4.5, 8.0, 2);
	}

}

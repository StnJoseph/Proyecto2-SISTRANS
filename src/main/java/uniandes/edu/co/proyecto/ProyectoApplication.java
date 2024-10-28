package uniandes.edu.co.proyecto;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.modelo.Ciudad;
import uniandes.edu.co.proyecto.modelo.Sucursal;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository;
import uniandes.edu.co.proyecto.repositorio.CiudadRepository;
import uniandes.edu.co.proyecto.repositorio.SucursalRepository;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{

	@Autowired
	private BodegaRepository x;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}


	@Override
	public void run(String... arg)
	{
		// float y =  5200;
		// x.insertBodega("Bodega X", y, "Sucursal C");

		// Collection<Bodega> elemento = x.findAllBodegas();
		// for (Bodega b: elemento)
		// {
		// 	System.out.println("");
		// 	System.out.println(b.getNombre());
		// }

		x.deleteBodega("Bodega X");

		Collection<Bodega> elemento2 = x.findAllBodegas();
		for (Bodega b: elemento2)
		{
			System.out.println("");
			System.out.println(b.getNombre());


		}
	}

}

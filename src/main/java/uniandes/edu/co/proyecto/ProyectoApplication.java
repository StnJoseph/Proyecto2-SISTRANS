package uniandes.edu.co.proyecto;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.Ciudad;
import uniandes.edu.co.proyecto.repositorio.CiudadRepository;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{

	@Autowired
	private CiudadRepository ciudadRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}


	@Override
	public void run(String... arg)
	{
		Collection<Ciudad> ciudades = ciudadRepository.findAllCiudades();
		for (Ciudad b: ciudades)
		{
			System.out.println(b);
		}
	}

}

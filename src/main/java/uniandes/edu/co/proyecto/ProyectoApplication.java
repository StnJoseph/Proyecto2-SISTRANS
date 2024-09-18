package uniandes.edu.co.proyecto;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{
	
	@Autowired
	private BodegaRepository bodegaRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String...arg){

		bodegaRepository.eliminarBodega(5);

		Collection<Bodega> bodegas = bodegaRepository.darBodegas();
		for(Bodega b: bodegas){
			System.out.println(b.getId());
		}
	}
}

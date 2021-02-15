package co.edu.usco.prueba.parqueadero.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usco.prueba.parqueadero.model.Puesto;

@Repository
public interface IPuestoRepository extends JpaRepository<Puesto, Integer>{

	@Transactional
	@Query("from Puesto p where p.disponibilidad = true")
	public List<Puesto> listarPuestosDisponibles();
		
}

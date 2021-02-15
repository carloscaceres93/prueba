package co.edu.usco.prueba.parqueadero.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usco.prueba.parqueadero.model.Estudiante;

@Repository
public interface IEstudianteRepository extends JpaRepository<Estudiante, Integer> {
	
	@Transactional
	@Query("from Estudiante e where e.estado = true")
	public List<Estudiante> listarEstudianteDisponibles();

}

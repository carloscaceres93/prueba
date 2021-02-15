package co.edu.usco.prueba.parqueadero.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usco.prueba.parqueadero.model.PuestoEstudiante;

@Repository
public interface IPuestoEstudianteRepository extends JpaRepository<PuestoEstudiante, Integer> {

	@Transactional
	@Query("from PuestoEstudiante pe where pe.estado = true")
	public List<PuestoEstudiante> listarPuestosOcupados();
}
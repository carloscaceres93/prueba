package co.edu.usco.prueba.parqueadero.service;

import java.util.List;

import co.edu.usco.prueba.parqueadero.model.Estudiante;

public interface IEstudianteService extends ICrudService<Estudiante>{

	public List<Estudiante> listarEstudianteDisponibles();
	
	public void actualizarEstado(int id,  boolean estado);
}

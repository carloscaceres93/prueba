package co.edu.usco.prueba.parqueadero.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usco.prueba.parqueadero.model.Estudiante;
import co.edu.usco.prueba.parqueadero.repository.IEstudianteRepository;
import co.edu.usco.prueba.parqueadero.service.IEstudianteService;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

	@Autowired
	private IEstudianteRepository estudianteRepository;
	
	@Override
	public List<Estudiante> listarTodos() {
		
		return estudianteRepository.findAll();
	}

	@Override
	public Estudiante listarPorId(int id) {
		
		return estudianteRepository.findById(id).orElse(null);
	}

	@Override
	public Estudiante registrar(Estudiante entity) {
		return estudianteRepository.save(entity);	
	}
	
	@Override
	public Estudiante actualizar(Estudiante entity) {
		return estudianteRepository.save(entity);
		
	}


	@Override
	public void eliminar(int id) {
		estudianteRepository.deleteById(id);
	}

	@Override
	public List<Estudiante> listarEstudianteDisponibles() {
		return estudianteRepository.listarEstudianteDisponibles();
	}

	@Override
	public void actualizarEstado(int id, boolean estado) {
		Estudiante estudiante = this.listarPorId(id);
		estudiante.setEstado(estado);
		
		this.actualizar(estudiante);
		
	}

}

package co.edu.usco.prueba.parqueadero.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usco.prueba.parqueadero.model.PuestoEstudiante;
import co.edu.usco.prueba.parqueadero.repository.IPuestoEstudianteRepository;
import co.edu.usco.prueba.parqueadero.service.IEstudianteService;
import co.edu.usco.prueba.parqueadero.service.IPuestoEstuanteService;
import co.edu.usco.prueba.parqueadero.service.IPuestoService;

@Service
public class PuestoEstudianteImpl implements IPuestoEstuanteService {

	@Autowired
	private IPuestoEstudianteRepository puestoEstudianteRepository;

	@Autowired
	private IPuestoService puestoService;
	
	@Autowired
	private IEstudianteService estudianteService; 

	@Override
	public List<PuestoEstudiante> listarTodos() {

		return puestoEstudianteRepository.findAll();
	}

	@Override
	public PuestoEstudiante listarPorId(int id) {

		return puestoEstudianteRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public PuestoEstudiante registrar(PuestoEstudiante entity) {
		
		puestoService.actualizarEstado(entity.getIdPuesto().getId(), false);
		estudianteService.actualizarEstado(entity.getIdEstudiante().getId(), false);
		entity.setEstado(true);
		return puestoEstudianteRepository.save(entity);
	}

	@Override
	@Transactional
	public PuestoEstudiante actualizar(PuestoEstudiante entity) {
		
		puestoService.actualizarEstado(entity.getIdPuesto().getId(), true);
		estudianteService.actualizarEstado(entity.getIdEstudiante().getId(), true);
		
		entity.setEstado(false);
		return puestoEstudianteRepository.save(entity);
	}

	@Override
	public void eliminar(int id) {

		puestoEstudianteRepository.deleteById(id);

	}

	@Override
	public List<PuestoEstudiante> listarPuestosOcupados() {
		return puestoEstudianteRepository.listarPuestosOcupados();
	}

}

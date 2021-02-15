package co.edu.usco.prueba.parqueadero.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usco.prueba.parqueadero.model.Puesto;
import co.edu.usco.prueba.parqueadero.repository.IPuestoRepository;
import co.edu.usco.prueba.parqueadero.service.IPuestoService;

@Service
public class PuestoServiceImpl implements IPuestoService{

	@Autowired
	private IPuestoRepository puestoRespository;
	@Override
	public List<Puesto> listarTodos() {
		
		return puestoRespository.findAll();
	}

	@Override
	public Puesto listarPorId(int id) {
		
		return puestoRespository.findById(id).orElse(null);
	}

	@Override
	public Puesto registrar(Puesto entity) {
		return puestoRespository.save(entity);
		
	}

	@Override
	public Puesto actualizar(Puesto entity) {
		return puestoRespository.save(entity);
		
	}

	@Override
	public void eliminar(int id) {
		puestoRespository.deleteById(id);
		
	}

	@Override
	public List<Puesto> listarPuestosDisponibles() {
		
		return puestoRespository.listarPuestosDisponibles();
	}

	@Override
	public void actualizarEstado(int id, boolean estado) {
		
		Puesto puesto = this.listarPorId(id);
		puesto.setDisponibilidad(estado);
		
		this.actualizar(puesto);
	}
	

}

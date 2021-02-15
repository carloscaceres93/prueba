package co.edu.usco.prueba.parqueadero.service;

import java.util.List;

import co.edu.usco.prueba.parqueadero.model.PuestoEstudiante;

public interface IPuestoEstuanteService extends ICrudService<PuestoEstudiante>{
	
	public List<PuestoEstudiante> listarPuestosOcupados();
}

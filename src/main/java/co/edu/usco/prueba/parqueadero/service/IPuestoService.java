package co.edu.usco.prueba.parqueadero.service;

import java.util.List;

import co.edu.usco.prueba.parqueadero.model.Puesto;

public interface IPuestoService extends ICrudService<Puesto>{
	
	public List<Puesto> listarPuestosDisponibles();
	
	public void actualizarEstado(int id,  boolean estado);
}

package co.edu.usco.prueba.parqueadero.service;

import java.util.List;

public interface ICrudService <T>{

	public List<T> listarTodos();
	
	public T listarPorId(int id);
	
	public T registrar(T entity);
	
	public T actualizar(T entity);
	
	public void eliminar(int id);
}

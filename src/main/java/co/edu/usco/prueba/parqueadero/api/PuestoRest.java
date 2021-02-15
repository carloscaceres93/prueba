package co.edu.usco.prueba.parqueadero.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usco.prueba.parqueadero.model.Puesto;
import co.edu.usco.prueba.parqueadero.service.IPuestoService;

@RestController
@RequestMapping("/api/puestos")
public class PuestoRest {
	
	@Autowired
	private IPuestoService puestoService;
	
	@GetMapping("/listapuestosDisponibles")
	public List<Puesto> listarPuestosDisponibles(){
		
		return puestoService.listarPuestosDisponibles();
	}
	
	@GetMapping("/numeroPuestosDisponibles")
	public int numeroDePuestos(){
		
		return puestoService.listarPuestosDisponibles().size();
	}
	
	@GetMapping("/listarTodos")
	public List<Puesto> listarTodos() {
		
		return puestoService.listarTodos();
	}

	@GetMapping("/listarPorId")
	public Puesto listarPorId(@RequestParam int id) {
		
		return puestoService.listarPorId(id);
	}

	@PostMapping("/registrar")
	public void registrar(@RequestBody Puesto entity) {
		puestoService.registrar(entity);
		
	}

	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Puesto entity) {
		puestoService.actualizar(entity);
		
	}

	@DeleteMapping("/eliminar")
	public void eliminar(@RequestParam int id) {
		puestoService.eliminar(id);
		
	}
}

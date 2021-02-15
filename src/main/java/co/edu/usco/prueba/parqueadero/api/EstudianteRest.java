package co.edu.usco.prueba.parqueadero.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usco.prueba.parqueadero.model.Estudiante;
import co.edu.usco.prueba.parqueadero.service.IEstudianteService;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteRest {

	@Autowired
	private IEstudianteService estudianteService;

	@GetMapping("/listarTodos")
	public List<Estudiante> listarTodos() {
		return estudianteService.listarTodos();
	}
	
	@GetMapping("/listarEstudiantesDisponibles")
	public List<Estudiante> listarEstudiantesDisponobles(){
		return estudianteService.listarEstudianteDisponibles();
	}

	@GetMapping("/listarPorId")
	public ResponseEntity<?> listarPorId(@RequestParam int id) {

		Estudiante estudiante = null;
		Map<String, Object> response = new HashMap<>();

		try {
			estudiante = estudianteService.listarPorId(id);

		} catch (DataAccessException e) {
			response.put("mensaje", "el usuario (ID) no existe en la base de datos!");
			response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (estudiante == null) {
			response.put("mensaje", "el usuario no existe en la base de datos!");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Estudiante>(estudiante, HttpStatus.OK);
	}

	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody Estudiante entity) {

		Estudiante estudianteNew = null;
		Map<String, Object> response = new HashMap<>();

		if (entity.getId() != 0) {
			response.put("mensaje", "ha ocurrido un error al registrar el estudiante en la base de datos!,");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			estudianteNew = estudianteService.registrar(entity);

		} catch (DataAccessException e) {

			response.put("mensaje", "ha ocurrido un error al registrar el estudiante en la base de datos!");
			response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El estudiante se ha registrado con exíto!");
		response.put("cliente", estudianteNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody Estudiante entity) {

		Estudiante estudianteOld = estudianteService.listarPorId(entity.getId());
		Estudiante estudianteNew = null;
		Map<String, Object> response = new HashMap<>();

		if (estudianteOld == null) {
			response.put("mensaje", "Error: no se pudo editar, el usuario no exixte en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			estudianteNew = estudianteService.actualizar(entity);

		} catch (DataAccessException e) {

			response.put("mensaje", "ha ocurrido un error al actualizar el estudiante en la base de datos!");
			response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El usuario se ha actualizado con exíto!");
		response.put("Estudiante", estudianteNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	@DeleteMapping("/eliminar")
	public ResponseEntity<?> eliminar(@RequestParam int id) {
		Map<String, Object> response = new HashMap<>();

		try {
			estudianteService.eliminar(id);

		} catch (DataAccessException e) {

			response.put("mensaje", "ha ocurrido un error al eliminar el estudiante en la base de datos!");
			response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El usuario se ha eliminado con exíto!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}

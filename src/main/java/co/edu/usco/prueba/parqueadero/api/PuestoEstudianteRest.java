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

import co.edu.usco.prueba.parqueadero.model.PuestoEstudiante;
import co.edu.usco.prueba.parqueadero.service.IPuestoEstuanteService;

@RestController
@RequestMapping("/api/puestoEstudiante")
public class PuestoEstudianteRest {

	@Autowired
	private IPuestoEstuanteService puestoEstudianteService;

	@GetMapping("/listarTodos")
	public List<PuestoEstudiante> listarTodos() {
		return puestoEstudianteService.listarTodos();
	}
	
	@GetMapping("/listarPuestosOcupados")
	public List<PuestoEstudiante> listarPuestosOcupados(){
		return puestoEstudianteService.listarPuestosOcupados();
	}
	
	@GetMapping("/listarPorid")
	public ResponseEntity<?> listarPorId(@RequestParam int id) {

		PuestoEstudiante puestoEstudiante = null;
		Map<String, Object> response = new HashMap<>();

		try {
			puestoEstudiante = puestoEstudianteService.listarPorId(id);

		} catch (DataAccessException e) {
			response.put("mensaje", "el registro no existe en la base de datos!");
			response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (puestoEstudiante == null) {
			response.put("mensaje", "el rwgistro no existe en la base de datos!");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<PuestoEstudiante>(puestoEstudiante, HttpStatus.OK);
	}

	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody PuestoEstudiante entity) {

		PuestoEstudiante puestoestudianteNew = null;
		Map<String, Object> response = new HashMap<>();

		if (entity.getId() != 0) {
			response.put("mensaje", "ha ocurrido un error al hacer el registro en la base de datos!,");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			puestoestudianteNew = puestoEstudianteService.registrar(entity);

		} catch (DataAccessException e) {

			response.put("mensaje", "ha ocurrido un error al hacer el registro en la base de datos!");
			response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Se ha registrado con exíto!");
		response.put("cliente", puestoestudianteNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody PuestoEstudiante entity) {

		PuestoEstudiante puestoEstudianteOld = puestoEstudianteService.listarPorId(entity.getId());
		PuestoEstudiante puestoestudianteNew = null;
		Map<String, Object> response = new HashMap<>();

		if (puestoEstudianteOld == null) {
			response.put("mensaje", "Error: no se pudo editar, el registro no exixte en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			puestoestudianteNew = puestoEstudianteService.actualizar(entity);

		} catch (DataAccessException e) {

			response.put("mensaje", "ha ocurrido un error al hacer el registro en la base de datos!");
			response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Se ha actualizado con exíto!");
		response.put("cliente", puestoestudianteNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	@DeleteMapping("/eliminar")
	public ResponseEntity<?> eliminar(@RequestParam int id) {
		Map<String, Object> response = new HashMap<>();

		try {
			puestoEstudianteService.eliminar(id);

		} catch (DataAccessException e) {

			response.put("mensaje", "ha ocurrido un error al eliminar el registro en la base de datos!");
			response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El registro se ha eliminado con exíto!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}

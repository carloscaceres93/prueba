package co.edu.usco.prueba.parqueadero.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "estudiante", catalog = "parqueadero_usco")
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column (name = "numero_identificacion", unique = true, nullable = false, length = 40 )
	private String numeroIdentificacion;
	
	@Column (name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	@Column (name = "apellido", nullable = false, length = 50)
	private String apellido;
	
	@Column(name = "telefono", nullable = false, length = 10)
	private String telefono;
	
	@Column(name = "estado", nullable = false)
	private Boolean estado;
}

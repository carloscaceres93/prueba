package co.edu.usco.prueba.parqueadero.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "puesto_estudiante", catalog = "parqueadero_usco")
public class PuestoEstudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_estudiante", nullable = false)
	private Estudiante idEstudiante;
	
	@ManyToOne
	@JoinColumn(name = "id_puesto", nullable = false)
	private Puesto idPuesto;
	
	@Column(name = "estado", nullable = false)
	private Boolean estado;
}

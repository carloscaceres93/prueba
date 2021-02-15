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
@Table(name = "puesto", catalog = "parqueadero_usco")
public class Puesto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "lugar", nullable = false, length = 50)
	private String lugar;
	
	@Column(name = "disponibilidad", nullable = false)
	private Boolean disponibilidad;
}

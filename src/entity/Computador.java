package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Computador {
	private int idcomputador;
	private int idtipocomputador;   
	private String codigo;
	private String marca;
	private String modelo;
	private String procesador;
	private String ram;
	private String disco_duro;   
	private double precio;
	private String estado;
}

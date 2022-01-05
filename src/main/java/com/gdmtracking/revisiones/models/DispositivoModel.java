package com.gdmtracking.revisiones.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity//Etiqueta que define a una clase como entidad
@Table(name="dispositivos")//Etiqueta para definir el nombre de la tabla cuando es distinto al nombre de nuestra clase
@Data//Esta es una etiqueta de lombok que genera automaticamente los getters y setters
@AllArgsConstructor//Etiqueta Lombock que crea un contructor con todos sus argumentos
@NoArgsConstructor//Etiqueta Lombock que crea un constructor vacío
@Builder//Etiqueta Lombock  que permite hacer nuevas instancias de nuestra entidad

public class DispositivoModel {
	
	
	@Id//Etiqueta que indica que este campo es un ID (llave primaria)
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Etiqueta que indica que es autoincrementable
	@Column(unique = true, nullable = false)//Etiqueta que indica que es único y no puede ser null
	private Long id_dispositivo;
	
	
	
	private Long id_cliente;
	private Long id_vehiculo;
	
	private String imei;
	private String tipo;
	private String telefono;
	private String num_sim;
	private Date fech_instala;
	private String ubicacion;
	private String fech_ult_serv;
	private String tipo_serv;
		

}

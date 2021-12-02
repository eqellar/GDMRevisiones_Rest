package com.gdmtracking.revisiones.models;

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
@Table(name="usuarios")//Etiqueta para definir el nombre de la tabla cuando es distinto al nombre de nuestra clase
@Data//Esta es una etiqueta de lombok que genera automaticamente los getters y setters
@AllArgsConstructor//Etiqueta Lombock que crea un contructor con todos sus argumentos
@NoArgsConstructor//Etiqueta Lombock que crea un constructor vacío
@Builder//Etiqueta Lombock  que permite hacer nuevas instancias de nuestra entidad

public class UsuarioModel {
	
	
	@Id//Etiqueta que indica que este campo es un ID (llave primaria)
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Etiqueta que indica que es autoincrementable
	@Column(unique = true, nullable = false)//Etiqueta que indica que es único y no puede ser null	
    private Long id_usuario;
	
	
	
    private String nombre;
    private String apellidos;
    private Integer tipo;
    private String usuario;
    private String password;
	
	

}

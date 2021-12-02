package com.gdmtracking.revisiones.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdmtracking.revisiones.models.UsuarioModel;
import com.gdmtracking.revisiones.repositories.UsuarioRepository;

@Service//Etiqueta para indicar que esta es una clase de tipo servicio
public class UsuarioService {
	
	@Autowired //Etiqueta que hace que Spring sepa que existe una instacia de la variable y la use cuando la requiera
	UsuarioRepository usuarioRepository;//Declaramos el repositorio de usuario como una variable

	
	
	
	public ArrayList<UsuarioModel> obtenerUsuarios(){//Método que regresa varios objetos de tipo UsuarioModel
		return (ArrayList<UsuarioModel>)usuarioRepository.findAll();// En el return se hace un casting a UsuarioModel y de esta forma se puede regresar en formato Json
	}
	
	public UsuarioModel guardarUsuario(UsuarioModel usuario) {//Metodo que regresa un usuario y a la vez recibe un usuario del mismo tipo
		return usuarioRepository.save(usuario);// Le pasamos como parametru el usuario que queremos guardar, el metodo save lo guarda y a la vez lo regresa pero ya con un id asignado
		
	}
	
	
	public Optional<UsuarioModel> obtenerPorId(Long id_usuario){//Método que busca por id_usuario, el método sedefine como optional por si no existiera el id que se busca
		return usuarioRepository.findById(id_usuario);
		
	}
	
	
	public ArrayList<UsuarioModel> obtenerPorTipo(Integer tipo){//Método que obtiene objetos usuarioModel por tipo de usuario
		return usuarioRepository.findByTipo(tipo);//Mandamos a llamar al metod abstracto que implementamos en la clase repository
	}
	
	public boolean eliminarUsuario(Long id_usuario) {//Método de tipo Boolean que devuelve un true si el usuario se elimino correctamente y false si no lo hizo
		try {
			
			usuarioRepository.deleteById(id_usuario);
			return true;
			
		}catch(Exception e) {
			return false;
		}
	}
	
	
}

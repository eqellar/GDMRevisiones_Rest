package com.gdmtracking.revisiones.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gdmtracking.revisiones.models.UsuarioModel;
import com.gdmtracking.revisiones.services.UsuarioService;

@RestController//Etiqueta que define a esta clase como el controlador del servicio rest
@RequestMapping("/usuario")//Etiqueta que le indica al servidor en que dirección se van a activar los metodos de esta clase
public class UsuarioController {
	@Autowired//Etiqueta con la que importamos el servicio y también la intancia de esta clase
	UsuarioService usuarioService;
	
	@GetMapping()//Eqiueta para indicar que cada vez que reciba una petición de tipo GET ejecute ese flujo
	public ArrayList<UsuarioModel> obtenerUsuarios(){// Método que va a retornar la lista de todos los usuarios
		return usuarioService.obtenerUsuarios();// Los retorna con la ayuda del método que tenemos en el servico usuarioServicio
	}
	
	
	@PostMapping()//
	public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {//La etiqueta @RequestBody se usa para tomar la información de la petición HTTP y guardarla en el objeto usuario 
		return this.usuarioService.guardarUsuario(usuario);//Llamamos al metodo de nuestro servico guardaUsuario y le pasamos como paramtro el objeto usuario
	}
	
	
	@GetMapping( path ="/{id}")
	public Optional<UsuarioModel> ObtenerUsuarioPorId(@PathVariable("id")Long id_usuario){//Método que obtiene un usuario por medio del ID
		return this.usuarioService.obtenerPorId(id_usuario);
	}
	
	
	@GetMapping("/query")
	public ArrayList<UsuarioModel> obtenerUsuarioPorTipo(@RequestParam("tipo")Integer tipo){
		return this.usuarioService.obtenerPorTipo(tipo);
	}
	
	@DeleteMapping( path ="/{id}")
	public String eliminarPorId(@PathVariable("id")Long id_usuario) {
		boolean ok = this.usuarioService.eliminarUsuario(id_usuario);
		if(ok) {
			return "Se elimino el usuario con id " +id_usuario;
		}else {
			return "No fue posible eliminar el usuario con Id: "+id_usuario;
		}
	}
	
	
	
	

}

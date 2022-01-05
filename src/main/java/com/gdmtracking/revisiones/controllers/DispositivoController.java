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

import com.gdmtracking.revisiones.models.DispositivoModel;
import com.gdmtracking.revisiones.models.UsuarioModel;
import com.gdmtracking.revisiones.services.DispositivoService;

@RestController // Etiqueta que define a esta clase como el controlador del servicio rest
@RequestMapping("/dispositivo") // Etiqueta que le indica al servidor en que dirección se van a activar los
									// metodos de esta clase
public class DispositivoController {

	@Autowired // Etiqueta con la que importamos el servicio y también la intancia de esta clase
	DispositivoService dispositivoService;

	@GetMapping()//Eqiueta para indicar que cada vez que reciba una petición de tipo GET ejecute ese flujo
	public ArrayList<DispositivoModel> obtenerDispitivos(){// Método que va a retornar la lista de todos los dispositivos
		return dispositivoService.obtenerDispositivos();// Los retorna con la ayuda del método que tenemos en el servico DispositivoServicio
	}
	
	@PostMapping()//
	public DispositivoModel guardaDispositivo(@RequestBody DispositivoModel dispostivo) {//La etiqueta @RequestBody se usa para tomar la información de la petición HTTP y guardarla en el objeto dispositivo
		return this.dispositivoService.guaradaDispositivo(dispostivo);//Llamamos al metodo de nuestro servico guardaDispositivo y le pasamos como paramtro el objeto dispositivo
	}
	
	
	@GetMapping( path ="/{id}")
	public Optional<DispositivoModel>ObtenerDispotivoPorId(@PathVariable("id")Long id_dispositivo){//Método que obtiene un usuario por medio del ID
		return this.dispositivoService.obtenerPorId(id_dispositivo);
		
	}
	
	@GetMapping("/query")
	public ArrayList<DispositivoModel> obtenerUsuarioPorTipo(@RequestParam("tipo")String tipo){
		return this.dispositivoService.obtenerPorTipo(tipo);
	}
	
	@DeleteMapping( path ="/{id}")
	public String eliminarPorId(@PathVariable("id")Long id_dispositivo) {
		boolean ok = this.dispositivoService.eliminarDispositio(id_dispositivo);
		if(ok) {
			return "Se elimino el usuario con id " +id_dispositivo;
		}else {
			return "No fue posible eliminar el usuario con Id: "+id_dispositivo;
		}
	}
	

}

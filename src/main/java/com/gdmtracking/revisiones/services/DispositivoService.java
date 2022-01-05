package com.gdmtracking.revisiones.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdmtracking.revisiones.models.DispositivoModel;
import com.gdmtracking.revisiones.repositories.DispositivoRepository;

@Service//Etiqueta para indicar que esta es una clase de tipo servicio
public class DispositivoService {
	
	@Autowired //Etiqueta que hace que Spring sepa que existe una instacia de la variable y la use cuando la requiera
	DispositivoRepository dispositivoRepository; //Declaramos el repositorio de dispositivo como una variable
	
	public ArrayList<DispositivoModel> obtenerDispositivos(){//Método que regresa varios objetos de tipo DispositivoModel
		return (ArrayList<DispositivoModel>) dispositivoRepository.findAll();// En el return se hace un casting a DispositivoModel y de esta forma se puede regresar en formato Json
	}
	
	public DispositivoModel guaradaDispositivo(DispositivoModel dispositivo) {//Método que regresa varios objetos de tipo DispositivoModel
		return dispositivoRepository.save(dispositivo);// Le pasamos como parametro el disposiivo que queremos guardar, el metodo save lo guarda y a la vez lo regresa pero ya con un id asignado
		
	}
	
	public Optional<DispositivoModel> obtenerPorId(Long id_dispositivo){//Método que busca por id_usuario, el método se define como optional por si no existiera el id que se busca
		return dispositivoRepository.findById(id_dispositivo);// Le pasamos como parametru el id que queremos guardar, el metodo save lo guarda y a la vez lo regresa pero ya con un id asignado
	}
	
	public ArrayList<DispositivoModel> obtenerPorTipo(String tipo){//Método que obtiene objetos DispositivoModel por tipo de dispositivo
		return dispositivoRepository.findByTipo(tipo);//Mandamos a llamar al metod abstracto que implementamos en la clase repository
	}
	
	public boolean eliminarDispositio(Long id_dispositio) {//Método de tipo Boolean que devuelve un true si el dispositivo se elimino correctamente y false si no lo hizo
		try {
			
			dispositivoRepository.deleteById(id_dispositio);
			return true;
			
			
			
		}catch(Exception e) {
			return false;
		}
	}

}

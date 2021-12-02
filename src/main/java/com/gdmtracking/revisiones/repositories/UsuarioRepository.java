package com.gdmtracking.revisiones.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gdmtracking.revisiones.models.UsuarioModel;


@Repository //Etiqueta que indica que va a ser un repositorio dicho de otra forma una interface que va a implementar varios métodos
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {//Al extender de CrudRepository literal tenemos todos los métodos que requerimos en un CRUD
	
	public abstract ArrayList<UsuarioModel> findByTipo(Integer tipo);//Método que busca por tipo de uaurio
	

}

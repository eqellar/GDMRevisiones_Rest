package com.gdmtracking.revisiones.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gdmtracking.revisiones.models.DispositivoModel;


@Repository //Etiqueta que indica que va a ser un repositorio dicho de otra forma una interface que va a implementar varios métodos
public interface DispositivoRepository extends CrudRepository <DispositivoModel, Long> {
	public abstract ArrayList<DispositivoModel> findByTipo(String tipo); //Método que busca por tipo de disposiivo

}

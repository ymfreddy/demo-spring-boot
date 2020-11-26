package com.example.demo.services.repo;

import java.util.List;

import com.example.demo.entities.UsuarioEnt;

public interface IUsuarioServiceRepo {

	public List<UsuarioEnt> findAll();

	public UsuarioEnt findById(Long id);

	public UsuarioEnt save(UsuarioEnt usuario);

}

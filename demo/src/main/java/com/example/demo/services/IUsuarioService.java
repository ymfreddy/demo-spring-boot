package com.example.demo.services;

import java.util.List;

import com.example.demo.dtos.Usuario;

public interface IUsuarioService {

	public List<Usuario> listar();
	
	public Usuario guardar(Usuario usuario);

}

package com.example.demo.dao;

import java.util.List;

import com.example.demo.dtos.Usuario;

public interface IUsuarioDao {

	public List<Usuario> listar();

	public Usuario guardar(Usuario usuario);

}

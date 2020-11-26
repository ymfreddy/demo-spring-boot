package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUsuarioDao;
import com.example.demo.dtos.Usuario;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	IUsuarioDao iUsuarioDao;

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return iUsuarioDao.listar();
	}

	@Override
	public Usuario guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		return iUsuarioDao.guardar(usuario);
	}

}

package com.example.demo.services.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.UsuarioEnt;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioServiceRepoImpl implements IUsuarioServiceRepo{

	@Autowired
	private UsuarioRepository productoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<UsuarioEnt> findAll() {
		return (List<UsuarioEnt>) productoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public UsuarioEnt findById(Long id) {
		return productoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public UsuarioEnt save(UsuarioEnt producto) {
		return productoDao.save(producto);
	}

}

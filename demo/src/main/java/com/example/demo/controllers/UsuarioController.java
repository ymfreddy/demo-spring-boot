package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.Usuario;
import com.example.demo.entities.UsuarioEnt;
import com.example.demo.services.IUsuarioService;
import com.example.demo.services.repo.IUsuarioServiceRepo;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private IUsuarioService iUsuarioService;
	

	@Autowired
	private IUsuarioServiceRepo iUsuarioServiceRepo;

	@PostMapping("/guardar")
	public  Usuario guardar(@RequestBody Usuario solicitud) {
		return iUsuarioService.guardar(solicitud);
	}

	@GetMapping("/listar")
	public List<Usuario> listar(){
		return iUsuarioService.listar();
	}
	
	@GetMapping("/listar2")
	public List<UsuarioEnt> listar2(){
		return iUsuarioServiceRepo.findAll();
	}
	
	@PostMapping("/guardar2")
	public  UsuarioEnt guardar2(@RequestBody UsuarioEnt solicitud) {
		return iUsuarioServiceRepo.save(solicitud);
	}
}

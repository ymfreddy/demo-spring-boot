package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.UsuarioEnt;

public interface UsuarioRepository extends CrudRepository<UsuarioEnt, Long> {

}

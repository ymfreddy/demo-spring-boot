package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dtos.Usuario;

@Transactional
@Repository
public class UsuarioDao implements IUsuarioDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Usuario> listar() {
		String vSql = "select * from samv.users ";
		RowMapper<Usuario> vRowMapper = new BeanPropertyRowMapper<>(Usuario.class);
		List<Usuario> lista = jdbcTemplate.query(vSql, vRowMapper);
		return lista;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Usuario guardar(Usuario usuario) {
		String vSql = "INSERT INTO samv.users " + 
				"(username, \"password\") values (:username, :password);";

		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue("username", usuario.getUserName())
				.addValue("password", usuario.getPassword());
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(vSql, parameters, holder, new String[] { "id" });
		usuario.setId(holder.getKey().longValue());
		return usuario;
	}

}

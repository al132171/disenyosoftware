package es.uji.ei1038.ujinformatica.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1038.ujinformatica.dominio.Usuario;

@Repository
public class UsuarioDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final class UsuarioMapper implements RowMapper<Usuario> {
		public Usuario mapRow(ResultSet resultado, int rowNum)
				throws SQLException {
			Usuario usuario = new Usuario();
			usuario.setId(resultado.getInt("id"));
			usuario.setNickname(resultado.getString("nickname"));
			usuario.setContrasenya(resultado.getString("contrasenya"));
			usuario.setNombre(resultado.getString("nombre"));
			usuario.setApellidos(resultado.getString("apellidos"));
			usuario.setTipo(resultado.getString("tipo"));
			usuario.setEmail(resultado.getString("email"));
			usuario.setSuscritoNovedades(resultado.getString("suscritoNovedades"));
			return usuario;
		}
	}

	public List<Usuario> getUsuarios() { //muestra todos los usuarios
		if (this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM Usuario") == 0)
			return new ArrayList<Usuario>();
		return this.jdbcTemplate.query(
				"SELECT id, nickname, contrasenya, nombre, "
						+ "apellidos, tipo, email, suscritoNovedades FROM Usuario",
						new UsuarioMapper());
	}
	
	public List<Usuario> getObservers() { //muestra todos los usuarios
		if (this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM Usuario") == 0)
			return new ArrayList<Usuario>();
		return this.jdbcTemplate.query(
				"SELECT id, nickname, contrasenya, nombre, "
						+ "apellidos, tipo, email, suscritoNovedades FROM Usuario WHERE suscritoNovedades LIKE 'S'",
						new UsuarioMapper());
	}

	public Usuario getUsuario(String name, String contrasenya) {

		Usuario usuario;
		try {
			name = name.trim();
			contrasenya=contrasenya.trim().toLowerCase();
			usuario = this.jdbcTemplate.queryForObject("SELECT id, nickname, contrasenya, nombre, "
					+ "apellidos, tipo, email, suscritoNovedades FROM Usuario "
					+ " WHERE LOWER(nickname)=?", new Object[] {name}, new UsuarioMapper());
		} catch (IncorrectResultSizeDataAccessException e) {
			return null; // el usuario no está en a base de datos
		}

		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor(); 

		if (passwordEncryptor.checkPassword(contrasenya, usuario.getContrasenya())) {
			return usuario; 
		} else {
			return null; // contraseña mal
		}

	}



	public int addUsuario(Usuario usuario) {
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor(); 
		String contrasenya = passwordEncryptor.encryptPassword(usuario.getContrasenya());


		return this.jdbcTemplate
				.update("INSERT INTO Usuario(nickname, contrasenya, nombre, "
						+ "apellidos, tipo, email, suscritoNovedades) values(?, ?, ?, ?, ?, ?, ?)",
						usuario.getNickname(),
						contrasenya, usuario.getNombre(),
						usuario.getApellidos(), usuario.getTipo(),
						usuario.getEmail(), usuario.getSuscritoNovedades());


	}

	public void updateUsuario(Usuario usuario) {
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor(); 
		String contrasenya = passwordEncryptor.encryptPassword(usuario.getContrasenya());
		this.jdbcTemplate
		.update("UPDATE Usuario SET  contrasenya = ?, nombre = ?, apellidos = ?, email = ?, suscritoNovedades = ? where nickname  = ?",
				contrasenya,
				usuario.getNombre(), usuario.getApellidos(),
				usuario.getEmail(), usuario.getSuscritoNovedades(),
				usuario.getNickname());
	}

	public String deleteUsuario(int codUsuario) {
		try {
			this.jdbcTemplate.update(
					"DELETE FROM Usuario WHERE codUsuario=?", codUsuario);
			return "bien";
		} catch (Exception DataIntegrityViolationException) {
			return "mal";
		}
	}

	public Usuario loadUserByUsername(String nickname, String contrasenya) {
		Usuario usuario = getUsuarioPorNickname(nickname.trim());
		if (usuario == null)
			return null; // Usuari no trobat
		// Contrasenya
		BasicPasswordEncryptor contrasenyaEncryptor = new BasicPasswordEncryptor();
		if (contrasenyaEncryptor.checkPassword(contrasenya, usuario.getContrasenya())) {
			if (contrasenya.equals(usuario.getContrasenya())) {
				// Es deuria esborrar de manera segura el camp contrasenya abans de
				// tornar-lo
				return usuario;
			} else {
				return null; // bad login!
			}
		}
		return null;
	}

	public Usuario getUsuarioPorNickname(String nickname) {
		Usuario u =  this.jdbcTemplate.queryForObject(
				"SELECT id, nickname, contrasenya, nombre, "
					+ "apellidos, tipo, email, suscritoNovedades FROM Usuario where nickname = ?", new Object[] { nickname },
						new UsuarioMapper());
		
		return u;
	}

	public void updateUsuarioSinContrasenya(Usuario usuario) {
		this.jdbcTemplate
		.update("UPDATE Usuario SET  nombre = ?, apellidos = ?, email = ?, suscritoNovedades = ? where nickname  = ?",
				usuario.getNombre(), usuario.getApellidos(),
				usuario.getEmail(), usuario.getSuscritoNovedades(),
				usuario.getNickname());
	}

}

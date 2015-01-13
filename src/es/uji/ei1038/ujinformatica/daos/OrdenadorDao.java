package es.uji.ei1038.ujinformatica.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1038.ujinformatica.dominio.Ordenador;

@Repository
public class OrdenadorDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final class OrdenadorMapper implements RowMapper<Ordenador> {
		public Ordenador mapRow(ResultSet resultado, int rowNum)
				throws SQLException {
			Ordenador ordenador = new Ordenador();
			ordenador.setNombre(resultado.getString("nombre"));
			ordenador.setNickname(resultado.getString("nickname"));
			ordenador.setIdDiscoDuro(resultado.getInt("idDiscoDuro"));
			ordenador.setIdProcesador(resultado.getInt("idProcesador"));
			ordenador.setIdRAM(resultado.getInt("idRam"));
			ordenador.setIdUnidadDVD(resultado.getInt("idUnidadDVD"));
			ordenador.setIdMonitor(resultado.getInt("idMonitor"));
			ordenador.setIdTarjetaGrafica(resultado.getInt("idTarjetaGrafica"));
			ordenador.setIdPlacaBase(resultado.getInt("idPlacaBase"));
			ordenador.setIdOtros(resultado.getInt("idOtros"));
			ordenador.setPrecio(resultado.getDouble("precio"));
			ordenador.setDescripcion(resultado.getString("descripcion"));
			return ordenador;
		}
	}

	public List<Ordenador> getOrdenadores(String nickname) { //muestra todos los ordenadores de un usuario

		return this.jdbcTemplate.query(
				"SELECT nombre, nickname, idDiscoDuro, idProcesador, idRam, idUnidadDvd, idMonitor, idTarjetaGrafica, idPlacaBase, "
							+ "idOtros, precio, descripcion FROM Ordenador WHERE nickname = '"+nickname+"'", 
						new OrdenadorMapper());
	}

	/*
	 * busca si un usuario ya tiene un pc con el nombre especificado
	 * si lo tiene lo devuelve y si no devuelve nulo
	 * se usa en el validador de usuario, cuando intenta dar un nombre a un ordenador para guardarlo
	 */
	public boolean getOrdenadorUsuarioNombre(String nickname, String nombrePc) {   

		try {
			this.jdbcTemplate.queryForObject(
					"SELECT nombre, nickname, idDiscoDuro, idProcesador, idRam, idUnidadDvd, idMonitor, idTarjetaGrafica, idPlacaBase, "
							+ "idOtros, precio, descripcion FROM Ordenador WHERE nickname = '" + nickname + "' AND nombre = '" + nombrePc +"'"
							, new OrdenadorMapper());
			return true;
			
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}

	public int addOrdenador(Ordenador ordenador) {
		return this.jdbcTemplate
				.update("INSERT INTO Ordenador(nombre, nickname, idDiscoDuro, idProcesador, idRam, idUnidadDvd, idMonitor, idTarjetaGrafica, idPlacaBase, "
						+ "idOtros, precio, descripcion) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
						ordenador.getNombre(),ordenador.getNickname(), ordenador.getIdDiscoDuro(), ordenador.getIdProcesador(), ordenador.getIdRAM(),
						ordenador.getIdUnidadDVD(), ordenador.getIdMonitor(), ordenador.getIdTarjetaGrafica(), ordenador.getIdPlacaBase(), ordenador.getIdOtros(),
						ordenador.getPrecio(), ordenador.getDescripcion());


	}

	//	public void updateOrdenador(Ordenador ordenador) { //Un usuario no tiene que poder modificar un ordenador creado.
	//		this.jdbcTemplate
	//				.update("UPDATE Ordenador SET idDiscoDuro=?, idProcesador=?, idRam=?, idUnidadDvd=?, idMonitor=?, idTarjetaGrafica=?, idPlacaBase=?, "
	//						+ "idOtros=?, precio=? where nombre  = ? AND nickname = ?",
	//						ordenador.getNombre(),ordenador.getNickname(), ordenador.getIdDiscoDuro(), ordenador.getIdProcesador(), ordenador.getIdRAM(),
	//						ordenador.getIdUnidadDVD(), ordenador.getIdMonitor(), ordenador.getIdTarjetaGrafica(), ordenador.getIdPlacaBase(), ordenador.getIdOtros(),
	//						ordenador.getPrecio());
	//	}

	public String deleteOrdenador(String string) {
		try {
			this.jdbcTemplate.update(
					"DELETE FROM Ordenador WHERE nombre=?", string);
			return "bien";
		} catch (Exception DataIntegrityViolationException) {
			return "mal";
		}
	}

}

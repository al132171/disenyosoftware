package es.uji.ei1038.ujinformatica.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1038.ujinformatica.dominio.Procesador;

@Repository
public class ProcesadorDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final class ProcesadorMapper implements RowMapper<Procesador> {
		public Procesador mapRow(ResultSet resultado, int rowNum)
				throws SQLException {
			Procesador procesador = new Procesador();
			procesador.setId(resultado.getInt("id"));
			procesador.setModelo(resultado.getString("modelo"));
			procesador.setNucleos(resultado.getInt("nucleos"));
			procesador.setFrecuencia(resultado.getString("frecuencia"));
			procesador.setMarca(resultado.getString("marca"));
			procesador.setSocket(resultado.getString("socket"));
			procesador.setPrecio(resultado.getDouble("precio"));
			return procesador;
		}
	}

	public List<Procesador> getProcesadores() { //muestra todos los procesadors
		if (this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM Procesador") == 0)
			return new ArrayList<Procesador>();
		return this.jdbcTemplate.query(
				"SELECT id, modelo, nucleos, frecuencia, marca,"
						+ "socket, precio FROM Procesador",
						new ProcesadorMapper());
	}

	public Procesador getProcesador(int id) {
		if(this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM Procesador") == 0)
			return new Procesador();
		return this.jdbcTemplate.queryForObject("SELECT id, modelo, nucleos, frecuencia, marca,"
				+ "socket, precio FROM Procesador"
				+ " WHERE id=?",  new Object[] {id}, new ProcesadorMapper());
	}

	public void addProcesador(Procesador procesador) {
		this.jdbcTemplate
		.update("INSERT INTO Procesador(modelo, nucleos, frecuencia, marca,"
				+ "socket, precio) values(?, ?, ?, ?, ?, ?)",
				procesador.getModelo(), procesador.getNucleos(),
				procesador.getFrecuencia(), procesador.getMarca(), 
				procesador.getSocket(), procesador.getPrecio());

	}

	public void updateProcesador(Procesador procesador) {
		this.jdbcTemplate
		.update("UPDATE Procesador SET modelo=?, nucleos=?, frecuencia=?, marca=?,"
				+ "socket=?, precio=? where id  = ?",
				procesador.getModelo(), procesador.getNucleos(),
				procesador.getFrecuencia(), procesador.getMarca(), 
				procesador.getSocket(), procesador.getPrecio(),
				procesador.getId());
	}

	public String deleteProcesador(int id) {
		try {
			this.jdbcTemplate.update(
					"DELETE FROM Procesador WHERE id=?", id);
			return "bien";
		} catch (Exception DataIntegrityViolationException) {
			return "mal";
		}
	}

}

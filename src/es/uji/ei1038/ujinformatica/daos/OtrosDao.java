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

import es.uji.ei1038.ujinformatica.dominio.Otros;

@Repository
public class OtrosDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final class OtrosMapper implements RowMapper<Otros> {
		public Otros mapRow(ResultSet resultado, int rowNum)
				throws SQLException {
			Otros otros = new Otros();
			otros.setId(resultado.getInt("id"));
			otros.setNombre(resultado.getString("nombre"));
			otros.setDatos(resultado.getString("descripcion"));
			otros.setPrecio(resultado.getDouble("precio"));
			return otros;
		}
	}

	public List<Otros> getOtros() { //muestra todos los otross
		if (this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM Otros") == 0)
			return new ArrayList<Otros>();
		return this.jdbcTemplate.query(
				"SELECT id, nombre, descripcion,"
						+ "precio FROM Otros",
						new OtrosMapper());
	}

	public Otros getOtros(int id) {
		if(this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM Otros") == 0)
			return new Otros();
		return this.jdbcTemplate.queryForObject("SELECT id, nombre, descripcion,"
				+ "precio FROM Otros"
				+ " WHERE id=?",  new Object[] {id}, new OtrosMapper());
	}

	public void addOtros(Otros otros) {
		this.jdbcTemplate
		.update("INSERT INTO Otros(nombre, descripcion,"
				+ "precio) values(?, ?, ?)",
				otros.getNombre(),
				otros.getDatos(),
				otros.getPrecio());

	}

	public void updateOtros(Otros otros) {
		this.jdbcTemplate
		.update("UPDATE Otros SET nombre = ?, descripcion = ?, precio = ? where id  = ?",
				otros.getNombre(),
				otros.getDatos(),
				otros.getPrecio(),
				otros.getId());
	}

	public String deleteOtros(int id) {
		try {
			this.jdbcTemplate.update(
					"DELETE FROM Otros WHERE id=?", id);
			return "bien";
		} catch (Exception DataIntegrityViolationException) {
			return "mal";
		}
	}

}

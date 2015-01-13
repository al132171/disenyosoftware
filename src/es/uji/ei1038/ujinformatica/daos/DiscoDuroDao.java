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

import es.uji.ei1038.ujinformatica.dominio.DiscoDuro;

@Repository
public class DiscoDuroDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final class DiscoDuroMapper implements RowMapper<DiscoDuro> {
		public DiscoDuro mapRow(ResultSet resultado, int rowNum)
				throws SQLException {
			DiscoDuro discoDuro = new DiscoDuro();
			discoDuro.setId(resultado.getInt("id"));
			discoDuro.setInterfaz(resultado.getString("interfaz"));
			discoDuro.setCapacidad(resultado.getString("capacidad"));
			discoDuro.setCache(resultado.getString("cache"));
			discoDuro.setRpm(resultado.getString("rpm"));
			discoDuro.setPrecio(resultado.getDouble("precio"));
			return discoDuro;
		}
	}

	public List<DiscoDuro> getDiscosDuros() { //muestra todos los discoDuros
		if (this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM DiscoDuro") == 0)
			return new ArrayList<DiscoDuro>();
		return this.jdbcTemplate.query(
				"SELECT id, interfaz, capacidad, cache, "
						+ "rpm, precio FROM DiscoDuro",
						new DiscoDuroMapper());
	}

	public DiscoDuro getDiscoDuro(int id) {
		if(this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM DiscoDuro") == 0)
			return new DiscoDuro();
		return this.jdbcTemplate.queryForObject("SELECT id, interfaz, capacidad, cache, "
				+ "rpm, precio FROM DiscoDuro"
				+ " WHERE id=?",  new Object[] {id}, new DiscoDuroMapper());
	}

	public void addDiscoDuro(DiscoDuro discoDuro) {
		this.jdbcTemplate
		.update("INSERT INTO DiscoDuro(interfaz, capacidad, cache, "
				+ "rpm, precio) values(?, ?, ?, ?, ?)",
				discoDuro.getInterfaz(),
				Integer.parseInt(discoDuro.getCapacidad()), Integer.parseInt(discoDuro.getCache()),
				discoDuro.getRpm(),
				discoDuro.getPrecio());
	}

	public void updateDiscoDuro(DiscoDuro discoDuro) {
		this.jdbcTemplate
		.update("UPDATE DiscoDuro SET interfaz = ?, capacidad = ?, cache = ?, rpm = ?, precio = ? where id  = ?",
				discoDuro.getInterfaz(),
				Integer.parseInt(discoDuro.getCapacidad()), Integer.parseInt(discoDuro.getCache()),
				discoDuro.getRpm(),
				discoDuro.getPrecio(),
				discoDuro.getId());
	}

	public String deleteDiscoDuro(int id) {
		try {
			this.jdbcTemplate.update(
					"DELETE FROM DiscoDuro WHERE id=?", id);
			return "bien";
		} catch (Exception DataIntegrityViolationException) {
			return "mal";
		}
	}

}

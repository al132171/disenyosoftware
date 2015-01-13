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

import es.uji.ei1038.ujinformatica.dominio.Ram;

@Repository
public class RamDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final class RamMapper implements RowMapper<Ram> {
		public Ram mapRow(ResultSet resultado, int rowNum)
				throws SQLException {
			Ram ram = new Ram();
			ram.setId(resultado.getInt("id"));
			ram.setModelo(resultado.getString("modelo"));
			ram.setTipo(resultado.getString("tipo"));
			ram.setCapacidad(resultado.getInt("capacidad"));
			ram.setPrecio(resultado.getDouble("precio"));
			return ram;
		}
	}

	public List<Ram> getRams() { //muestra todos los rams
		if (this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM Ram") == 0)
			return new ArrayList<Ram>();
		return this.jdbcTemplate.query(
				"SELECT id, modelo, tipo, capacidad, precio FROM Ram",
				new RamMapper());
	}

	public Ram getRam(int id) {
		if(this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM Ram") == 0)
			return new Ram();
		return this.jdbcTemplate.queryForObject("SELECT id, modelo, tipo, capacidad, precio"
				+ " FROM Ram"
				+ " WHERE id=?",  new Object[] {id}, new RamMapper());
	}

	public void addRam(Ram ram) {
		this.jdbcTemplate
		.update("INSERT INTO Ram(modelo, tipo, capacidad, precio)"
				+ " values(?, ?, ?, ?)",
				ram.getModelo(), ram.getTipo(),
				ram.getCapacidad(), ram.getPrecio());

	}

	public void updateRam(Ram ram) {
		this.jdbcTemplate
		.update("UPDATE Ram SET modelo=?, tipo=?, capacidad=?, precio=?"
				+ " where id  = ?",
				ram.getModelo(), ram.getTipo(),
				ram.getCapacidad(), ram.getPrecio(),
				ram.getId());
	}

	public String deleteRam(int id) {
		try {
			this.jdbcTemplate.update(
					"DELETE FROM Ram WHERE id=?", id);
			return "bien";
		} catch (Exception DataIntegrityViolationException) {
			return "mal";
		}
	}
}

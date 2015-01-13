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

import es.uji.ei1038.ujinformatica.dominio.UnidadDVD;

@Repository
public class UnidadDVDDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final class UnidadDVDMapper implements RowMapper<UnidadDVD> {
		public UnidadDVD mapRow(ResultSet resultado, int rowNum)
				throws SQLException {
			UnidadDVD unidadDVD = new UnidadDVD();
			unidadDVD.setId(resultado.getInt("id"));
			unidadDVD.setTipo(resultado.getString("tipo"));
			unidadDVD.setInterfaz(resultado.getString("interfaz"));
			unidadDVD.setVelocidadEscritura(resultado.getString("velocidadEscritura"));
			unidadDVD.setPrecio(resultado.getDouble("precio"));
			return unidadDVD;
		}
	}

	public List<UnidadDVD> getDvds() { //muestra todos los unidadDVDs
		if (this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM UnidadDVD") == 0)
			return new ArrayList<UnidadDVD>();
		return this.jdbcTemplate.query(
				"SELECT id, tipo, interfaz, velocidadEscritura, precio FROM UnidadDVD",
				new UnidadDVDMapper());
	}

	public UnidadDVD getUnidadDVD(int id) {
		if(this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM UnidadDVD") == 0)
			return new UnidadDVD();
		return this.jdbcTemplate.queryForObject("SELECT id, tipo, interfaz, "
				+ "velocidadEscritura, precio FROM UnidadDVD"
				+ " WHERE id=?",  new Object[] {id}, new UnidadDVDMapper());
	}

	public void addUnidadDVD(UnidadDVD unidadDVD) {
		this.jdbcTemplate
		.update("INSERT INTO UnidadDVD(tipo, interfaz, "
				+ "velocidadEscritura, precio)"
				+ " values(?, ?, ?, ?)",
				unidadDVD.getTipo(), unidadDVD.getInterfaz(),
				unidadDVD.getVelocidadEscritura(), unidadDVD.getPrecio());
	}

	public void updateUnidadDVD(UnidadDVD unidadDVD) {
		this.jdbcTemplate
		.update("UPDATE UnidadDVD SET tipo=?, interfaz=?, "
				+ "velocidadEscritura=?, precio=? where id  = ?",
				unidadDVD.getTipo(), unidadDVD.getInterfaz(),
				unidadDVD.getVelocidadEscritura(), unidadDVD.getPrecio(),
				unidadDVD.getId());
	}

	public String deleteUnidadDVD(int id) {
		try {
			this.jdbcTemplate.update(
					"DELETE FROM UnidadDVD WHERE id=?", id);
			return "bien";
		} catch (Exception DataIntegrityViolationException) {
			return "mal";
		}
	}

}

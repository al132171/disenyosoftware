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

import es.uji.ei1038.ujinformatica.dominio.Monitor;

@Repository
public class MonitorDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final class MonitorMapper implements RowMapper<Monitor> {
		public Monitor mapRow(ResultSet resultado, int rowNum)
				throws SQLException {
			Monitor monitor = new Monitor();
			monitor.setId(resultado.getInt("id"));
			monitor.setPantalla(resultado.getString("pantalla"));
			monitor.setTamanyo(resultado.getString("tamanyo"));
			monitor.setResolucion(resultado.getString("resolucion"));
			monitor.setPrecio(resultado.getDouble("precio"));
			return monitor;
		}
	}

	public List<Monitor> getMonitores() { //muestra todos los monitores
		if (this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM Monitor") == 0)
			return new ArrayList<Monitor>();
		return this.jdbcTemplate.query(
				"SELECT id, pantalla, tamanyo, resolucion, "
						+ "precio FROM Monitor",
						new MonitorMapper());
	}

	public Monitor getMonitor(int id) {
		if(this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM Monitor") == 0)
			return new Monitor();
		return this.jdbcTemplate.queryForObject("SELECT id, pantalla, tamanyo, resolucion, "
				+ "precio FROM Monitor"
				+ " WHERE id=?",  new Object[] {id}, new MonitorMapper());
	}

	public void addMonitor(Monitor monitor) {
		this.jdbcTemplate
		.update("INSERT INTO Monitor(pantalla, tamanyo, resolucion, "
				+ "precio) values(?, ?, ?, ?)",
				monitor.getPantalla(),
				monitor.getTamanyo(), monitor.getResolucion(),
				monitor.getPrecio());

	}

	public void updateMonitor(Monitor monitor) {
		this.jdbcTemplate
		.update("UPDATE Monitor SET pantalla = ?, tamanyo = ?, resolucion = ?, "
				+ "precio = ? where id  = ?",
				monitor.getPantalla(),
				monitor.getTamanyo(), monitor.getResolucion(),
				monitor.getPrecio(), monitor.getId());
	}

	public String deleteMonitor(int id) {
		try {
			this.jdbcTemplate.update(
					"DELETE FROM Monitor WHERE id=?", id);
			return "bien";
		} catch (Exception DataIntegrityViolationException) {
			return "mal";
		}
	}

}

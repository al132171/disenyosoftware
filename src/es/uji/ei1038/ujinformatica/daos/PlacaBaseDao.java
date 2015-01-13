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

import es.uji.ei1038.ujinformatica.dominio.PlacaBase;

@Repository
public class PlacaBaseDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final class PlacaBaseMapper implements RowMapper<PlacaBase> {
		public PlacaBase mapRow(ResultSet resultado, int rowNum)
				throws SQLException {
			PlacaBase placaBase = new PlacaBase();
			placaBase.setId(resultado.getInt("id"));
			placaBase.setSocketProcesador(resultado.getString("socketProcesador"));
			placaBase.setInterfazDiscoDuro(resultado.getString("interfazDiscoDuro"));
			placaBase.setTipoRam(resultado.getString("tipoRam"));
			placaBase.setInterfazDvd(resultado.getString("interfazDVD"));
			placaBase.setBusTj(resultado.getString("busTJ"));
			placaBase.setModelo(resultado.getString("modelo"));
			placaBase.setPrecio(resultado.getDouble("precio"));
			return placaBase;
		}
	}

	public List<PlacaBase> getPlacasBase() { //muestra todos los placaBases
		if (this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM PlacaBase") == 0)
			return new ArrayList<PlacaBase>();
		return this.jdbcTemplate.query(
				"SELECT id, socketProcesador, interfazDiscoDuro, tipoRam, interfazDVD,"
						+ "busTJ, modelo, precio FROM PlacaBase",
						new PlacaBaseMapper());
	}

	public PlacaBase getPlacaBase(int id) {
		if(this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM PlacaBase") == 0)
			return new PlacaBase();
		return this.jdbcTemplate.queryForObject("SELECT id, socketProcesador, interfazDiscoDuro,"
				+ " tipoRam, interfazDVD,"
				+ "busTJ, modelo, precio FROM PlacaBase"
				+ " WHERE id=?",  new Object[] {id}, new PlacaBaseMapper());
	}

	public void addPlacaBase(PlacaBase placaBase) {
		this.jdbcTemplate
		.update("INSERT INTO PlacaBase(socketProcesador, interfazDiscoDuro,"
				+ " tipoRam, interfazDVD, busTJ, modelo, precio)"
				+ " values(?, ?, ?, ?, ?, ?, ?)",
				placaBase.getSocketProcesador(), placaBase.getInterfazDiscoDuro(),
				placaBase.getTipoRam(), placaBase.getInterfazDvd(), 
				placaBase.getBusTj(), placaBase.getModelo(), placaBase.getPrecio());

	}

	public void updatePlacaBase(PlacaBase placaBase) {
		this.jdbcTemplate
		.update("UPDATE PlacaBase SET socketProcesador=?, interfazDiscoDuro=?,"
				+ " tipoRam=?, interfazDVD=?, busTJ=?, modelo=?, precio=? where id  = ?",
				placaBase.getSocketProcesador(), placaBase.getInterfazDiscoDuro(),
				placaBase.getTipoRam(), placaBase.getInterfazDvd(), 
				placaBase.getBusTj(), placaBase.getModelo(), placaBase.getPrecio(),
				placaBase.getId());
	}

	public String deletePlacaBase(int id) {
		try {
			this.jdbcTemplate.update(
					"DELETE FROM PlacaBase WHERE id=?", id);
			return "bien";
		} catch (Exception DataIntegrityViolationException) {
			return "mal";
		}
	}
}

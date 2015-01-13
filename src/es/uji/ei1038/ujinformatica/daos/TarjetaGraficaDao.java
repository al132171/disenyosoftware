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

import es.uji.ei1038.ujinformatica.dominio.TarjetaGrafica;

@Repository
public class TarjetaGraficaDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final class TarjetaGraficaMapper implements RowMapper<TarjetaGrafica> {
		public TarjetaGrafica mapRow(ResultSet resultado, int rowNum)
				throws SQLException {
			TarjetaGrafica tarjetaGrafica = new TarjetaGrafica();
			tarjetaGrafica.setId(resultado.getInt("id"));
			tarjetaGrafica.setChipset(resultado.getString("chipset"));
			tarjetaGrafica.setMemoria(resultado.getString("memoria"));
			tarjetaGrafica.setTipoMemoria(resultado.getString("tipoMemoria"));
			tarjetaGrafica.setBus(resultado.getString("bus"));
			tarjetaGrafica.setPrecio(resultado.getDouble("precio"));
			return tarjetaGrafica;
		}
	}

	public List<TarjetaGrafica> getTarjetasGraficas() { //muestra todos los tarjetaGraficas
		if (this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM TarjetaGrafica") == 0)
			return new ArrayList<TarjetaGrafica>();
		return this.jdbcTemplate.query(
				"SELECT id, chipset, memoria, tipoMemoria, bus, precio FROM TarjetaGrafica",
				new TarjetaGraficaMapper());
	}

	public TarjetaGrafica getTarjetaGrafica(int id) {
		if(this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM TarjetaGrafica") == 0)
			return new TarjetaGrafica();
		return this.jdbcTemplate.queryForObject("SELECT id, chipset, memoria, tipoMemoria, bus,"
				+ " precio FROM TarjetaGrafica"
				+ " WHERE id=?",  new Object[] {id}, new TarjetaGraficaMapper());
	}

	public void addTarjetaGrafica(TarjetaGrafica tarjetaGrafica) {
		this.jdbcTemplate
		.update("INSERT INTO TarjetaGrafica(chipset, memoria, tipoMemoria, bus, precio)"
				+ " values(?, ?, ?, ?, ?)",
				tarjetaGrafica.getChipset(), tarjetaGrafica.getMemoria(),
				tarjetaGrafica.getTipoMemoria(), tarjetaGrafica.getBus(),
				tarjetaGrafica.getPrecio());
	}

	public void updateTarjetaGrafica(TarjetaGrafica tarjetaGrafica) {
		this.jdbcTemplate
		.update("UPDATE TarjetaGrafica SET chipset=?, memoria=?, tipoMemoria=?, "
				+ "bus=?, precio=? where id  = ?",
				tarjetaGrafica.getChipset(), tarjetaGrafica.getMemoria(),
				tarjetaGrafica.getTipoMemoria(), tarjetaGrafica.getBus(),
				tarjetaGrafica.getPrecio(),
				tarjetaGrafica.getId());
	}

	public String deleteTarjetaGrafica(int id) {
		try {
			this.jdbcTemplate.update(
					"DELETE FROM TarjetaGrafica WHERE id=?", id);
			return "bien";
		} catch (Exception DataIntegrityViolationException) {
			return "mal";
		}
	}

}

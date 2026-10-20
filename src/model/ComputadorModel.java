package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entity.Computador;
import util.MySqlDBConexion;

public class ComputadorModel {
	
	// 1. INSERTAR 
	public int insertarComputador(Computador computador) {
		int insertados = 0;
		String sql = "INSERT INTO computador (idtipocomputador, codigo, marca, modelo, procesador, ram, disco_duro, precio, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection con = MySqlDBConexion.getConexion();
			 PreparedStatement pstm = con.prepareStatement(sql)) {
			
			pstm.setInt(1, computador.getIdtipocomputador());
			pstm.setString(2, computador.getCodigo());
			pstm.setString(3, computador.getMarca());
			pstm.setString(4, computador.getModelo());
			pstm.setString(5, computador.getProcesador());
			pstm.setString(6, computador.getRam());
			pstm.setString(7, computador.getDisco_duro());
			pstm.setDouble(8, computador.getPrecio());
			pstm.setString(9, computador.getEstado());
			
			insertados = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insertados;
	}

	// 2. LISTAR (Para mostrar en la JTable)
	public List<Computador> listarComputador() {
		List<Computador> lista = new ArrayList<>();
		String sql = "SELECT * FROM computador";
		try (Connection con = MySqlDBConexion.getConexion();
			 PreparedStatement pstm = con.prepareStatement(sql);
			 ResultSet rs = pstm.executeQuery()) {
			
			while (rs.next()) {
				Computador c = new Computador();
				c.setIdcomputador(rs.getInt("idcomputador"));
				c.setIdtipocomputador(rs.getInt("idtipocomputador"));
				c.setCodigo(rs.getString("codigo"));
				c.setMarca(rs.getString("marca"));
				c.setModelo(rs.getString("modelo"));
				c.setProcesador(rs.getString("procesador"));
				c.setRam(rs.getString("ram"));
				c.setDisco_duro(rs.getString("disco_duro"));
				c.setPrecio(rs.getDouble("precio"));
				c.setEstado(rs.getString("estado"));
				lista.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	// 3. ACTUALIZAR / MODIFICAR
	public int actualizarComputador(Computador computador) {
		int actualizados = 0;
		String sql = "UPDATE computador SET idtipocomputador=?, codigo=?, marca=?, modelo=?, procesador=?, ram=?, disco_duro=?, precio=?, estado=? WHERE idcomputador=?";
		try (Connection con = MySqlDBConexion.getConexion();
			 PreparedStatement pstm = con.prepareStatement(sql)) {
			
			pstm.setInt(1, computador.getIdtipocomputador());
			pstm.setString(2, computador.getCodigo());
			pstm.setString(3, computador.getMarca());
			pstm.setString(4, computador.getModelo());
			pstm.setString(5, computador.getProcesador());
			pstm.setString(6, computador.getRam());
			pstm.setString(7, computador.getDisco_duro());
			pstm.setDouble(8, computador.getPrecio());
			pstm.setString(9, computador.getEstado());
			pstm.setInt(10, computador.getIdcomputador());
			
			actualizados = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return actualizados;
	}

	// 4. ELIMINAR
	public int eliminarComputador(int idcomputador) {
		int eliminados = 0;
		String sql = "DELETE FROM computador WHERE idcomputador=?";
		try (Connection con = MySqlDBConexion.getConexion();
			 PreparedStatement pstm = con.prepareStatement(sql)) {
			
			pstm.setInt(1, idcomputador);
			eliminados = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eliminados;
	}
}
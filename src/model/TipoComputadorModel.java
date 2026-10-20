package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entity.Tipocomputador;
import util.MySqlDBConexion; 

public class TipoComputadorModel {
    public List<Tipocomputador> listarTipoComputador() {
        List<Tipocomputador> lista = new ArrayList<>();
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            con = MySqlDBConexion.getConexion(); 
            String sql = "SELECT * FROM tipocomputador";
            pstm = con.prepareStatement(sql);
            System.out.println("SQL: " + pstm.toString());
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                Tipocomputador tipoComputador = new Tipocomputador();
                tipoComputador.setIdtipocomputador(rs.getInt("idtipocomputador"));
                tipoComputador.setNombre(rs.getString("nombre"));
                tipoComputador.setDescripcion(rs.getString("descripcion"));
                lista.add(tipoComputador);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return lista;
    }
}
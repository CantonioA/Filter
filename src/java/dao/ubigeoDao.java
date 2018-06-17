package dao;

import interfaces.ubigeoInterfaces;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ubigeoModel;

public class ubigeoDao extends Dao implements ubigeoInterfaces {

    @Override
    public List<ubigeoModel> departamento() throws Exception {
        this.Conectar();
        List<ubigeoModel> list;
        ResultSet rs;
        try {
            String sql = "Select DISTINCT(DEPUBI) FROM UBIGEO";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            rs = ps.executeQuery();
            list = new ArrayList();
            ubigeoModel model;
            while (rs.next()) {
                model = new ubigeoModel();
                model.setDepartamento(rs.getString("DEPUBI"));
                list.add(model);
            }
            return list;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<ubigeoModel> listar(String prov) throws Exception {
        List<ubigeoModel> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT * FROM UBIGEO WHERE PROUBI LIKE ? ";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, prov);
            rs = ps.executeQuery();
            lista = new ArrayList();
            ubigeoModel um;
            while (rs.next()) {
                um = new ubigeoModel();
                um.setCodigo(rs.getString("CODUBI"));
                um.setDepartamento(rs.getString("DEPUBI"));
                um.setProvincia(rs.getString("PROUBI"));
                um.setDistrito(rs.getString("DISUBI"));
                lista.add(um);
            }
            return lista;
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<ubigeoModel> provincia(String depar) throws Exception {
        this.Conectar();
        List<ubigeoModel> list;
        ResultSet rs;
        try {
            String sql = "Select DISTINCT(PROUBI) FROM UBIGEO where DEPUBI LIKE ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, depar);
            rs = ps.executeQuery();
            list = new ArrayList();
            ubigeoModel model;
            while (rs.next()) {
                model = new ubigeoModel();
                model.setProvincia(rs.getString("PROUBI"));
                list.add(model);
            }
            return list;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

}

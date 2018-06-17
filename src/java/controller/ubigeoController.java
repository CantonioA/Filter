/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ubigeoDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.ubigeoModel;

/**
 *
 * @author Cristhian
 */
@Named(value = "ubigeoController")
@SessionScoped
public class ubigeoController implements Serializable {

    ubigeoModel model = new ubigeoModel();
    private List<ubigeoModel> lstdepartamentos;
    private List<ubigeoModel> lstprovincia;
    private List<ubigeoModel> lstubigeo;
    private boolean table;
    
    @PostConstruct
    public void start(){
        try {
            departamento();
        } catch (Exception e) {
        }
}

    public void listar() throws Exception {
        ubigeoDao dao;
        try {
            table= true;
            dao = new ubigeoDao();
            lstubigeo = dao.listar(model.getProvincia());
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("LISTADO EXITOSAMENTE"));
        } catch (Exception e) {
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("ERROR AL LISTAR LISTADO"));
            throw e;
        }
    }

    /*listar el primer combo*/
    public void departamento() throws Exception {
        ubigeoDao dao;
        try {
            dao = new ubigeoDao();
            lstdepartamentos = dao.departamento();
        } catch (Exception e) {
            throw e;
        }
    }

    /*listar el Segundo combo*/
    public void provincia() throws Exception {
        ubigeoDao dao;
        try {
            dao = new ubigeoDao();
            lstprovincia = dao.provincia(model.getDepartamento());
        } catch (Exception e) {
            throw e;
        }
    }

    public ubigeoModel getModel() {
        return model;
    }

    public void setModel(ubigeoModel model) {
        this.model = model;
    }

    public List<ubigeoModel> getLstdepartamentos() {
        return lstdepartamentos;
    }

    public void setLstdepartamentos(List<ubigeoModel> lstdepartamentos) {
        this.lstdepartamentos = lstdepartamentos;
    }

    public boolean isTable() {
        return table;
    }

    public void setTable(boolean table) {
        this.table = table;
    }

    public List<ubigeoModel> getLstprovincia() {
        return lstprovincia;
    }

    public void setLstprovincia(List<ubigeoModel> lstprovincia) {
        this.lstprovincia = lstprovincia;
    }

    public List<ubigeoModel> getLstubigeo() {
        return lstubigeo;
    }

    public void setLstubigeo(List<ubigeoModel> lstubigeo) {
        this.lstubigeo = lstubigeo;
    }

}

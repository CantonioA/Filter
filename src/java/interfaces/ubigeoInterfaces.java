/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.ubigeoModel;

/**
 *
 * @author Cristhian
 */
public interface ubigeoInterfaces {

    List<ubigeoModel> listar(String prov) throws Exception;

    List<ubigeoModel> departamento() throws Exception;

    List<ubigeoModel> provincia(String depar) throws Exception;
}

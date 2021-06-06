/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import modelo.empresas.Empresa;

/**
 *
 * @author David
 */
public interface IService {
    public boolean write(Map<String,Empresa> empresa) throws IOException;
    public Optional<Map<String, Empresa>> read();
}

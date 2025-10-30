/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dto.Resposta;
import modelo.Registro;
import servico.RegistroServico;

/**
 *
 * @author loren
 */
public class RegistroControlador {
    private final RegistroServico servico = new RegistroServico();
    
    public Resposta<?> inserirRegistro(Registro r) {
        return servico.inserirRegistro(r);
    }
    
     public Resposta<?> listarRegistro() {
        return servico.listarRegistros();
    }
}

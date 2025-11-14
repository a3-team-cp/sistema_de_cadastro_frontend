package controlador;

import dto.Resposta;
import modelo.Registro;
import servico.RegistroServico;

/**
 *
 * @author lorenzo
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

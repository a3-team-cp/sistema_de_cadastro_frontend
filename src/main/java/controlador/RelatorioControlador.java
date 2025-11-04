package controlador;

import dto.Resposta;
import servico.RelatorioServico;

public class RelatorioControlador {

    private final RelatorioServico servico = new RelatorioServico();
    
    public Resposta<?> listarRelatorio() {
        return servico.listarRelatorio();
    }
}

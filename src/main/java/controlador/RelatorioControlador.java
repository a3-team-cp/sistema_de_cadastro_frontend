package controlador;

import dto.Resposta;
import servico.RelatorioServico;

/**
 * Controlador responsável por gerenciar as operações relacionadas a relatórios.
 *
 * <p>
 * Esta classe atua como uma camada intermediária entre a interface do usuário e
 * o serviço de relatórios, delegando as operações para o
 * {@link RelatorioServico}.</p>
 *
 * <p>
 * Fornece métodos para gerar e listar relatórios do sistema.</p>
 */
public class RelatorioControlador {

    /**
     * Instância do serviço de relatórios utilizado para executar as operações
     * de negócio.
     *
     * <p>
     * Esta instância é final e inicializada durante a construção do
     * controlador, garantindo que todas as operações sejam delegadas para o
     * mesmo serviço.</p>
     */
    private final RelatorioServico servico = new RelatorioServico();

    /**
     * Construtor padrão que inicializa o controlador de relatórios.
     */
    public RelatorioControlador() {
    }

    /**
     * Lista todos os relatórios disponíveis no sistema.
     *
     * @return uma {@link Resposta} contendo a lista de relatórios ou mensagem
     * de erro
     */
    public Resposta<?> listarRelatorio() {
        return servico.listarRelatorio();
    }
}

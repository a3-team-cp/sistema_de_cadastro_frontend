package servico;

import dto.Requisicao;
import dto.Resposta;
import modelo.enums.Acao;
import modelo.enums.Entidade;
import socket.ClientSocket;

/**
 * Serviço responsável por gerenciar as operações de negócio relacionadas a
 * relatórios.
 *
 * <p>
 * Esta classe implementa a lógica de comunicação com o servidor através do
 * {@link ClientSocket}, convertendo as operações em requisições padronizadas e
 * processando as respostas recebidas.</p>
 *
 * <p>
 * Fornece métodos para obter dados consolidadas para geração de relatórios.</p>
 */
public class RelatorioServico {

    /**
     * Lista todos os dados consolidadas disponíveis para relatórios.
     *
     * @return uma {@link Resposta} contendo a lista de dados para relatório ou
     * mensagem de erro
     */
    public Resposta<?> listarRelatorio() {
        Requisicao<Void> req = new Requisicao<>(Acao.LISTAR, Entidade.RELATORIO, null);
        return ClientSocket.enviarRequisicao(req);
    }
}

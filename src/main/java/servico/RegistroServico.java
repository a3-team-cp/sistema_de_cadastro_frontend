package servico;

import dto.Requisicao;
import dto.Resposta;
import modelo.Registro;
import modelo.enums.Acao;
import modelo.enums.Entidade;
import socket.ClientSocket;

/**
 * Serviço responsável por gerenciar as operações de negócio relacionadas a
 * registros.
 *
 * <p>
 * Esta classe implementa a lógica de comunicação com o servidor através do
 * {@link ClientSocket}, convertendo as operações em requisições padronizadas e
 * processando as respostas recebidas.</p>
 *
 * <p>
 * Fornece métodos para inserir e listar registros de movimentação do
 * sistema.</p>
 */
public class RegistroServico {

    /**
     * Insere um novo registro de movimentação no sistema.
     *
     * @param r objeto Registro contendo os dados do registro a ser inserido
     * @return uma {@link Resposta} contendo o resultado da operação (sucesso ou
     * erro)
     */
    public Resposta<?> inserirRegistro(Registro r) {
        Requisicao<Registro> req = new Requisicao<>(Acao.CRIAR, Entidade.REGISTRO, r);
        return ClientSocket.enviarRequisicao(req);
    }

    /**
     * Lista todos os registros de movimentação cadastrados no sistema.
     *
     * @return uma {@link Resposta} contendo a lista de registros ou mensagem de
     * erro
     */
    public Resposta<?> listarRegistros() {
        Requisicao<Void> req = new Requisicao<>(Acao.LISTAR, Entidade.REGISTRO, null);
        return ClientSocket.enviarRequisicao(req);
    }

}

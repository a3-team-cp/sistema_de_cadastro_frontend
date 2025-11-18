package servico;

import dto.Requisicao;
import dto.Resposta;
import modelo.Categoria;
import modelo.enums.Acao;
import modelo.enums.Entidade;
import socket.ClientSocket;

/**
 * Serviço responsável por gerenciar as operações de negócio relacionadas a
 * categorias.
 *
 * <p>
 * Esta classe implementa a lógica de comunicação com o servidor através do
 * ClientSocket, convertendo as operações em requisições padronizadas e
 * processando as respostas recebidas.</p>
 *
 * <p>
 * Utiliza o padrão de requisição baseado em Acao e Entidade para definir o tipo
 * de operação a ser executada no servidor.</p>
 */
public class CategoriaServico {

    /**
     * Instância de categoria utilizada internamente para operações específicas.
     *
     * <p>
     * Esta instância é mantida para suporte a operações que necessitam de
     * estado interno do serviço.</p>
     */
    private Categoria categotia;

    /**
     * Cria uma nova categoria no sistema através do servidor.
     *
     * @param categoria objeto Categoria contendo os dados da categoria a ser
     * criada
     * @return uma Resposta contendo o resultado da operação (sucesso ou erro)
     */
    public Resposta<?> criarCategoria(Categoria categoria) {
        Requisicao<Categoria> req = new Requisicao<>(Acao.CRIAR, Entidade.CATEGORIA, categoria);
        return ClientSocket.enviarRequisicao(req);
    }

    /**
     * Atualiza os dados de uma categoria existente no sistema.
     *
     * @param categoria objeto Categoria contendo os dados atualizados da
     * categoria
     * @return uma Resposta contendo o resultado da operação (sucesso ou erro)
     */
    public Resposta<?> atualizarCategoria(Categoria categoria) {
        Requisicao<Categoria> req = new Requisicao<>(Acao.ATUALIZAR, Entidade.CATEGORIA, categoria);
        return ClientSocket.enviarRequisicao(req);
    }

    /**
     * Remove uma categoria do sistema com base no ID fornecido.
     *
     * @param id identificador único da categoria a ser removida
     * @return uma Resposta contendo o resultado da operação (sucesso ou erro)
     */
    public Resposta<?> deletarCategoria(Integer id) {
        Categoria categoria = new Categoria(id, null, null, null);
        Requisicao<Categoria> req = new Requisicao<>(Acao.DELETAR, Entidade.CATEGORIA, categoria);
        return ClientSocket.enviarRequisicao(req);
    }

    /**
     * Busca uma categoria específica no sistema.
     *
     * @param categoria objeto Categoria contendo os critérios de busca
     * @return uma Resposta contendo a categoria encontrada ou mensagem de erro
     */
    public Resposta<?> encontrarCategoria(Categoria categoria) {
        Requisicao<Categoria> req = new Requisicao<>(Acao.ENCONTRAR, Entidade.CATEGORIA, categoria);
        return ClientSocket.enviarRequisicao(req);
    }

    /**
     * Lista todas as categorias cadastradas no sistema.
     *
     * @return uma Resposta contendo a lista de categorias ou mensagem de erro
     */
    public Resposta<?> listarCategoria() {
        Requisicao<Void> req = new Requisicao<>(Acao.LISTAR, Entidade.CATEGORIA, null);
        return ClientSocket.enviarRequisicao(req);
    }
}

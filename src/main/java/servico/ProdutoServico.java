package servico;

import dto.Requisicao;
import dto.Resposta;
import modelo.Produto;
import modelo.enums.Acao;
import modelo.enums.Entidade;
import socket.ClientSocket;

/**
 * Serviço responsável por gerenciar as operações de negócio relacionadas a produtos.
 *
 * <p>Esta classe implementa a lógica de comunicação com o servidor através do
 * ClientSocket, convertendo as operações em requisições padronizadas e processando
 * as respostas recebidas.</p>
 *
 * <p>Fornece métodos para operações CRUD básicas e operações específicas de
 * ajuste de preços em lote.</p>
 *
 */
public class ProdutoServico {

    /** Instância de produto utilizada internamente para operações específicas. */
    private Produto Produto;

    /**
     * Cria um novo produto no sistema através do servidor.
     *
     * @param produto objeto Produto contendo os dados do produto a ser criado
     * @return uma Resposta contendo o resultado da operação (sucesso ou erro)
     */
    public Resposta<?> criarProduto(Produto produto) {
        Requisicao<Produto> req = new Requisicao<>(Acao.CRIAR, Entidade.PRODUTO, produto);
        return ClientSocket.enviarRequisicao(req);
    }

    /**
     * Atualiza os dados de um produto existente no sistema.
     *
     * @param produto objeto Produto contendo os dados atualizados do produto
     * @return uma Resposta contendo o resultado da operação (sucesso ou erro)
     */
    public Resposta<?> atualizarProduto(Produto produto) {
        Requisicao<Produto> req = new Requisicao<>(Acao.ATUALIZAR, Entidade.PRODUTO, produto);
        return ClientSocket.enviarRequisicao(req);
    }

    /**
     * Remove um produto do sistema com base no ID fornecido.
     *
     * @param id identificador único do produto a ser removido
     * @return uma Resposta contendo o resultado da operação (sucesso ou erro)
     */
    public Resposta<?> deletarProduto(Integer id) {
        Produto produto = new Produto(id, null, null, null, null, null, null, null);
        Requisicao<Produto> req = new Requisicao<>(Acao.DELETAR, Entidade.PRODUTO, produto);
        return ClientSocket.enviarRequisicao(req);
    }

    /**
     * Busca um produto específico no sistema.
     *
     * @param produto objeto Produto contendo os critérios de busca
     * @return uma Resposta contendo o produto encontrado ou mensagem de erro
     */
    public Resposta<?> encontrarProduto(Produto produto) {
        Requisicao<Produto> req = new Requisicao<>(Acao.ENCONTRAR, Entidade.PRODUTO, produto);
        return ClientSocket.enviarRequisicao(req);
    }

    /**
     * Lista todos os produtos cadastrados no sistema.
     *
     * @return uma Resposta contendo a lista de produtos ou mensagem de erro
     */
    public Resposta<?> listarProduto() {
        Requisicao<Void> req = new Requisicao<>(Acao.LISTAR, Entidade.PRODUTO, null);
        return ClientSocket.enviarRequisicao(req);
    }

    /**
     * Aumenta o preço de todos os produtos por um percentual específico.
     *
     * @param percentual valor percentual a ser aplicado no aumento dos preços
     * @return uma Resposta contendo o resultado da operação (sucesso ou erro)
     */
    public Resposta<?> aumentarPrecoProduto(Double percentual) {
       Requisicao<Double> req = new Requisicao<>(Acao.AUMENTAR, Entidade.PRODUTO, percentual);
        return ClientSocket.enviarRequisicao(req);
    }

    /**
     * Diminui o preço de todos os produtos por um percentual específico.
     *
     * @param percentual valor percentual a ser aplicado na redução dos preços
     * @return uma Resposta contendo o resultado da operação (sucesso ou erro)
     */
    public Resposta<?> diminuirPrecoProduto(Double percentual) {
        Requisicao<Double> req = new Requisicao<>(Acao.DIMINUIR, Entidade.PRODUTO, percentual);
        return ClientSocket.enviarRequisicao(req);
    }
}
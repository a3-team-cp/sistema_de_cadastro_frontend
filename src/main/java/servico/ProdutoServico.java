package servico;

import dto.Requisicao;
import dto.Resposta;
import modelo.Produto;
import modelo.enums.Acao;
import modelo.enums.Entidade;
import socket.ClientSocket;

/**
 *
 * @author HenriqueBrosa
 */
public class ProdutoServico {

    private Produto Produto;

    public Resposta<?> criarProduto(Produto produto) {
        Requisicao<Produto> req = new Requisicao<>(Acao.CRIAR, Entidade.PRODUTO, produto);
        return ClientSocket.enviarRequisicao(req);
    }

    public Resposta<?> atualizarProduto(Produto produto) {
        Requisicao<Produto> req = new Requisicao<>(Acao.ATUALIZAR, Entidade.PRODUTO, produto);
        return ClientSocket.enviarRequisicao(req);
    }

    public Resposta<?> deletarProduto(Integer id) {
        Produto produto = new Produto(id, null, null, null, null, null, null, null);
        Requisicao<Produto> req = new Requisicao<>(Acao.DELETAR, Entidade.PRODUTO, produto);
        return ClientSocket.enviarRequisicao(req);
    }

    public Resposta<?> encontrarProduto(Produto produto) {
        Requisicao<Produto> req = new Requisicao<>(Acao.ENCONTRAR, Entidade.PRODUTO, produto);
        return ClientSocket.enviarRequisicao(req);
    }

    public Resposta<?> listarProduto() {
        Requisicao<Void> req = new Requisicao<>(Acao.LISTAR, Entidade.PRODUTO, null);
        return ClientSocket.enviarRequisicao(req);
    }
}

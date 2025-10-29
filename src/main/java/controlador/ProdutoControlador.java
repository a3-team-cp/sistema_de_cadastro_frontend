package controlador;

import dto.Resposta;
import modelo.Produto;
import servico.ProdutoServico;

/**
 *
 * @author HenriqueBrosa
 */
public class ProdutoControlador {

    private final ProdutoServico servico = new ProdutoServico();

    public Resposta<?> criarProduto(Produto produto) {
        return servico.criarProduto(produto);
    }

    public Resposta<?> atualizarProduto(Produto produto) {
        return servico.atualizarProduto(produto);
    }

    public Resposta<?> deletarProduto(Integer id) {
        return servico.deletarProduto(id);
    }

    public Resposta<?> encontrarProduto(Produto produto) {
        return servico.encontrarProduto(produto);
    }

    public Resposta<?> listarProduto() {
        return servico.listarProduto();
    }
}

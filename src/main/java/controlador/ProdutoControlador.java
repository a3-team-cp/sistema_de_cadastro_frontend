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

    public void criarProduto(Produto produto) {
        Resposta<?> resposta = servico.criarProduto(produto);
        System.out.println(resposta.getMensagem());
    }

    public void atualizarProduto(Produto produto) {
        Resposta<?> resposta = servico.atualizarProduto(produto);
        System.out.println(resposta.getMensagem());
    }

    public void deletarProduto(Integer id) {
        Resposta<?> resposta = servico.deletarProduto(id);
        System.out.println(resposta.getMensagem());
    }

    public void encontrarProduto(Produto produto) {
        Resposta<?> resposta = servico.encontrarProduto(produto);
        System.out.println(resposta.getMensagem());
    }

    public void listarProduto() {
        Resposta<?> resposta = servico.listarProduto();
        System.out.println(resposta.getMensagem());
    }
}

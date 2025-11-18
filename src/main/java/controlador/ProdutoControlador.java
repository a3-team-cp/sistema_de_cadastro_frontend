package controlador;

import dto.Resposta;
import modelo.Produto;
import servico.ProdutoServico;

/**
 * Controlador responsável por gerenciar as operações relacionadas a produtos.
 *
 * <p>
 * Esta classe atua como uma camada intermediária entre a interface do usuário e
 * o serviço de produtos, delegando as operações para o
 * {@link ProdutoServico}.</p>
 *
 * <p>
 * Fornece métodos para operações CRUD básicas e operações específicas de ajuste
 * de preços dos produtos.</p>
 */
public class ProdutoControlador {

    /**
     * Instância do serviço de produtos utilizado para executar as operações de
     * negócio.
     *
     * <p>
     * Esta instância é final e inicializada durante a construção do
     * controlador, garantindo que todas as operações sejam delegadas para o
     * mesmo serviço.</p>
     */
    private final ProdutoServico servico = new ProdutoServico();

    /**
     * Construtor padrão que inicializa o controlador de produtos.
     */
    public ProdutoControlador() {
    }

    /**
     * Cria um novo produto no sistema.
     *
     * @param produto objeto Produto contendo os dados do produto a ser criado
     * @return uma {@link Resposta} contendo o resultado da operação (sucesso ou
     * erro)
     */
    public Resposta<?> criarProduto(Produto produto) {
        return servico.criarProduto(produto);
    }

    /**
     * Atualiza os dados de um produto existente no sistema.
     *
     * @param produto objeto Produto contendo os dados atualizados do produto
     * @return uma {@link Resposta} contendo o resultado da operação (sucesso ou
     * erro)
     */
    public Resposta<?> atualizarProduto(Produto produto) {
        return servico.atualizarProduto(produto);
    }

    /**
     * Remove um produto do sistema com base no ID fornecido.
     *
     * @param id identificador único do produto a ser removido
     * @return uma {@link Resposta} contendo o resultado da operação (sucesso ou
     * erro)
     */
    public Resposta<?> deletarProduto(Integer id) {
        return servico.deletarProduto(id);
    }

    /**
     * Busca um produto específico no sistema.
     *
     * @param produto objeto Produto contendo os critérios de busca
     * @return uma {@link Resposta} contendo o produto encontrado ou mensagem de
     * erro
     */
    public Resposta<?> encontrarProduto(Produto produto) {
        return servico.encontrarProduto(produto);
    }

    /**
     * Lista todos os produtos cadastrados no sistema.
     *
     * @return uma {@link Resposta} contendo a lista de produtos ou mensagem de
     * erro
     */
    public Resposta<?> listarProduto() {
        return servico.listarProduto();
    }

    /**
     * Aumenta o preço de todos os produtos por um percentual específico.
     *
     * @param percentual valor percentual a ser aplicado no aumento dos preços
     * @return uma {@link Resposta} contendo o resultado da operação (sucesso ou
     * erro)
     */
    public Resposta<?> aumentarPrecoProduto(Double percentual) {
        return servico.aumentarPrecoProduto(percentual);
    }

    /**
     * Diminui o preço de todos os produtos por um percentual específico.
     *
     * @param percentual valor percentual a ser aplicado na redução dos preços
     * @return uma {@link Resposta} contendo o resultado da operação (sucesso ou
     * erro)
     */
    public Resposta<?> diminuirPrecoProduto(Double percentual) {
        return servico.diminuirPrecoProduto(percentual);
    }
}

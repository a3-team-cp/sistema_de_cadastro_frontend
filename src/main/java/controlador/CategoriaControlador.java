package controlador;

import dto.Resposta;
import modelo.Categoria;
import servico.CategoriaServico;

/**
 * Controlador responsável por gerenciar as operações relacionadas a categorias.
 *
 * <p>
 * Esta classe atua como uma camada intermediária entre a interface do usuário e
 * o serviço de categorias, delegando as operações para o
 * {@link CategoriaServico}.</p>
 *
 * <p>
 * Fornece métodos para todas as operações CRUD (Create, Read, Update, Delete)
 * relacionadas à entidade Categoria.</p>
 */
public class CategoriaControlador {

    /**
     * Instância do serviço de categorias utilizado para executar as operações
     * de negócio.
     *
     * <p>
     * Esta instância é final e inicializada durante a construção do
     * controlador, garantindo que todas as operações sejam delegadas para o
     * mesmo serviço.</p>
     */
    private final CategoriaServico servico = new CategoriaServico();

    /**
     * Construtor padrão que inicializa o controlador de categorias.
     */
    public CategoriaControlador() {
    }

    /**
     * Cria uma nova categoria no sistema.
     *
     * @param categoria objeto Categoria contendo os dados da categoria a ser
     * criada
     * @return uma {@link Resposta} contendo o resultado da operação (sucesso ou
     * erro)
     */
    public Resposta<?> criarCategoria(Categoria categoria) {
        return servico.criarCategoria(categoria);
    }

    /**
     * Atualiza os dados de uma categoria existente no sistema.
     *
     * @param categoria objeto Categoria contendo os dados atualizados da
     * categoria
     * @return uma {@link Resposta} contendo o resultado da operação (sucesso ou
     * erro)
     */
    public Resposta<?> atualizarCategoria(Categoria categoria) {
        return servico.atualizarCategoria(categoria);
    }

    /**
     * Remove uma categoria do sistema com base no ID fornecido.
     *
     * @param id identificador único da categoria a ser removida
     * @return uma {@link Resposta} contendo o resultado da operação (sucesso ou
     * erro)
     */
    public Resposta<?> deletarCategoria(Integer id) {
        return servico.deletarCategoria(id);
    }

    /**
     * Busca uma categoria específica no sistema.
     *
     * @param categoria objeto Categoria contendo os critérios de busca
     * @return uma {@link Resposta} contendo a categoria encontrada ou mensagem
     * de erro
     */
    public Resposta<?> encontrarCategoria(Categoria categoria) {
        return servico.encontrarCategoria(categoria);
    }

    /**
     * Lista todas as categorias cadastradas no sistema.
     *
     * @return uma {@link Resposta} contendo a lista de categorias ou mensagem
     * de erro
     */
    public Resposta<?> listarCategoria() {
        return servico.listarCategoria();
    }
}

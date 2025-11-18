package dto;

import modelo.enums.Acao;
import modelo.enums.Entidade;

/**
 * DTO responsável por representar uma requisição enviada ao servidor.
 *
 * <p>
 * Este objeto é transmitido em formato JSON via socket e convertido no servidor
 * para determinar qual entidade e qual ação devem ser executadas. O campo
 * {@code dados} contém as informações específicas necessárias para a execução
 * da operação.</p>
 *
 * <p>
 * O formato esperado corresponde a:</p>
 *
 * <pre>
 * {
 *   "acao": "CRIAR",
 *   "entidade": "PRODUTO",
 *   "dados": { ... }
 * }
 * </pre>
 *
 * @param <T> tipo do objeto contido no campo {@code dados}
 */
public class Requisicao<T> {

    /**
     * Ação a ser realizada (ex.: CRIAR, ATUALIZAR, LISTAR).
     */
    private Acao acao;

    /**
     * Entidade alvo da operação (ex.: CATEGORIA, PRODUTO, REGISTRO, RELATORIO).
     */
    private Entidade entidade;

    /**
     * Dados específicos da operação, cujo tipo varia conforme a entidade e a
     * ação.
     */
    private T dados;

    /**
     * Construtor padrão, necessário para serialização/deserialização JSON.
     */
    public Requisicao() {
    }

    /**
     * Construtor completo para criação manual de requisições.
     *
     * @param acao ação desejada
     * @param entidade entidade alvo
     * @param dados dados da operação
     */
    public Requisicao(Acao acao, Entidade entidade, T dados) {
        this.acao = acao;
        this.entidade = entidade;
        this.dados = dados;
    }

    /**
     * Obtém a ação solicitada na requisição.
     *
     * @return ação solicitada na requisição
     */
    public Acao getAcao() {
        return acao;
    }

    /**
     * Define a ação da requisição.
     *
     * @param acao define a ação da requisição
     */
    public void setAcao(Acao acao) {
        this.acao = acao;
    }

    /**
     * Obtém a entidade alvo da operação.
     *
     * @return entidade alvo da operação
     */
    public Entidade getEntidade() {
        return entidade;
    }

    /**
     * Define qual entidade será manipulada.
     *
     * @param entidade define qual entidade será manipulada
     */
    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }

    /**
     * Obtém os dados específicos que complementam a requisição.
     *
     * @return dados específicos que complementam a requisição
     */
    public T getDados() {
        return dados;
    }

    /**
     * Define os dados da operação.
     *
     * @param dados define os dados da operação
     */
    public void setDados(T dados) {
        this.dados = dados;
    }
}

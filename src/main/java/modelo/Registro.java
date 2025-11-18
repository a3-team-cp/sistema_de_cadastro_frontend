package modelo;

import java.util.Date;
import modelo.enums.Movimentacao;
import modelo.enums.Status;

/**
 * Registra uma movimentação de estoque de produto.
 *
 * <p>
 * Cada instância representa um evento de entrada ou saída de itens do estoque,
 * acompanhado de data, quantidade e status resultante da operação.</p>
 *
 * <p>
 * Utiliza as enumerações {@link Movimentacao} e {@link Status} para padronizar
 * os tipos de movimentação e situações do estoque.</p>
 */
public class Registro {

    /**
     * Identificador único do registro no banco de dados.
     */
    private Integer id;

    /**
     * Data e hora em que a movimentação ocorreu.
     */
    private Date data;

    /**
     * Identificador do produto que foi movimentado.
     */
    private Integer produtoId;

    /**
     * Quantidade de itens envolvidos na movimentação.
     */
    private Integer quantidade;

    /**
     * Tipo de movimentação (entrada ou saída).
     */
    private Movimentacao movimentacao;

    /**
     * Status resultante da movimentação no estoque.
     */
    private Status status;

    /**
     * Construtor padrão necessário para serialização e frameworks.
     */
    public Registro() {
    }

    /**
     * Construtor completo.
     *
     * @param id identificador do registro
     * @param data data da movimentação
     * @param produtoId ID do produto movimentado
     * @param quantidade quantidade envolvida
     * @param movimentacao tipo de movimentação
     * @param status status resultante
     */
    public Registro(Integer id, Date data, Integer produtoId, Integer quantidade, Movimentacao movimentacao, Status status) {
        this.id = id;
        this.data = data;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.movimentacao = movimentacao;
        this.status = status;
    }

    /**
     * Obtém o identificador do registro.
     *
     * @return o identificador único do registro
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o identificador do registro.
     *
     * @param id o identificador único a ser definido
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtém a data da movimentação.
     *
     * @return a data e hora em que a movimentação ocorreu
     */
    public Date getData() {
        return data;
    }

    /**
     * Define a data da movimentação.
     *
     * @param data a data e hora da movimentação a ser definida
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * Obtém o identificador do produto movimentado.
     *
     * @return o identificador do produto que foi movimentado
     */
    public Integer getProdutoId() {
        return produtoId;
    }

    /**
     * Define o identificador do produto movimentado.
     *
     * @param produtoId o identificador do produto a ser definido
     */
    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    /**
     * Obtém a quantidade movimentada.
     *
     * @return a quantidade de itens envolvidos na movimentação
     */
    public Integer getQuantidade() {
        return quantidade;
    }

    /**
     * Define a quantidade movimentada.
     *
     * @param quantidade a quantidade de itens a ser definida
     */
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Obtém o tipo de movimentação.
     *
     * @return o tipo de movimentação (entrada ou saída)
     */
    public Movimentacao getMovimentacao() {
        return movimentacao;
    }

    /**
     * Define o tipo de movimentação.
     *
     * @param movimentacao o tipo de movimentação a ser definido
     */
    public void setMovimentacao(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }

    /**
     * Obtém o status resultante.
     *
     * @return o status resultante da movimentação no estoque
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Define o status resultante.
     *
     * @param status o status resultante a ser definido
     */
    public void setStatus(Status status) {
        this.status = status;
    }
}

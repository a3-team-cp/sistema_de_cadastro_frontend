package modelo;

import java.util.Date;

/**
 * Representa um relatório de movimentações do sistema.
 *
 * <p>
 * Esta entidade agrega informações consolidadas sobre as movimentações de
 * estoque, incluindo dados do produto e situações ocorridas, facilitando a
 * geração de relatórios analíticos.</p>
 */
public class Relatorio {

    /**
     * Identificador único do registro do relatório.
     */
    private int id;

    /**
     * Identificador do produto relacionado.
     */
    private int produtoId;

    /**
     * Nome do produto para exibição no relatório.
     */
    private String nomeProduto;

    /**
     * Quantidade envolvida na movimentação.
     */
    private int quantidade;

    /**
     * Descrição do tipo de movimentação.
     */
    private String movimentacao;

    /**
     * Situação ou status da movimentação.
     */
    private String status;

    /**
     * Data em que a movimentação ocorreu.
     */
    private Date data;

    /**
     * Construtor padrão necessário para serialização e frameworks.
     */
    public Relatorio() {
    }

    /**
     * Construtor completo.
     *
     * @param id identificador do relatório
     * @param produtoId ID do produto
     * @param nomeProduto nome do produto
     * @param quantidade quantidade movimentada
     * @param movimentacao tipo de movimentação
     * @param status situação da movimentação
     * @param data data do evento
     */
    public Relatorio(int id, int produtoId, String nomeProduto, int quantidade, String movimentacao, String status, Date data) {
        this.id = id;
        this.produtoId = produtoId;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.movimentacao = movimentacao;
        this.status = status;
        this.data = data;
    }

    /**
     * Obtém o identificador do relatório.
     *
     * @return o identificador único do relatório
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador do relatório.
     *
     * @param id o identificador único a ser definido
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o identificador do produto.
     *
     * @return o identificador do produto relacionado
     */
    public int getProdutoId() {
        return produtoId;
    }

    /**
     * Define o identificador do produto.
     *
     * @param produtoId o identificador do produto a ser definido
     */
    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    /**
     * Obtém o nome do produto.
     *
     * @return o nome do produto para exibição no relatório
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * Define o nome do produto.
     *
     * @param nomeProduto o nome do produto a ser definido
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     * Obtém a quantidade movimentada.
     *
     * @return a quantidade envolvida na movimentação
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Define a quantidade movimentada.
     *
     * @param quantidade a quantidade envolvida a ser definida
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Obtém o tipo de movimentação.
     *
     * @return a descrição do tipo de movimentação
     */
    public String getMovimentacao() {
        return movimentacao;
    }

    /**
     * Define o tipo de movimentação.
     *
     * @param movimentacao a descrição do tipo de movimentação a ser definida
     */
    public void setMovimentacao(String movimentacao) {
        this.movimentacao = movimentacao;
    }

    /**
     * Obtém a situação da movimentação.
     *
     * @return a situação ou status da movimentação
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define a situação da movimentação.
     *
     * @param status a situação ou status a ser definido
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Obtém a data da movimentação.
     *
     * @return a data em que a movimentação ocorreu
     */
    public Date getData() {
        return data;
    }

    /**
     * Define a data da movimentação.
     *
     * @param data a data da movimentação a ser definida
     */
    public void setData(Date data) {
        this.data = data;
    }
}

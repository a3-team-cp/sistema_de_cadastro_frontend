package modelo;

/**
 * Representa um produto no sistema de controle de estoque.
 *
 * <p>
 * Esta entidade armazena todas as informações relevantes sobre um item
 * disponível no estoque, incluindo dados de identificação, preço, unidade de
 * medida e controles de quantidade para gestão eficiente do inventário.</p>
 *
 * <p>
 * Utiliza limites mínimo e máximo de quantidade para alertas e controles de
 * reposição automática.</p>
 */
public class Produto {

    /**
     * Identificador único do produto no banco de dados.
     */
    private Integer id;

    /**
     * Nome descritivo do produto.
     */
    private String nome;

    /**
     * Valor unitário do produto em moeda local.
     */
    private Double preco;

    /**
     * Unidade de medida do produto (ex.: unidade, litro, kg).
     */
    private String unidade;

    /**
     * Identificador da categoria à qual o produto pertence.
     */
    private Integer categoriaId;

    /**
     * Quantidade atual disponível em estoque.
     */
    private Integer quantidade;

    /**
     * Quantidade mínima permitida antes de gerar alerta.
     */
    private Integer quantidadeMinima;

    /**
     * Quantidade máxima permitida para controle de espaço.
     */
    private Integer quantidadeMaxima;

    /**
     * Construtor padrão necessário para serialização e frameworks.
     */
    public Produto() {
    }

    /**
     * Construtor completo que inicializa todos os atributos do produto.
     *
     * @param id identificador único do produto
     * @param nome nome descritivo do produto
     * @param preco valor unitário do produto
     * @param unidade unidade de medida do produto
     * @param categoriaId identificador da categoria associada ao produto
     * @param quantidade quantidade atual em estoque
     * @param quantidadeMinima quantidade mínima permitida em estoque
     * @param quantidadeMaxima quantidade máxima permitida em estoque
     */
    public Produto(Integer id, String nome, Double preco, String unidade, Integer categoriaId, Integer quantidade, Integer quantidadeMinima, Integer quantidadeMaxima) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.unidade = unidade;
        this.categoriaId = categoriaId;
        this.quantidade = quantidade;
        this.quantidadeMinima = quantidadeMinima;
        this.quantidadeMaxima = quantidadeMaxima;
    }

    /**
     * Obtém o identificador do produto.
     *
     * @return o identificador único do produto
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o identificador do produto.
     *
     * @param id o identificador único a ser definido
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtém o nome do produto.
     *
     * @return o nome descritivo do produto
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do produto.
     *
     * @param nome o nome descritivo a ser definido
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o preço unitário do produto.
     *
     * @return o valor unitário do produto
     */
    public Double getPreco() {
        return preco;
    }

    /**
     * Define o preço unitário do produto.
     *
     * @param preco o valor unitário a ser definido
     */
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    /**
     * Obtém a unidade de medida do produto.
     *
     * @return a unidade de medida do produto
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     * Define a unidade de medida do produto.
     *
     * @param unidade a unidade de medida a ser definida
     */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    /**
     * Obtém o identificador da categoria associada.
     *
     * @return o identificador da categoria do produto
     */
    public Integer getCategoriaId() {
        return categoriaId;
    }

    /**
     * Define o identificador da categoria associada.
     *
     * @param categoriaId o identificador da categoria a ser definido
     */
    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    /**
     * Obtém a quantidade atual em estoque.
     *
     * @return a quantidade atual disponível em estoque
     */
    public Integer getQuantidade() {
        return quantidade;
    }

    /**
     * Define a quantidade atual em estoque.
     *
     * @param quantidade a quantidade em estoque a ser definida
     */
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Obtém a quantidade mínima permitida.
     *
     * @return a quantidade mínima permitida em estoque
     */
    public Integer getQuantidadeMinima() {
        return quantidadeMinima;
    }

    /**
     * Define a quantidade mínima permitida.
     *
     * @param quantidadeMinima o limite mínimo de estoque a ser definido
     */
    public void setQuantidadeMinima(Integer quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    /**
     * Obtém a quantidade máxima permitida.
     *
     * @return a quantidade máxima permitida em estoque
     */
    public Integer getQuantidadeMaxima() {
        return quantidadeMaxima;
    }

    /**
     * Define a quantidade máxima permitida.
     *
     * @param quantidadeMaxima o limite máximo de estoque a ser definido
     */
    public void setQuantidadeMaxima(Integer quantidadeMaxima) {
        this.quantidadeMaxima = quantidadeMaxima;
    }
}

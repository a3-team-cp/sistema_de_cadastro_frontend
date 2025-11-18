package modelo;

import modelo.enums.Embalagem;
import modelo.enums.Tamanho;

/**
 * Representa uma categoria de produto dentro do sistema.
 *
 * <p>
 * Uma categoria define características comuns entre produtos, como nome,
 * tamanho e tipo de embalagem. Essa entidade é persistida no banco de dados e
 * utilizada para agrupar e classificar itens.</p>
 *
 * <p>
 * Os valores {@link Tamanho} e {@link Embalagem} definem atributos padronizados
 * que ajudam na organização e identificação do tipo de produto.</p>
 */
public class Categoria {

    /**
     * Identificador único da categoria no banco de dados.
     */
    private Integer id;

    /**
     * Nome descritivo da categoria (ex.: Bebidas, Enlatados, Limpeza).
     */
    private String nome;

    /**
     * Porte ou tamanho característico da categoria.
     */
    private Tamanho tamanho;

    /**
     * Tipo de embalagem predominante dos produtos da categoria.
     */
    private Embalagem embalagem;

    /**
     * Construtor padrão necessário para serialização e frameworks.
     */
    public Categoria() {
    }

    /**
     * Construtor completo.
     *
     * @param id identificador da categoria
     * @param nome nome da categoria
     * @param tamanho tamanho associado
     * @param embalagem tipo de embalagem predominante
     */
    public Categoria(Integer id, String nome, Tamanho tamanho, Embalagem embalagem) {
        this.id = id;
        this.nome = nome;
        this.tamanho = tamanho;
        this.embalagem = embalagem;
    }

    /**
     * Obtém o identificador da categoria.
     *
     * @return o identificador único da categoria
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o identificador da categoria.
     *
     * @param id o identificador único a ser definido
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtém o nome da categoria.
     *
     * @return o nome descritivo da categoria
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da categoria.
     *
     * @param nome o nome descritivo a ser definido
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o tamanho associado à categoria.
     *
     * @return o porte ou tamanho característico da categoria
     */
    public Tamanho getTamanho() {
        return tamanho;
    }

    /**
     * Define o tamanho associado à categoria.
     *
     * @param tamanho o porte ou tamanho a ser definido
     */
    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * Obtém o tipo de embalagem predominante.
     *
     * @return o tipo de embalagem característico da categoria
     */
    public Embalagem getEmbalagem() {
        return embalagem;
    }

    /**
     * Define o tipo de embalagem predominante.
     *
     * @param embalagem o tipo de embalagem a ser definido
     */
    public void setEmbalagem(Embalagem embalagem) {
        this.embalagem = embalagem;
    }
}

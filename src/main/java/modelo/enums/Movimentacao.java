package modelo.enums;

/**
 * Enumeração que define os tipos de movimentação de estoque.
 *
 * <p>
 * Representa as direções possíveis para movimentações de itens no controle de
 * estoque do sistema.</p>
 */
public enum Movimentacao {
    /**
     * Nenhuma movimentação
     */
    NENHUM,
    /**
     * Movimentação de entrada no estoque
     */
    ENTRADA,
    /**
     * Movimentação de saída do estoque
     */
    SAIDA;
}

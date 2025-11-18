package modelo.enums;

/**
 * Enumeração que define os status disponíveis no sistema.
 *
 * <p>
 * Representa diversos estados e situações que podem ocorrer durante as
 * operações do sistema, incluindo status de estoque e de operações.</p>
 */
public enum Status {
    /**
     * Quantidade acima do limite máximo
     */
    ACIMA,
    /**
     * Quantidade abaixo do limite mínimo
     */
    ABAIXO,
    /**
     * Quantidade dentro dos limites estabelecidos
     */
    DENTRO,
    /**
     * Item adicionado ao sistema
     */
    ADICIONADO,
    /**
     * Nome do item alterado
     */
    NOMEALTERADO,
    /**
     * Item deletado do sistema
     */
    DELETADO,
    /**
     * Status não definido ou padrão
     */
    NENHUM;
}

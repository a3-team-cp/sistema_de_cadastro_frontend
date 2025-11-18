package modelo.enums;

/**
 * Enumeração que define as ações disponíveis no sistema.
 *
 * <p>
 * Representa as operações básicas de CRUD (Create, Read, Update, Delete) e
 * operações específicas de negócio como aumento e diminuição de valores.</p>
 */
public enum Acao {
    /**
     * Operação para criar um novo registro
     */
    CRIAR,
    /**
     * Operação para buscar um registro específico
     */
    ENCONTRAR,
    /**
     * Operação para atualizar um registro existente
     */
    ATUALIZAR,
    /**
     * Operação para remover um registro
     */
    DELETAR,
    /**
     * Operação para listar todos os registros
     */
    LISTAR,
    /**
     * Operação para aumentar valores (ex: preços)
     */
    AUMENTAR,
    /**
     * Operação para diminuir valores (ex: preços)
     */
    DIMINUIR;
}

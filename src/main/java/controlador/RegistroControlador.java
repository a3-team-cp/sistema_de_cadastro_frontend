package controlador;

import dto.Resposta;
import modelo.Registro;
import servico.RegistroServico;

/**
 * Controlador responsável por gerenciar as operações relacionadas a registros.
 *
 * <p>
 * Esta classe atua como uma camada intermediária entre a interface do usuário e
 * o serviço de registros, delegando as operações para o
 * {@link RegistroServico}.</p>
 *
 * <p>
 * Fornece métodos para inserir e listar registros do sistema.</p>
 */
public class RegistroControlador {

    /**
     * Instância do serviço de registros utilizado para executar as operações de
     * negócio.
     *
     * <p>
     * Esta instância é final e inicializada durante a construção do
     * controlador, garantindo que todas as operações sejam delegadas para o
     * mesmo serviço.</p>
     */
    private final RegistroServico servico = new RegistroServico();

    /**
     * Construtor padrão que inicializa o controlador de registros.
     */
    public RegistroControlador() {
    }

    /**
     * Insere um novo registro no sistema.
     *
     * @param r objeto Registro contendo os dados do registro a ser inserido
     * @return uma {@link Resposta} contendo o resultado da operação (sucesso ou
     * erro)
     */
    public Resposta<?> inserirRegistro(Registro r) {
        return servico.inserirRegistro(r);
    }

    /**
     * Lista todos os registros cadastrados no sistema.
     *
     * @return uma {@link Resposta} contendo a lista de registros ou mensagem de
     * erro
     */
    public Resposta<?> listarRegistro() {
        return servico.listarRegistros();
    }
}

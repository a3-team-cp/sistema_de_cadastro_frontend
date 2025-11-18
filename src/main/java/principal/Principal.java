package principal;

import visao.FrmMenuPrincipal;

/**
 * Classe principal responsável por iniciar a aplicação.
 *
 * <p>Esta classe contém o método main que é o ponto de entrada da aplicação,
 * responsável por criar e exibir a janela principal do sistema.</p>
 *
 * <p>Inicializa a interface gráfica do usuário através do FrmMenuPrincipal e torna
 * a janela visível para interação do usuário.</p>
 */
public class Principal {

    /**
     * Construtor padrão da classe principal.
     */
    public Principal() {
    }

    /**
     * Método principal que inicia a execução da aplicação.
     *
     * <p>Cria uma instância do formulário principal e o torna visível para o
     * usuário, iniciando assim o ciclo de vida da interface gráfica.</p>
     *
     * @param args argumentos de linha de comando (não utilizados nesta aplicação)
     */
    public static void main(String[] args) {
        FrmMenuPrincipal janela = new FrmMenuPrincipal();
        janela.setVisible(true);
    }
}
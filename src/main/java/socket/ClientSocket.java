package socket;

import dto.Requisicao;
import dto.Resposta;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import util.JsonUtil;

/**
 * Cliente socket responsável pela comunicação com o servidor via TCP/IP.
 *
 * <p>Esta classe fornece métodos estáticos para enviar requisições ao servidor e
 * receber respostas, utilizando JSON como formato de serialização de dados.</p>
 *
 * <p>Gerencia automaticamente a conexão socket, incluindo abertura e fechamento de
 * recursos, garantindo o uso adequado de recursos do sistema.</p>
 *
 * <p>Utiliza o padrão try-with-resources para garantir que os recursos de rede
 * sejam fechados adequadamente, mesmo em caso de exceções.</p>
 */
public class ClientSocket {
    
    /** Endereço do servidor ao qual as requisições serão enviadas. */
    private static final String HOST = "localhost";
    
    /** Porta do servidor na qual o serviço está escutando. */
    private static final int PORTA = 3001;

    /**
     * Construtor privado para impedir instanciação da classe.
     *
     * <p>Esta classe é um utilitário com métodos estáticos e não deve
     * ser instanciada.</p>
     */
    private ClientSocket() {
        // Impede instanciação
    }

    /**
     * Envia uma requisição para o servidor e retorna a resposta recebida.
     *
     * <p>Estabelece uma conexão socket com o servidor, serializa a requisição
     * em formato JSON, envia os dados e aguarda a resposta do servidor.</p>
     *
     * <p>Em caso de erro de comunicação, retorna uma resposta de erro padrão
     * contendo informações sobre a falha ocorrida.</p>
     *
     * @param requisicao objeto Requisicao contendo os dados da requisição a ser enviada
     * @return uma Resposta contendo o resultado processado pelo servidor ou mensagem de erro
     */
    public static Resposta<?> enviarRequisicao(Requisicao<?> requisicao) {
        try (Socket socket = new Socket(HOST, PORTA);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Serializa a requisição
            String jsonRequisicao = JsonUtil.toJson(requisicao);
            out.println(jsonRequisicao); // println garante o envio imediato

            // Aguarda a resposta do servidor
            String jsonResposta = in.readLine();

            // Converte a resposta JSON para objeto
            return JsonUtil.fromJson(jsonResposta, Resposta.class);

        } catch (IOException e) {
            System.out.println("Erro de IO: " + e.getMessage());
            // Retorna um objeto de erro padrão
            return new Resposta<>("ERRO", "Falha na comunicação com o servidor: " + e.getMessage(), null);
        }
    }
    
}
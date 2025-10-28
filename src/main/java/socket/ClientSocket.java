/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socket;

import dto.Requisicao;
import dto.Resposta;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import util.JsonUtil;

/**s
 *
 * @author diego
 */
public class ClientSocket {
    
    private static final String HOST = "localhost";
    private static final int PORTA = 3001;

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

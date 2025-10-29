package servico;

import dto.Requisicao;
import dto.Resposta;
import modelo.Registro;
import modelo.enums.Acao;
import modelo.enums.Entidade;
import socket.ClientSocket;

/**
 *
 * @author loren
 */
public class RegistroServico {

    public Resposta<?> inserirRegistro(Registro r) {
        Requisicao<Registro> req = new Requisicao<>(Acao.CRIAR, Entidade.REGISTRO, r);
        return ClientSocket.enviarRequisicao(req);
    }

    public Resposta<?> listarRegistros() {
        Requisicao<Void> req = new Requisicao<>(Acao.LISTAR, Entidade.REGISTRO, null);
        return ClientSocket.enviarRequisicao(req);
    }

}

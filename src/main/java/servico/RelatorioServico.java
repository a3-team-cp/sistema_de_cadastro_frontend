package servico;

import dto.Requisicao;
import dto.Resposta;
import modelo.enums.Acao;
import modelo.enums.Entidade;
import socket.ClientSocket;

public class RelatorioServico {

    public Resposta<?> listarRelatorio() {
        Requisicao<Void> req = new Requisicao<>(Acao.LISTAR, Entidade.RELATORIO, null);
        return ClientSocket.enviarRequisicao(req);
    }
}
